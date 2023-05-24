package practice.message.vo;


public class RequestBody {
	private int QueueSize;
    private int ProcessTimeout;
    private int MaxFailCount;
    private int WaitTime;
	private String Message;

	public int getQueueSize() {
		return QueueSize;
	}

	public void setQueueSize(int queueSize) {
		QueueSize = queueSize;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getProcessTimeout() {
		return ProcessTimeout;
	}

	public void setProcessTimeout(int processTimeout) {
		ProcessTimeout = processTimeout;
	}

	public int getMaxFailCount() {
		return MaxFailCount;
	}

	public void setMaxFailCount(int maxFailCount) {
		MaxFailCount = maxFailCount;
	}

	public int getWaitTime() {
		return WaitTime;
	}

	public void setWaitTime(int waitTime) {
		WaitTime = waitTime;
	}

	@Override
	public String toString() {
		return "RequestBody [QueueSize=" + QueueSize + ", ProcessTimeout=" + ProcessTimeout + ", MaxFailCount="
				+ MaxFailCount + ", WaitTime=" + WaitTime + ", Message=" + Message + "]";
	}
}

