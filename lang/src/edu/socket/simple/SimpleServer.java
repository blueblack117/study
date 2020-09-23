package edu.socket.simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket listener = new ServerSocket(9090);
		try {
			Socket socket = listener.accept();
			try {
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				Date now = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
				out.println(sf.format(now));
			} finally {
				socket.close();
			}			
			
		} finally {
			listener.close();			
		}
	}
}
