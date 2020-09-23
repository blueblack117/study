package edu.thread.synchronization;

public class SyncPrintThread implements Runnable {

	private String name;
	
	public SyncPrintThread() {
		super();
		
	}
	
	public SyncPrintThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (SyncMultiThreadMain.mutex) {
			System.out.println("[" + name + "] ");
			for (int inx=1; inx<31; inx++) {
				System.out.print(inx + " ");
			}
			System.out.println("");
		}		
	}
}
