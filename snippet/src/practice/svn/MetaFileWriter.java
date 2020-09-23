package practice.svn;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

public class MetaFileWriter {

    static Path metaFile = Paths.get("./snippet/copyToWalk/meta.txt");

    public static void write(String content) {
        FileWriter fileWriter = null;
        PrintWriter pw = null;
        try {
            fileWriter = new FileWriter(metaFile.toFile(), true);
            pw = new PrintWriter(fileWriter); //flush false

            pw.println(content);
            pw.flush();     //PrintWriter(fw, true)일 때는 필요없다.
        } catch (IOException e) {

        } finally {
            if (pw != null) try {
                pw.close();
            } catch (Exception ex) { /* Do Nothing */ }
            if (fileWriter != null) try {
                fileWriter.close();
            } catch (Exception ex) { /* Do Nothing */ }
        }
    }

    public static void write(Map<String, ContentsInfo> fileTreeMap) {
        FileWriter fileWriter = null;
        PrintWriter pw = null;
        try {
            fileWriter = new FileWriter(metaFile.toFile(), false);
            pw = new PrintWriter(fileWriter); //flush false

//            for (String key : fileTreeMap.keySet()) {
            String[] keys = fileTreeMap.keySet().toArray(new String[0]);
            Arrays.sort(keys);
            for (String key: keys) {
                pw.println(fileTreeMap.get(key).toString());
                pw.flush();     //PrintWriter(fw, true)일 때는 필요없다.
            }

        } catch (IOException e) {

        } finally {
            if (pw != null) try {
                pw.close();
            } catch (Exception ex) { /* Do Nothing */ }
            if (fileWriter != null) try {
                fileWriter.close();
            } catch (Exception ex) { /* Do Nothing */ }
        }
    }
}
