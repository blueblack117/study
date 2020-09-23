package edu.socket.file.server;

import java.util.Scanner;

public class FileServerMain {

	public static void main(String[] args) {
		System.out.println("FileServerMain start");
		// TODO Auto-generated method stub
		FileServerThread server = new FileServerThread();
		Thread serverThread = new Thread(server);
		serverThread.start();
		
		boolean isContinue = true;
		Scanner sc = new Scanner(System.in);
        while(isContinue && sc.hasNextLine()){
        	String exit = sc.nextLine();
        	if (exit.equals("QUIT")) {
        		isContinue = false;
        		server.setbStop(true);
        	}
        }    
        sc.close();
		
		try {
			serverThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FileServerMain end");
	}

}
