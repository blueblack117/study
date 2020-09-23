package file.iostream;

import logger.TestLogger;
import collection.sort.UserVo;

import java.io.*;
import java.util.Vector;

public class ObjectStreamWriteMain {
    public static void main(String[] args) {
        UserVo user0 = new UserVo("김김김", "18888-8777", 88);
        UserVo user1 = new UserVo("박박박", "17888-7777", 78);
        UserVo user2 = new UserVo("이이이", "16888-7777", 68);
        UserVo user3 = new UserVo("김김김", "15888-7777", 58);
        UserVo user4 = new UserVo("차차차", "18888-8777", 88);

        Vector v = new Vector(5, 5);
        //Vector<Student> v=new Vector<Student>(5, 5);//JAVA5
        v.add(user0);
        v.add(user1);
        v.add(user2);
        v.add(user3);
        v.add(user4);
        try {
            String filepath = "./snippet/sample/OUTPUT/object.txt";
            write(filepath, v);
            read(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int write(String fname, Vector v) throws IOException {
        //public int write(String fname, Vector<Student> v) throws IOException{//JAVA5
        int objectNumber = 0;
        try {
            FileOutputStream fos = new FileOutputStream(fname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);//throws
            objectNumber = v.size();
            oos.writeInt(objectNumber);
            TestLogger.print(objectNumber + "개의 UserVo가 입력됨");
            for (int i = 0; i < objectNumber; i++) {
                oos.writeInt(i);
                oos.writeObject((UserVo) v.get(i));
                //oos.writeObject(v.get(i));//JAVA5
                oos.flush();
                TestLogger.print(i + "번째의  UserVo가 입력됨");
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            TestLogger.print("잘못된 파일이름을 입력했습니다.");
        } catch (Exception ee) {
            throw new IOException("타입이 이상합니다." + ee);
        }
        return objectNumber;
    }

    public static void read(String fname) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);//throws
            int objectNumber = ois.readInt();
            TestLogger.print(objectNumber + "개의 UserVo를 읽음");
            for (int i = 0; i < objectNumber; i++) {
                try {
                    System.out.print(ois.readInt() + "번째 :");
                    TestLogger.print((UserVo) ois.readObject());
                } catch (ClassNotFoundException e1) {
                    TestLogger.print("잘못된 타입입니다..");
                }
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            TestLogger.print("잘못된 파일이름을 입력했습니다.");
        }
    }
}
