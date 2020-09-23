package file.buffered;

import collection.sort.UserVo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PrintFileWriter {

    public static void main(String[] args) throws IOException {
        UserVo user0 = new UserVo("김김김", "18888-8777", 88);
        UserVo user1 = new UserVo("박박박", "17888-7777", 78);
        UserVo user2 = new UserVo("이이이", "16888-7777", 68);
        UserVo user3 = new UserVo("김김김", "15888-7777", 58);
        UserVo user4 = new UserVo("차차차", "18888-8777", 88);

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
        PrintWriter pw = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            pw = new PrintWriter(fileWriter); //flush false

            pw.println(content);
            pw.flush();     //PrintWriter(fw, true)일 때는 필요없다.

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
