package practice.message.queue;

import logger.TestLogger;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


public class MsgQueue {
	private int size;
	private int seqNo;
	private int processTimeout;
	private int maxFailCount;
	private int waitTime;
	private String name;
	private String test;

	// id - (status, msg)
	private LinkedHashMap<Integer, QueueInfo> hashMsg;

	private LinkedHashMap<Integer, QueueInfo> deadLetterMsg;

	public static Object mutex = new Object();

	ExecutorService es = Executors.newCachedThreadPool();

	public MsgQueue(int size) {
		this.size = size;
		this.seqNo = 0;
		hashMsg = new LinkedHashMap<Integer, QueueInfo>();
		deadLetterMsg = new LinkedHashMap<Integer, QueueInfo>();
	}

	public MsgQueue(int size, int processTimeout, int maxFailCount, int waitTime) {
		this(size);
		this.processTimeout = processTimeout;
		this.maxFailCount = maxFailCount;
		this.waitTime = waitTime;
	}

	public String MsgEnqueue(String msg) {
		if (hashMsg.size() == size)
			return "Queue Full";

		synchronized (mutex) {
			QueueInfo qInfo = new QueueInfo("A", msg);
			hashMsg.put(seqNo++, qInfo);
		}

//        return "Enqueued";
		return "Ok";
	}

	public String MsgDequeue() {
		if (hashMsg.size() == 0)
			return "Queue Empty";

		String res = null;
		synchronized (mutex) {
			int key = (int) hashMsg.keySet().iterator().next();

//	        String res = hashMsg.get(key).get(1) + "(" + key + ")";
			res = hashMsg.get(key).getMsg();

			hashMsg.remove(key);
		}

		return res;
	}

//	public String MsgGetBak() {
	public String MsgGet() {
		int checkLimit = 0;
		int activeSize = 0;
		if (this.waitTime > 0) {
			for (Integer key : hashMsg.keySet()) {
				if (hashMsg.get(key).getStatus().equals("A")) {
					activeSize++;
				}
			}
			checkLimit = (activeSize > 0) ? 0 : this.waitTime * 1000;
		}

		do {
			if (hashMsg.size() > 0)
				for (Integer key : hashMsg.keySet()) {
					if (hashMsg.get(key).getStatus().equals("A")) {
						QueueInfo qInfo = hashMsg.get(key);
						qInfo.setStatus("U");
						qInfo.setGetDate(System.currentTimeMillis());
						hashMsg.put(key, qInfo);
						return qInfo.getMsg() + "::" + key;
					}
				}
//			TestLogger.print(name + ", activeSize=" + activeSize + ", hashMsg.size()=" + hashMsg.size());
			try {
				Thread.sleep(10);
				checkLimit -= 10;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (checkLimit > 0);

		return "No Message";
	}

	private String coreMsgGet() {
		if (hashMsg.size() > 0)
			for (Integer key : hashMsg.keySet()) {
				if (hashMsg.get(key).getStatus().equals("A")) {
					QueueInfo qInfo = hashMsg.get(key);
					qInfo.setStatus("U");
					qInfo.setGetDate(System.currentTimeMillis());
					hashMsg.put(key, qInfo);
					return qInfo.getMsg() + "::" + key;
				}
			}
		return null;
	}

	private int getActiveSize() {
		int activeSize = 0;
		for (Integer key : hashMsg.keySet()) {
			if (hashMsg.get(key).getStatus().equals("A")) {
				activeSize++;
			}
		}
		return activeSize;
	}

	public String MsgGetFuture() {
//	public String MsgGet() {

		String msg = coreMsgGet();
		if (msg != null) {
			return msg;
		}

		if (this.waitTime > 0) {
			FutureTask<String> f = new FutureTask<String>(()->{
	        	int checkLimit = (getActiveSize() > 0) ? 0 : this.waitTime * 1000;
	        	do {
	        		Thread.sleep(10);
					checkLimit -= 10;
					String get = coreMsgGet();
//					System.out.println(get);
					if (get != null) {
	                    System.out.println("future find......" + get);
						return get;
					}
	        	} while (checkLimit > 0);

	            return "No Message";
	        }) { //비동기 작업이 모두 완료되면 호출되는 hook같은 것.
	            @Override
	            protected void done() {
	                try {
	                    System.out.println("future return......" + get());
//	                    test = get();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                } catch (ExecutionException e) {
	                    e.printStackTrace();
	                }
	            }
	        };
	        es.execute(f);
	        try {
				msg = f.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        es.shutdown(); //이 메서드를 쓰더라도 하던 작업이 중단되지는 않음
		}
		if (msg != null) {
			return msg;
		}
		return "No Message";
	}


	public String MsgSet(int id) {
		if (hashMsg.size() > 0) {
			if (hashMsg.containsKey(id)) {
//				hashMsg.get(id).setStatus("A");
//				hashMsg.get(id).setGetDate(0L);
				checkDeadLetter(id);
				return "Ok";
			}
		}

		return "Set Fail";
	}

	public String MsgDel(int id) {
		if (hashMsg.size() > 0) {
			synchronized (mutex) {
				if (hashMsg.containsKey(id)) {
					hashMsg.remove(id);
					return "Ok";
				}
			}
		}
		return "Not Deleted";
	}

	public void ProcessTimeout() {
		long checkDate = System.currentTimeMillis();
		if (this.processTimeout != 0 && hashMsg.size() > 0) {
			Set<Integer> checkKey = new HashSet<Integer>();
			for (Integer key : hashMsg.keySet()) {
				checkKey.add(key);
			}
			for (Integer key : checkKey) {
				QueueInfo qInfo = hashMsg.get(key);
				if (qInfo.getStatus().equals("U") && checkDate - qInfo.getGetDate() > (this.processTimeout * 1000)) {
//							qInfo.setStatus("A");
//							qInfo.setGetDate(0L);
					checkDeadLetter(key);
				}
			}
		}
	}

	private void checkDeadLetter(Integer key) {
		QueueInfo qInfo = hashMsg.get(key);
		if (qInfo.getFailCount() >= this.maxFailCount) {
			MsgDel(key);
			deadLetterMsg.put(key, qInfo);
			TestLogger.print(name + "-" + key + " -- move DLQ..." + new Date());
		} else {
			qInfo.setStatus("A");
			qInfo.setGetDate(0L);
			qInfo.increaseFailCount();
			TestLogger.print(
					name + "-" + key + " -- MsgSet... fail count=" + qInfo.getFailCount() + "/" + this.maxFailCount);
		}
	}

	public String DLQMsgDequeue() {
		if (deadLetterMsg.size() == 0)
			return "No Message";

		int key = (int) deadLetterMsg.keySet().iterator().next();

		String res = deadLetterMsg.get(key).getMsg() + "::" + key;

		deadLetterMsg.remove(key);

		return res;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
