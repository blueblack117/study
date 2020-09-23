package file.buffered;

import collection.sort.UserVo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedFileWriter {

    public static void main(String[] args) throws IOException {
        UserVo user0 = new UserVo("김김김", "8888-8777", 88);
        UserVo user1 = new UserVo("박박박", "7888-7777", 78);
        UserVo user2 = new UserVo("이이이", "6888-7777", 68);
        UserVo user3 = new UserVo("김김김", "5888-7777", 58);
        UserVo user4 = new UserVo("차차차", "8888-8777", 88);

        List<UserVo> userList = new ArrayList<UserVo>();
        userList.add(user0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        for (UserVo user : userList) {
            write("./snippet/sample/OUTPUT/file_reader.txt", user.toString());
        }
    }

    public static void write(String filePath, String content) throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.write("\r\n");
        } finally {
            if (bufferedWriter != null) try {
                bufferedWriter.close();
            } catch (Exception ex) { /* Do Nothing */ }
            if (fileWriter != null) try {
                fileWriter.close();
            } catch (Exception ex) { /* Do Nothing */ }
        }
    }
}
