package network.simple;

import logger.TestLogger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerMain {

    public static void main(String[] args) {
        try {
            startServerSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startServerSocket() throws IOException {
        ServerSocket server = new ServerSocket(9101);
        TestLogger.print("[listen]");

        while (true) {
            Socket socket = server.accept();
            TestLogger.print("[accept]");

            //----[ 데이터 받아서 처리하기 ]----------------------------------------

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String data = "";
            char[] chars = new char[256];
            int length;
            while ((length = bufferedReader.read(chars)) != -1) {
                String newData = new String(chars, 0, length);

                if ("[END]".equals(newData)) {
                    TestLogger.print("[RECV] END");
                    length = -1;
                    break;
                }

                // 새로 전송받은 데이터(newData) 처리
                data += newData;
                TestLogger.print("[newData] " + newData);
            }

            //    [[전송받은 전체 데이터(data) 처리]]
            TestLogger.print("[RECV]" + data);

            //----[ Client에게 데이터 보내기 ]----------------------------------------

            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);

            printWriter.print("[SEND]" + "Send Test Data...." + new Date());
            TestLogger.print("[SEND]");
            printWriter.flush();

            //----[ Client와의 연결 종료 ]----------------------------------------

            printWriter.close();
            outputStreamWriter.close();
            outputStream.close();

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            socket.close();

            // 전송받은 전체 데이터가 종료 명령이면 break
            if (length == -1) {
                TestLogger.print("[END] socket");
                break;
            }
        }
        server.close();
    }
}
