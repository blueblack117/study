package file.search;

import java.io.File;
import java.util.ArrayList;

public class RecursiveExplorer {

    public static void main(String[] args) {
        File f = new File("./snippet/sample");
        ArrayList<File> subFiles = new ArrayList<File>();
        if (!f.exists()) {
            System.out.println("디렉토리가 존재하지 않습니다");
            return;
        }
        findSubFiles(f, subFiles);
        System.out.println("——————————— -");
        for (File file : subFiles) {
            if (file.isFile()) {
                System.out.println("파일 이름 : " + file.getName());
                try {
                    System.out.println("파일 경로 : " + file.getCanonicalPath());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("파일 크기 : " + file.length());
                System.out.println("——————————— -");
            } else if (file.isDirectory()) {
                System.out.println("디렉토리 이름 : " + file.getName());
                try {
                    System.out.println("디렉토리 경로 : " + file.getCanonicalPath());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("——————————— -");
            }
        }
    }

    public static void findSubFiles(File parentFile, ArrayList<File> subFiles) {
        if (parentFile.isFile()) {
            subFiles.add(parentFile);
        } else if (parentFile.isDirectory()) {
            subFiles.add(parentFile);
            File[] childFiles = parentFile.listFiles();
            for (File childFile : childFiles) {
                findSubFiles(childFile, subFiles);
            }
        }
    }

}
