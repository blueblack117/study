package thread.multithread;

public class PrintThread implements Runnable {

	private String name;
	
	public PrintThread() {
		super();
		
	}
	
	public PrintThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int inx=0; inx<10; inx++) {
			System.out.println("[" + name + "] " + inx);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("[" + name + "] " + " End!!");
	}
}
