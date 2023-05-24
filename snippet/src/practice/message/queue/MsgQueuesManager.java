package practice.message.queue;

import java.util.HashMap;

import practice.message.vo.RequestBody;

public class MsgQueuesManager {

	static HashMap<String, MsgQueue> queues = new HashMap<String, MsgQueue>();

	public static String QCreate(String name, int size) {
		if (queues.containsKey(name))
			return "Queue Exist";

		MsgQueue q = new MsgQueue(size);

		queues.put(name, q);

//		return "Queue Created";
		return "Ok";
	}

	public static String QCreate(String name, RequestBody req) {
		if (queues.containsKey(name))
			return "Queue Exist";

		MsgQueue q = new MsgQueue(req.getQueueSize(), req.getProcessTimeout(), req.getMaxFailCount(), req.getWaitTime());
		q.setName(name);

		queues.put(name, q);

//		return "Queue Created";
		return "Ok";
	}

	public static String QEnqueue(String name, String msg) {
		return queues.get(name).MsgEnqueue(msg);
	}

	public static String QDequeue(String name) {
		return queues.get(name).MsgDequeue();
	}

	public static String QGet(String name) {
		return queues.get(name).MsgGet();
	}

	public static String QSet(String name, int id) {
		return queues.get(name).MsgSet(id);
	}

	public static String QDel(String name, int id) {
		return queues.get(name).MsgDel(id);
	}

	public static void QProcessTimeout() {
		for (String key : queues.keySet()) {
			MsgQueue mq = queues.get(key);
			mq.ProcessTimeout();
		}
	}

	public static String DLQDequeue(String name) {
		return queues.get(name).DLQMsgDequeue();
	}
}
