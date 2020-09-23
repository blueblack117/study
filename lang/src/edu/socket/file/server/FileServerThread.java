package edu.socket.file.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServerThread implements Runnable {

	private boolean bStop = false;
	ServerSocket listener = null;
	private static int number = 0;
	
	@Override
	public void run() {
		System.out.println("FileServerThread start");
		// TODO Auto-generated method stub
		try {
			listener = new ServerSocket(9090);
			try {
				while (!bStop) {
					Socket socketClient = listener.accept();
					try {
						FileServerClientThread clientThread = new FileServerClientThread("socketClient" + number++);
						clientThread.setSocketClient(socketClient);
						Thread thread = new Thread(clientThread);
						thread.start();
						
//						try {
//							thread.join();
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					} finally {
					}
				}
			} finally {
				listener.close();			
			}
		} catch (IOException e) {
			
		}
		System.out.println("FileServerThread end");
	}

	public boolean isbStop() {
		return bStop;
	}

	public void setbStop(boolean bStop) {
		try {
			listener.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bStop = bStop;
	}
}
