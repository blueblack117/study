package edu.fileio;

import java.io.*;

public class FileDirectoryList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFolder = "..\\sample\\INPUT";
		
		searchFileList(inputFolder);
	}

	public static void searchFileList(String inputFolder) {
		int compFileSize = 2048;
		File directory = new File(inputFolder);
		if (directory.exists()) {
			File[] fList = directory.listFiles();

			for (File file : fList) {
				if (!file.isDirectory()) {
					System.out.println(file.getName() + ":\t" + file.length() + "bytes");
					if (file.length() >= compFileSize) {
						copyFile(file);
					}
				} else {
					System.out.println("[D]" + file.getName());
				}
			}
		} else {
			System.out.println("File Not Found...");
		}
	}
	
	public static void copyFile(File inputFile) {
		String outputFolder = "..\\sample\\OUTPUT\\";
		int bufferSize = 512;
		int readLength;

		File outputFile = new File(outputFolder + inputFile.getName());
		if (!outputFile.getParentFile().exists()) {
			outputFile.getParentFile().mkdir();
		}
		
		try {
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}
			
			InputStream inStream = new FileInputStream(inputFile);
			OutputStream outStream = new FileOutputStream(outputFile);
			
			byte[] buffer = new byte[bufferSize];
			while((readLength = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, readLength);
			}
			
			inStream.close();
			outStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
