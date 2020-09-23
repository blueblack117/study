package thread.multithread;

public class MultiThreadMain {

	public static void main(String[] args) {
		System.out.println("Main Start!!");
		
		PrintThread pth1 = new PrintThread("Thread1");
		PrintThread pth2 = new PrintThread("Thread2");
		
		Thread th1 = new Thread(pth1);
		Thread th2 = new Thread(pth2);
		
		th1.start();
		th2.start();
		
		for (int inx=0; inx<10; inx++) {
			System.out.println("[Main] " + inx);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main End!!");
	}

}
