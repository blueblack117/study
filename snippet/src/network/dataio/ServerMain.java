package network.dataio;

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

            String command = null;
            boolean isRunning = true;
            while (isRunning) {
                command = inStream.readUTF();
                TestLogger.print("CTRL >> " + command);

                if ("exit".equals(command)) {
                    break;
                }

                command = inStream.readUTF();
                TestLogger.print("Filename >> " + command);

                // file 전송

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

        ExecutorService es = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            TestLogger.print("ServerSocket listen (" + portNumber + ")");

            while (true) {
                es.submit(new ServerMain(serverSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            TestLogger.print("ServerSocket close (" + portNumber + ")");
        }
    }
}
