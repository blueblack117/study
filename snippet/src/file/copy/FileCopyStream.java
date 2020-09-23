package file.copy;

import logger.TestLogger;

import java.io.*;
import java.util.Date;

public class FileCopyStream {
    public static void main(String[] args) throws IOException {
        String filename = "license_local.dat";
        File sourceFile = new File(".\\snippet\\sample\\INPUT\\" + filename);
        File targetFile = new File(".\\snippet\\sample\\OUTPUT\\" + filename);

        int bufferSize = 512;
        int readLength;

        if (sourceFile.exists() && sourceFile.isFile()) {
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }

            InputStream inStream = new FileInputStream(sourceFile);
            OutputStream outStream = new FileOutputStream(targetFile);

            byte[] buffer = new byte[bufferSize];
            while((readLength = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, readLength);
            }

            inStream.close();
            outStream.close();
        } else {
            TestLogger.print(new Date() + "]] Filename is not exist.");
        }
    }

}
