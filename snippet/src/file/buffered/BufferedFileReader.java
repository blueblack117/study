package file.buffered;

import logger.TestLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReader {

    public static void main(String[] args) throws IOException {
        File curDir = new File(".");
        TestLogger.print(curDir.getAbsolutePath());

        TestLogger.print("File read all");
        String fileContent = readAll("./snippet/sample/INPUT/file_reader.txt");
        TestLogger.print(fileContent);

        TestLogger.print("File read line");
        read("./snippet/sample/INPUT/file_reader.txt");
    }

    public static String readAll(String filePath) throws IOException {
        StringBuilder stringBuilder;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            stringBuilder = new StringBuilder();
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
                stringBuilder.append(line).append('\n');

        } finally {
            if (bufferedReader != null) try {
                bufferedReader.close();
            } catch (Exception ex) { /* Do Nothing */ }
            if (fileReader != null) try {
                fileReader.close();
            } catch (Exception ex) { /* Do Nothing */ }
        }

        return stringBuilder.toString();
    }

    public static void read(String filePath) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                TestLogger.print(line);
            }

        } finally {
            if (bufferedReader != null) try {
                bufferedReader.close();
            } catch (Exception ex) { /* Do Nothing */ }
            if (fileReader != null) try {
                fileReader.close();
            } catch (Exception ex) { /* Do Nothing */ }
        }
    }
}
