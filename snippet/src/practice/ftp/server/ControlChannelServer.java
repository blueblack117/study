package practice.ftp.server;

import logger.TestLogger;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ControlChannelServer implements Runnable {

    private Socket socket;

    public ControlChannelServer(Socket socket) {
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
                TestLogger.print(new Date() + "]] CTRL >> " + command);

                if ("exit".equals(command)) {
                    break;
                }

                command = inStream.readUTF();
                TestLogger.print(new Date() + "]] Filename >> " + command);

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
}
