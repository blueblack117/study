package file.iostream;

import java.io.*;

public class DataStreamUsingMain {
    public static void main(String[] args) {
        WritingData wd=new WritingData();
        wd.setName("홍길순");
        wd.setAge(20);
        wd.setHeight(165);
        wd.setMan(false);

        WritingData wd2=null;
        try {
            String filepath = "./snippet/sample/OUTPUT/write.txt";
            writingData(filepath,true, wd);
            wd2 = readingData(filepath);
            System.out.println(wd2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writingData(String fname, boolean append, WritingData wd)
            throws IOException{
        FileOutputStream fos=null;
        DataOutputStream dos=null;
        try {
            fos=new FileOutputStream(new File(fname), append);
            dos=new DataOutputStream(fos);
            dos.writeUTF(wd.getName());
            dos.writeInt(wd.getAge());
            dos.writeDouble(wd.getHeight());
            dos.writeBoolean(wd.isMan());
        } catch (FileNotFoundException e) {
            System.out.println("잘못된 파일이름을 입력했습니다.");
        }
    }
    public static WritingData readingData(String fname)throws IOException{
        FileInputStream fis=null;
        DataInputStream dis=null;
        WritingData wd=new WritingData();
        try {
            fis=new FileInputStream(new File(fname));
            dis=new DataInputStream(fis);
            wd.setName(dis.readUTF());
            wd.setAge(dis.readInt());
            wd.setHeight(dis.readDouble());
            wd.setMan(dis.readBoolean());
        } catch (FileNotFoundException e) {
            System.out.println("잘못된 파일이름을 입력했습니다.");
        }
        return wd;
    }
}

class WritingData {
    private String name;
    private int age;
    private double height;
    private boolean man;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    @Override
    public String toString() {
        return "WritingData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", man=" + man +
                '}';
    }
}