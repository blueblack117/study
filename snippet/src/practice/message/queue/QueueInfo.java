package practice.message.queue;

public class QueueInfo {
	private String status;
	private String msg;
	private long getDate;
	private int failCount;

	public QueueInfo(String status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getGetDate() {
		return getDate;
	}

	public void setGetDate(long getDate) {
		this.getDate = getDate;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public void increaseFailCount() {
		this.failCount++;
	}
}

