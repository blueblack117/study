package edu.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
	static String rootPath = ".\\lang\\sample\\INPUT";
	static String outputPath = ".\\lang\\sample\\OUTPUT";
	public static void main(String[] args) {
		FileSearchAll(rootPath);
	}

    public static void FileSearchAll(String path)
    {
    	File directory = new File(path);
    	File[] fList = directory.listFiles();

	    for (File file : fList) {
	        if (file.isDirectory()) {
	        	FileSearchAll(file.getPath());
	        }
	        else {
	        	String partPath = path.substring(rootPath.length());
	            System.out.println("." + partPath + "\\" + file.getName());
	            if (file.length() > 3*1024) {
	            	MyCopyFile(partPath, file.getName());
	            }
	        }
	    }
    }

    public static void MyCopyFile(String partPath, String filename)
	{
		final int BUFFER_SIZE = 512;
        int readLen;
        try {
    		// Create Folder
    		File destFolder = new File(outputPath + partPath);
    		if(!destFolder.exists()) {
    			destFolder.mkdirs();
    		}

    		// Copy File
            InputStream inputStream = new FileInputStream(rootPath+partPath+"\\"+filename);
            OutputStream outputStream = new FileOutputStream(outputPath+partPath+"\\"+filename);

            byte[] buffer = new byte[BUFFER_SIZE];

            while ((readLen = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, readLen);
            }

            inputStream.close();
            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
