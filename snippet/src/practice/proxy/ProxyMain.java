package practice.proxy;

import practice.proxy.http.ProxyServer;

import java.util.*;

public class ProxyMain {

    public static Map<String, ProxyServer> mapProxyServer = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 값 입력 전에 Console에 표시할 내용. println()이 아니고 print()임.
            System.out.print("proxy file : ");

            // 값 받기
            String value = scanner.nextLine();

            // 종료 문자면 break
            if ("q".equals(value)) break;

            // [[값 처리]]
            System.out.println(value);

            FileService.readProxyFile(value);
        }

        for (String key : mapProxyServer.keySet()) {
            ProxyServer proxyServer = mapProxyServer.get(key);
            proxyServer.setbStop(true);
        }
        scanner.close();
    }
}
