package file.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderLauncher {

    public static void main(String[] args) {
        String addr = "http://www.naver.com";
        Process process = null;
//        String[] cmd = new String[] {"cmd", "dir", "/w"};
////        String[] cmd = new String[] {"rundll32", "url.dll", "FileProtocolHandler", addr};

        String[] cmd = new String[] {"cmd", "/c", "dir", "/w"};
        String str = null;

        try {

            // 프로세스 빌더를 통하여 외부 프로그램 실행
            process = new ProcessBuilder(cmd).start();

            // 외부 프로그램의 표준출력 상태 버퍼에 저장
            BufferedReader stdOut = new BufferedReader( new InputStreamReader(process.getInputStream()) );

            // 표준출력 상태를 출력
            while( (str = stdOut.readLine()) != null ) {
                System.out.println(str);
            }

//            Process process = pBuilder.start();
//            synchronized (process) {
//                process.waitFor();
//            }
//            int exitValue = process.exitValue();

            // 외부 프로그램 반환값 출력 (이 부분은 필수가 아님)
            System.out.println("Exit Code: " + process.exitValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
