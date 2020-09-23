package network.simple;

import logger.TestLogger;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ClientMain {
    public static void main(String[] args) {
        try {
            startClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startClient() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9101);
        TestLogger.print("[Socket]");

        //----[ Server에게 데이터 보내기 ]----------------------------------------

        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

        TestLogger.print("[SEND] MGS");
        printWriter.print("send the message from client..." + new Date());
        printWriter.flush();

        TestLogger.print("[SEND] END");
        printWriter.print("[END]");
        printWriter.flush();

        //----[ Server가 보내는 값 받아서 처리하기 ]----------------------------------------

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String data = "";
        char[] chars = new char[256];
        int length;
        while ((length = bufferedReader.read(chars)) != -1) {
            String newData = new String(chars, 0, length);

            // 새로 전송받은 데이터(newData) 처리
            data += newData;
            TestLogger.print("[newData] " + newData);
        }

        //[[전송받은 전체 데이터(data) 처리]]
        TestLogger.print("[RECV]" + data);

        //----[ Server와의 연결 종료 ]----------------------------------------

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        printWriter.close();
        outputStreamWriter.close();
        outputStream.close();

        socket.close();
        TestLogger.print("[END] socket");
    }
}
