package file.buffered;

import java.io.*;

/**
 * BufferedReader, PrintWriter를 이용한 파일 읽고 쓰기
 */
public class ReadAndWriteFromFileMain {
    public static void main(String[] args) {
        String fname = "./snippet/sample/OUTPUT/aaa.txt";
        try {
            readnwrite(fname, false);//clear
            //baw.readnwrite("aaa.txt",true);//append
            readFile(fname);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void readFile(String fn) throws IOException {
        FileReader fr = new FileReader(fn);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        String temp = "";
        while ((temp = br.readLine()) != null) {
            sb.append(temp + "\n");
        }
        System.out.println(sb.toString());
        br.close();
        fr.close();
    }

    public static void readnwrite(String fn, boolean append) throws IOException {
        String s = null;
        FileWriter fw = new FileWriter(fn, append); //append true
        PrintWriter pw = new PrintWriter(fw);       //flush false
        //PrintWriter pw=new PrintWriter(fw, true); //flush true
        while ((s = readbuff()) != null) {          //CTRL+C
            pw.println(s);
            pw.flush();                             //PrintWriter(fw, true)일 때는 필요없다.
        }
        pw.close();
        fw.close();
    }

    public static String readbuff() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
