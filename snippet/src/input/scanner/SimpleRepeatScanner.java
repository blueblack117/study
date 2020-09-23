package input.scanner;

import java.util.Scanner;

/**
 * 사용자에게서 계속 값 입력 받기
 */
public class SimpleRepeatScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 값 입력 전에 Console에 표시할 내용. println()이 아니고 print()임.
            System.out.print("VALUE : ");

            // 값 받기
            String value = scanner.nextLine();

            // 종료 문자면 break
            if ("q".equals(value)) break;

            // [[값 처리]]
            System.out.println(value);
        }

        scanner.close();
    }
}
