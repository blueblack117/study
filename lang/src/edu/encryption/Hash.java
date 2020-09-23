package edu.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
        	String input = sc.nextLine();
        	toHash(input);
        	break;
        }    
        sc.close();
	}
	
	public static void toHash(String input) {
		MessageDigest mDigest;
		try {
			mDigest = MessageDigest.getInstance("SHA-256");
			byte[] result = mDigest.digest(input.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString((result[i] & 0xFF) + 0x100, 16)
						.substring(1));
			}
			System.out.println(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
