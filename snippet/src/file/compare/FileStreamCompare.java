package file.compare;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStreamCompare {
    public static void main(String[] args) {
        File file1 = new File("./snippet/sample/INPUT/gitlab-ci.yml");
        File file2 = new File("./snippet/sample/OUTPUT/gitlab-ci.yml");
        boolean compare = FileStreamCompare.compare(file1, file2);
        if (compare) {
            System.out.println("[파일 내용이 동일합니다.]");
        }
    }

    public static boolean compare(File file1, File file2) {
        boolean result = true;

        InputStream in1= null;
        InputStream in2 = null;
        int byte1;
        int byte2;

        try {
            in1 = new FileInputStream(file1);
            in2 = new FileInputStream(file2);

            while (((byte1 = in1.read()) != -1) && ((byte2 = in2.read()) != -1)) {
                if (byte1 != byte2) {
                    System.out.println("[reason :: 파일 내용이 서로 다릅니다.]");
                    result = false;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[reason :: 잘못된 url 주소 입니다.]");
            result = false;
        }finally{
            try {
                in1.close();
                in2.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }
}
