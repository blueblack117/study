package file;

import logger.TestLogger;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 파일을 Open한 이후부터 갱신이 되었을 때 로직 처리
 */
public class FileModifyCheck {
    public static void main(String[] args) {
        try {
            File file = new File("./snippet/sample/OUTPUT/aaa.txt");
            while (file.length() <= 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            RandomAccessFile rFile = new RandomAccessFile(file, "r");
            rFile.seek(file.length());

            String line = null;
            while (true) {
                line = rFile.readLine();
                if (line == null || line.isEmpty()) {
                    try {
                        Thread.sleep(500);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                /* 로직 처리 */
                doSomething();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doSomething() {
        TestLogger.print("File Updated!!!!");
    }
}
