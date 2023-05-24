package practice.proxy;

import logger.TestLogger;
import practice.message.queue.ProcessTimeoutChecker;
import practice.proxy.http.ProxyServer;

import java.io.*;
import java.util.Date;

public class FileService {
    public static void readProxyFile(String filename) {
        File sourceFile = new File(".\\snippet\\sample\\proxy\\" + filename);
//        TestLogger.print(sourceFile.getAbsolutePath());
        if (sourceFile.exists() && sourceFile.isFile()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(sourceFile));

                String line = null;
                while ((line = br.readLine()) != null) {
//                    TestLogger.print(line);
                    String[] arrStr = line.split("#");
                    if ("I".equals(arrStr[0])) {
                        ProxyServer proxyServer = new ProxyServer(Integer.parseInt(arrStr[1]));
                        proxyServer.setName(filename.substring(0, filename.indexOf(".")));

		                Thread proxyServerThread = new Thread(proxyServer);
                        proxyServerThread.start();

                        ProxyMain.mapProxyServer.put(proxyServer.getName(), proxyServer);
                    } else if ("P".equals(arrStr[0])) {
                        readProxyFile(arrStr[1]);
                    } else {
                        readServiceFile(arrStr[0], arrStr[1]);
                    }
                }
                br.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            TestLogger.print(new Date() + "]] Filename is not exist.");
        }
    }

    public static void readServiceFile(String action, String filename) {
        File sourceFile = new File(".\\snippet\\sample\\proxy\\" + filename);
        if (sourceFile.exists() && sourceFile.isFile()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(sourceFile));

                String line = null;
                while ((line = br.readLine()) != null) {
                    TestLogger.print(line);
                }
                br.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            TestLogger.print(new Date() + "]] Filename is not exist.");
        }
    }
}
