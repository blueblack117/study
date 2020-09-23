package file.iostream;

import java.io.*;

public class DataStreamWriteMain {
    public static void main(String[] args) {
        try {
            String filepath = "./snippet/sample/OUTPUT/writed.txt";
            writingData(filepath, false);
            readingData(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writingData(String fname, boolean append) throws IOException {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream(new File(fname), append);
            dos = new DataOutputStream(fos);
            dos.writeBoolean(append);
            dos.writeByte(123);
            dos.writeChar(75);
            dos.writeDouble(34.56);
            dos.writeFloat(345.23f);
            dos.writeInt(123);
            dos.writeLong(345L);
            dos.writeUTF("홍길동");
            dos.flush(); //fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("잘못된 파일이름을 입력했습니다.");
        }
    }

    public static void readingData(String fname) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(fname));
            DataInputStream dis = new DataInputStream(fis);
            System.out.println("append가능? :" + dis.readBoolean());
            System.out.println("read byte :" + dis.readByte());
            System.out.println("read char :" + dis.readChar());
            System.out.println("read double :" + dis.readDouble());
            System.out.println("read float :" + dis.readFloat());
            System.out.println("read int :" + dis.readInt());
            System.out.println("read long :" + dis.readLong());
            System.out.println("read utf :" + dis.readUTF());
            dis.close();
        } catch (FileNotFoundException e) {
            System.out.println("잘못된 파일이름을 입력했습니다.");
        }
    }
}
