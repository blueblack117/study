package file.copy;

import logger.TestLogger;

import java.io.*;
import java.util.Date;

public class FileCopyBuffer {
    public static void main(String[] args) throws IOException {
        String filename = "license.dat";
        File sourceFile = new File(".\\snippet\\sample\\INPUT\\" + filename);
        File targetFile = new File(".\\snippet\\sample\\OUTPUT\\" + filename);

        if (sourceFile.exists() && sourceFile.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            String line = null;
            String cr = null;
            while ((line = br.readLine()) != null) {
                if (cr != null) {
                    bw.write(cr);
                } else {
                    cr = "\r\n";
                }
                bw.write(line);
            }
            bw.flush();
            br.close();
            bw.close();
        } else {
            TestLogger.print(new Date() + "]] Filename is not exist.");
        }
    }

}
