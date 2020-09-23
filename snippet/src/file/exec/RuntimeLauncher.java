package file.exec;

public class RuntimeLauncher {
    public static void main(String[] args) {
        String fileName = "메모장";
        System.out.println("fileName : " + fileName);

        if (fileName != null && !fileName.isEmpty()) {

            // 파라미터로 받은 이름을 조건으로 실행할 프로그램을 선택, 아무것도 입력하지 않을 경우 계산기가 실행 됨.
            String directory = "C://Windows//System32//calc.exe";

            if (fileName.equals("계산기")) {
                directory = "C://Windows//System32//calc.exe";
            } else if (fileName.equals("메모장")) {
                directory = "C://Windows//System32//notepad.exe";
            } else if (fileName.equals("그림판")) {
                directory = "C://Windows//System32//mspaint.exe";
            }

            // 실제로 파일을 실행하는 구간------------------------------------
            Runtime rt = Runtime.getRuntime();
            System.out.println("directory: " + directory);
            Process p;

            try {
                p = rt.exec(directory);
                int exitValue = p.waitFor();
                System.out.println("exitValue: " + exitValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 실제로 파일을 실행하는 구간------------------------------------
        }
    }
}
