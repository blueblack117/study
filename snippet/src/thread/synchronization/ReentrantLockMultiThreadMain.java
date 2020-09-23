package thread.synchronization;


public class ReentrantLockMultiThreadMain {
	
	public static void main(String[] args) {		
		ReentrantLocSyncPrintThread pth1 = new ReentrantLocSyncPrintThread("Thread1");
		ReentrantLocSyncPrintThread pth2 = new ReentrantLocSyncPrintThread("Thread2");
		
		Thread th1 = new Thread(pth1);
		Thread th2 = new Thread(pth2);
		
		th1.start();
		th2.start();

		ReentrantLocSyncPrintThread.lock.lock();
		System.out.println("[Main]");
		for (int inx=1; inx<31; inx++) {
				System.out.print(inx + " ");
		}
		System.out.println("");
		ReentrantLocSyncPrintThread.lock.unlock();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
