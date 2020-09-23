package network.dataio.array;

import logger.TestLogger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain implements Runnable {

    private Socket socket;

    public ServerMain(Socket socket) {
        this.socket = socket;
        TestLogger.print("ServerSocket open (" + socket.getPort() + ")");
    }

    @Override
    public void run() {
        DataInputStream inStream = null;
        DataOutputStream outStream = null;
        try {
            inStream = new DataInputStream(socket.getInputStream());
            outStream = new DataOutputStream(socket.getOutputStream());

            byte[] arrByte = new byte[10000];
            for (int inx=0; inx<5000; inx++) {
                arrByte[inx] = (byte)0;
            }
            for (int inx=5000; inx<10000; inx++) {
                arrByte[inx] = (byte)1;
            }

            String command = null;
            boolean isRunning = true;
            while (isRunning) {
                command = inStream.readUTF();
                TestLogger.print("CTRL >> " + command);

                if ("exit".equals(command)) {
                    break;
                }

                // byte 전송
                outStream.write(arrByte, 0, 10000);
                TestLogger.print("SEND >> " + arrByte);

                isRunning = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null) inStream.close();
                if (outStream != null) outStream.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            TestLogger.print("SocketClient close (from " + socket.getPort() + ")");
        }
    }

    public static void main(String[] args) {
        int portNumber = 30000;

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            TestLogger.print("ServerSocket listen (" + portNumber + ")");

            ExecutorService es = Executors.newFixedThreadPool(5);
            while (true) {
                es.submit(new ServerMain(serverSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            TestLogger.print("ServerSocket close (" + portNumber + ")");
        }
    }
}
