package network.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 30000;

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket socket = serverSocket.accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String echo;
        while ((echo = in.readLine()) != null) {
            System.out.println("echo: " + echo);
            out.println(echo);
            out.flush();
        }

        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
}

