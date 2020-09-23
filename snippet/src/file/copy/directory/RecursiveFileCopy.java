package file.copy.directory;

import java.io.*;
import java.util.ArrayList;

class TestFile {
    File ft = null;
    String path = "";
}


public class RecursiveFileCopy {

    public static ArrayList<String> dirList = new ArrayList<String>();
    public static ArrayList<TestFile> fileList = new ArrayList<TestFile>();
    public static String destination = "./snippet/copyTo";
    public static String source = "C:\\DEV_JJOBS_V2\\gitspaces\\java\\FileTransfer\\TEMP\\SERVER";

    public static void main(String[] args) {
        RecursiveFileCopy main = new RecursiveFileCopy();
        main.testMain();
    }

    public void testMain() {
        subDirList(this.source);

        // 디렉토리 생성
        for (int i = 0; i < dirList.size(); i++) {
            File temp = new File(dirList.get(i));
            if (!temp.exists()) {
                temp.mkdirs();
            }
        }

        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            for (int i = 0; i < this.fileList.size(); i++) {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fileList.get(i).ft)));
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileList.get(i).path)));
                while (true) {
                    String str = br.readLine();
                    if (str == null) break;
                    bw.write(str);
                    bw.newLine();
                }
                br.close();
                bw.close();
            }
        } catch (IOException E) {
        }
    }

    public void subDirList(String source) {
        File dir = new File(source);
        File[] fileList = dir.listFiles();
        try {
            for (int i = 0; i < fileList.length; i++) {
                File file = fileList[i];
                if (file.isFile()) {
                    String rep = this.source.replaceAll("\\\\", "/");
                    String path = this.destination + file.getPath().replaceAll("\\\\", "/").replaceAll(rep, "");
                    TestFile tf = new TestFile();
                    tf.path = path;
                    tf.ft = file;
                    System.out.println(path);
                    this.fileList.add(tf);
                } else if (file.isDirectory()) {
                    String rep = this.source.replaceAll("\\\\", "/");
                    String path = this.destination + file.getPath().replaceAll("\\\\", "/").replaceAll(rep, "");
                    this.dirList.add(path);
                    subDirList(file.getCanonicalPath().toString());
                }
            }
        } catch (IOException e) {

        }
    }

    public void subDirList2(String source){
        File dir = new File(source);
        File[] fileList = dir.listFiles();
        try{

            for(int i = 0 ; i < fileList.length ; i++){
                File file = fileList[i];
                if(file.isFile()){
                    // 파일이 있다면 파일 이름 출력
                    System.out.println("\t 파일 이름 = " + file.getName());
                }else if(file.isDirectory()){
                    System.out.println("디렉토리 이름 = " + file.getName());
                    // 서브디렉토리가 존재하면 재귀적 방법으로 다시 탐색
                    subDirList2(file.getCanonicalPath().toString());
                }
            }
        }catch(IOException e){

        }

    }
}