package practice.ftp.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {
    public static String clientFolder = "\\TEMP\\CLIENT\\";
    public static void main(String[] args) {

        String fileName = "test1.txt";

        ControlChannelClient.download(fileName);
    }
}
