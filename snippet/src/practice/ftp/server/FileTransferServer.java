package practice.ftp.server;

import logger.TestLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FileTransferServer implements Runnable {

    private Socket socket;

    public FileTransferServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String echo;
            while ((echo = in.readLine()) != null) {
                TestLogger.print("echo: " + echo + " (from " + socket.getPort() + ")");
                out.println(echo);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            TestLogger.print("Client close (from " + socket.getPort() + ")");
        }
    }
}
