package file.iostream;

import logger.TestLogger;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileReader {

    public static void main(String[] args) throws IOException {
        File curDir = new File(".");
        TestLogger.print(curDir.getAbsolutePath());

        TestLogger.print("File random access");
        byte[] fileContent = readBytes("./snippet/sample/INPUT/file_reader.txt", 10, 13);
        String result = new String(fileContent);
        TestLogger.print(result);
    }

    public static byte[] readBytes(String filePath, int offset, int length) throws IOException {
        RandomAccessFile randomFile = null;
        try {
            randomFile = new RandomAccessFile(filePath, "r");
            randomFile.seek(offset);

            byte[] dataBytes = new byte[length];
            randomFile.readFully(dataBytes);

            return dataBytes;

        } finally {
            if (randomFile != null) try {
                randomFile.close();
            } catch (Exception ex) { /* Do Nothing */ }
        }
    }
}
