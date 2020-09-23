package practice.ftp.server;

import logger.TestLogger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {
    public static void main(String[] args) {
        int portNumber = 30000;

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            TestLogger.print("ServerSocket listen (" + portNumber + ")");

            ExecutorService es = Executors.newFixedThreadPool(5);
            while (true) {
                es.submit(new ControlChannelServer(serverSocket.accept()));
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
