package logger;

import java.util.List;

public class TestLogger {

    public static boolean bTest = true;

    public static void print(String str) {
        if (bTest) {
            System.out.println(str);
        }
    }

    public static void print(Object o) {
        if (bTest) {
            System.out.println(o);
        }
    }

    public static void print(List list) {
        if (bTest) {
            for (Object obj : list) {
                System.out.println(obj);
            }
        }
    }

    public static void print(byte[] arrByte) {
        for (byte b : arrByte) {
            System.out.print(b);
        }
        System.out.println();
    }
}
