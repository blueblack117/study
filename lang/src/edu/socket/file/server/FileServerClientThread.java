package edu.socket.file.server;

import java.io.*;
import java.net.Socket;

public class FileServerClientThread implements Runnable {

	private Socket socketClient;
	private String outputFolder = "C:\\sample\\ServerFiles\\";
	private String name;
	
	public FileServerClientThread() {
		super();
	}
	
	public FileServerClientThread(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int bufferSize = 1024;
		int readLength;
		
		try {			
			InputStream inStream = socketClient.getInputStream();	
			
			byte[] fileLength = new byte[1];
			inStream.read(fileLength);
			byte[] bufFileName = new byte[fileLength[0]];
			inStream.read(bufFileName);
			
			String filename = new String(bufFileName);
			System.out.println(name + ">> FileServer receive..." + filename);
			
			File outputFile = new File(outputFolder + filename);
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			} else {
//				outputFile.delete();
				String[] tempFile = filename.split("\\.");
				outputFile = new File(outputFolder + tempFile[0] + "_" +  + System.currentTimeMillis() + "." + tempFile[1]);
				outputFile.createNewFile();
			}

			byte[] buffer = new byte[bufferSize];
			OutputStream outStream = new FileOutputStream(outputFile);	
			while((readLength = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, readLength);
			}
			
			inStream.close();
			outStream.close();
			socketClient.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " close");
	}

	public Socket getSocketClient() {
		return socketClient;
	}

	public void setSocketClient(Socket socketClient) {
		this.socketClient = socketClient;
	}

}
