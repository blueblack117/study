package file.buffered;

import logger.TestLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TextFileWriter {
    public static void main(String[] args) throws IOException {
        String[] arrString = new String[] {
                "AAAAA",
                "BBBBB",
                "CCCCC",
                "DDDDD",
                "EEEEE",
        };

        File outputFile = new File(".\\sample\\OUTPUT\\file_writer.txt");
        TestLogger.print(outputFile.getAbsolutePath());
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        String line = null;
        String cr = null;
        Date now = new Date();
        for (String str : arrString) {
            bw.write(str + "..." + now);
            bw.write("\r\n");
        }
        bw.flush();
        bw.close();
    }
}
