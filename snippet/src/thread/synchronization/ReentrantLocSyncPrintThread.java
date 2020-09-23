package thread.synchronization;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocSyncPrintThread implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();

	private String name;
	
	public ReentrantLocSyncPrintThread() {
		super();
		
	}
	
	public ReentrantLocSyncPrintThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {		
		lock.lock();
		System.out.println("[" + name + "] ");
		for (int inx=1; inx<31; inx++) {
				System.out.print(inx + " ");
		}
		System.out.println("");
		lock.unlock();		
	}
}
