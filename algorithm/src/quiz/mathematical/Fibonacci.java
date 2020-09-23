package quiz.mathematical;

/**
 * 피보나치 수열이란, 첫 번째 항의 값이 0이고 두 번째 항의 값이 1일 때, 이후의 항들은 이전의 두 항을 더한 값으로 이루어지는 수열
 * 예) 0, 1, 1, 2, 3, 5, 8, 13
 *
 * 인풋을 정수 n으로 받았을때, n 이하까지의 피보나치 수열을 출력
 */
public class Fibonacci {
    public static void main(String[] args) {
        int i = 5;
        System.out.print(fibonacci(i));

        System.out.print(fibonacci2(i));

        System.out.print(fibonacci3(i));
    }

    /**
     * 재귀 호출
     *
     */
    public static int fibonacci(int n){
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }

    /**
     * 메모제이션
     * 단순 재귀호출보다 더 나은 성능을 위해 메모제이션 기법을 활용할 수 있습니다. 결과를 저장하여 다음번에 계산하지 않고 활용하는 방법
     */
    static int memo[] = new int[50];
    public static int fibonacci2(int n){
        if (n <= 1) {
            return n;
        } else if (memo[n] != 0) {
            return memo[n];
        } else {
            memo[n] = fibonacci(n-2) + fibonacci(n-1);
            return memo[n];
        }
    }

    /**
     * 배열과 반복문
     */
    static int fibo[] = new int[100];
    public static int fibonacci3(int n){
        fibo[0] = 0;
        fibo[1] = 0;
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i -1] + fibo[i - 2];
        }
        return fibo[n];
    }
}
