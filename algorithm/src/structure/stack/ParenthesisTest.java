package structure.stack;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열
 * 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 출력
 *
 * 예제입력
 *
 * (())())
 * (((()())()
 * (()())((()))
 * ((()()(()))(((())))()
 * ()()()()(()()())()
 * (()((())()(
 *
 * 예제출력
 * NO
 * NO
 * YES
 * NO
 * YES
 * NO
 */
public class ParenthesisTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        sc.nextLine();
        for (int test_case = 0; test_case < T; test_case++) {
            String input = sc.nextLine();
            if (solve(input)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static boolean solve(String inputs) {
        boolean isCorrect = true;
        Stack<Character> resultStack = new Stack<Character>();

        char[] insertArray = inputs.toCharArray();
        for (int i = 0; i < insertArray.length; i++) {
            if (insertArray[i] == '(') {
                resultStack.push(insertArray[i]);
            } else {
                try {
                    if (resultStack.peek() == null) {
                        isCorrect = false;
                        break;
                    } else {
                        resultStack.pop();
                    }
                } catch (EmptyStackException e) {
                    isCorrect = false;
                    break;
                }
            }
        }
        if (isCorrect && resultStack.peek() != null) isCorrect = false;
        return isCorrect;
    }
}
