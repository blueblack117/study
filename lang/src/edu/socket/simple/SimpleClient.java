package edu.socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1", 9090);
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String answer = input.readLine();
			System.out.println(answer);
		} finally {
			client.close();
		}		
	}

}
