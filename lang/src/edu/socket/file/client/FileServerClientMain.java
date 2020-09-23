package edu.socket.file.client;

import java.io.*;
import java.net.Socket;

public class FileServerClientMain {

	public static void main(String[] args) {
		System.out.println("FileServerClientMain start");
		// TODO Auto-generated method stub
		String fileName = "artifacts.xml";
		String strInputFile = "C:\\sample\\ClientFiles\\" + fileName;
		int bufferSize = 1024;
		int readLength;
		
		try {
			Socket client = new Socket("127.0.0.1", 9090);
			
			File inputFile = new File(strInputFile);
			InputStream inStream = new FileInputStream(inputFile);

			OutputStream outStream = client.getOutputStream();

			// filename write
			byte[] length = new byte[] {(byte)fileName.getBytes().length};
			outStream.write(length, 0, 1);
			outStream.write(fileName.getBytes(), 0, fileName.getBytes().length);
			
			byte[] buffer = new byte[bufferSize];
			while((readLength = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, readLength);
			}

			inStream.close();
			outStream.close();
			
			client.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FileServerClientMain end");
	}

}
