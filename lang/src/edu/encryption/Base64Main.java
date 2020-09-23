package edu.encryption;

import org.apache.commons.codec.binary.Base64;

import java.util.Scanner;

public class Base64Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			toBase64(input);
			break;
		}
		sc.close();
	}

	public static void toBase64(String input) {
		byte[] encodedBytes = Base64.encodeBase64(input.getBytes());
		String encodedString = new String(encodedBytes);
		System.out.println("encodedString >>" + encodedString);
		
		byte[] decodedBytes = Base64.decodeBase64(encodedString);
		String decodedString = new String(decodedBytes);
		System.out.println("decodedString >>" + decodedString);
	}

}
