package thread.synchronization;

public class SyncMultiThreadMain {

	public static Object mutex = new Object();
	
	public static void main(String[] args) {		
		SyncPrintThread pth1 = new SyncPrintThread("Thread1");
		SyncPrintThread pth2 = new SyncPrintThread("Thread2");
		
		Thread th1 = new Thread(pth1);
		Thread th2 = new Thread(pth2);
		
		th1.start();
		th2.start();

		synchronized (mutex) {
			System.out.println("[Main]");
			for (int inx=1; inx<31; inx++) {
					System.out.print(inx + " ");
			}
			System.out.println("");
		}
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
