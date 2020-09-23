package input.scanner;

import java.util.Scanner;

/**
 * 사용자에게서 1개의 값 입력 받기
 */
public class SimpleScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 값 입력 전에 Console에 표시할 내용. println()이 아니고 print()임.
        System.out.print("VALUE : ");

        // 값 받기
        String value = scanner.nextLine();

        scanner.close();

        //[[값 처리]]
        System.out.println(value);
    }
}
