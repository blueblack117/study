package file.compare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderCompare {

    public static void main(String[] args) throws IOException {
        File file = new File("./snippet/sample/INPUT/gitlab-ci.yml");
        File file2 = new File("./snippet/sample/OUTPUT/gitlab-ci.yml");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        String data = null;
        String data2 = null;
        boolean hasAnyEqualLine = false;
        while ((data = reader.readLine()) != null) { // 읽을게 없으면 null 리턴
            data2 = reader2.readLine();
            if (data2 == null) {
                break;
            }
            if (data.equals(data2)) {
                hasAnyEqualLine = true;
                System.out.println(data);
            }
        }
        if (!hasAnyEqualLine) {
            System.out.println("모든 라인이 일치하지 않네요");
        } else {
            System.out.println("동일한 파일이네요");
        }

        reader.close();
        reader2.close();
    }
}
