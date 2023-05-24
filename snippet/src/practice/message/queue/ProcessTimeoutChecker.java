package practice.message.queue;

public class ProcessTimeoutChecker implements Runnable {

	private boolean bStop = true;

	public boolean isbStop() {
		return bStop;
	}

	public void setbStop(boolean bStop) {
		this.bStop = bStop;
	}

	@Override
	public void run() {
		while (bStop) {
//			TestLogger.print("check ProcessTimeout..." + new Date());
			MsgQueuesManager.QProcessTimeout();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

