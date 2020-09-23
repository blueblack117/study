package practice.ftp.client;

import logger.TestLogger;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ControlChannelClient {

    public static void download(String fileName) {
        Socket client;
        try {
            client = new Socket("127.0.0.1", 30000);
            DataInputStream inStream = new DataInputStream(client.getInputStream());
            DataOutputStream outStream = new DataOutputStream(client.getOutputStream());

            String[] arrCTRL = new String[] {"download", "exit"};
            for (String ctrl : arrCTRL) {

                TestLogger.print("sendMsg >> " + ctrl);
                outStream.writeUTF(ctrl);

                if ("exit".equals(ctrl)) {
                    break;
                }

                TestLogger.print("sendMsg >> " + fileName);
                outStream.writeUTF(fileName);
            }

            inStream.close();
            outStream.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
