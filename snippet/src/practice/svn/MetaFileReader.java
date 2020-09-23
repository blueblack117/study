package practice.svn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class MetaFileReader {

    static Path metaFile = Paths.get("./snippet/copyToWalk/meta.txt");

    public static Map<String, ContentsInfo> read() throws IOException {
        Map<String, ContentsInfo> fileMap = new HashMap<>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(metaFile.toFile());
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
//                TestLogger.print(line);
                String[] arrInfo = line.split("&");
                boolean directory = ("D".equals(arrInfo[0])) ? true : false;
                char mode = arrInfo[1].charAt(0);
                if (mode != 'd') {
                    ContentsInfo info = new ContentsInfo(directory, Paths.get(arrInfo[2]), mode);
                    fileMap.put(arrInfo[2], info);
                }
            }
        } finally {
            if (bufferedReader != null) try {
                bufferedReader.close();
            } catch (Exception ex) { /* Do Nothing */ }
            if (fileReader != null) try {
                fileReader.close();
            } catch (Exception ex) { /* Do Nothing */ }

            return fileMap;
        }
    }
}
