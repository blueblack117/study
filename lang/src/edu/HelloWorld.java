package edu;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello World~~");
//		
//		byte[] bytes = new byte[] {116, 101, 115, 116, 46, 101, 120, 101, 77};
//		System.out.println(bytes);
//		String s = new String(bytes);
//		System.out.println(s);
//		
//		String filename = "abc.xml";
//		String[] tempFile = filename.split("\\.");
//		System.out.println(tempFile[0] + " " + tempFile[1]);
		
		
		int number = 3;
		byte[] bytes2 = intToByteArray(number);
		int result = byteArrayToInt(bytes2);
		System.out.println(result);
	}

	public static byte[] intToByteArray(int value) {
		byte[] byteArray = new byte[4];
		byteArray[0] = (byte) (value >> 24);
		byteArray[1] = (byte) (value >> 16);
		byteArray[2] = (byte) (value >> 8);
		byteArray[3] = (byte) (value);
		return byteArray;
	}

	public static int byteArrayToInt(byte bytes[]) {
		return ((((int) bytes[0] & 0xff) << 24)
				| (((int) bytes[1] & 0xff) << 16)
				| (((int) bytes[2] & 0xff) << 8) | (((int) bytes[3] & 0xff)));
	}

}
