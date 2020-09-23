package file.buffered;

import logger.TestLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class TextFileReader {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File(".\\sample\\INPUT\\file_reader.txt");
        if (sourceFile.exists() && sourceFile.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } else {
            TestLogger.print(new Date() + "]] Filename is not exist.");
        }
    }
}
