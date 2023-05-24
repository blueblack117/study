package practice.message.http;

import logger.TestLogger;
import practice.message.queue.MsgQueuesManager;
import practice.message.vo.RequestBody;
import practice.message.vo.ResponseBody;

public class MessageServlet {
    public ResponseBody create(String targetQueue, RequestBody reqBody) {
		TestLogger.print("create... Q=" + targetQueue + ", body=" + reqBody);

		String result = MsgQueuesManager.QCreate(targetQueue, reqBody);

		ResponseBody res = new ResponseBody();
		res.setResult(result);
		return res;
	}

	public ResponseBody send(String targetQueue, RequestBody reqBody) {
		TestLogger.print("send...Q=" + targetQueue + ", body=" + reqBody);

		String result = MsgQueuesManager.QEnqueue(targetQueue, reqBody.getMessage());

		ResponseBody res = new ResponseBody();
		res.setResult(result);
		return res;
	}

	public ResponseBody receive(String targetQueue) {
		TestLogger.print("receive...Q=" + targetQueue);

		String result = MsgQueuesManager.QGet(targetQueue);
		ResponseBody res = new ResponseBody();
		if ("No Message".equals(result)) {
			res.setResult(result);
		} else {
			res.setResult("Ok");
			String[] arrResult = result.split("::");
			res.setMessageID(arrResult[1]);
			res.setMessage(arrResult[0]);
		}
		return res;
	}

	public ResponseBody ack(String targetQueue, String messageID) {
		TestLogger.print("ack...Q=" + targetQueue + ", messageID=" + messageID);
		String result = MsgQueuesManager.QDel(targetQueue, Integer.parseInt(messageID));
		ResponseBody res = new ResponseBody();
		res.setResult(result);
		return res;
	}

	public ResponseBody fail(String targetQueue, String messageID) {
		TestLogger.print("fail...Q=" + targetQueue + ", messageID=" + messageID);

		String result = MsgQueuesManager.QSet(targetQueue, Integer.parseInt(messageID));

		ResponseBody res = new ResponseBody();
		res.setResult(result);
		return res;
	}

	public ResponseBody deadLetterQueue(String targetQueue) {
		TestLogger.print("dlq...Q=" + targetQueue);

		String result = MsgQueuesManager.DLQDequeue(targetQueue);
		ResponseBody res = new ResponseBody();
		if ("No Message".equals(result)) {
			res.setResult(result);
		} else {
			res.setResult("Ok");
			String[] arrResult = result.split("::");
			res.setMessageID(arrResult[1]);
			res.setMessage(arrResult[0]);
		}
		return res;
	}
}
