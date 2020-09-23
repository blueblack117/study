package optimization.backtracking;

/**
 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
 *
 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 *
 *
 * 입력 및 출력
 *
 * 첫째 줄에 N이 주어진다. (1 ≤ N < 15) 출력은 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 *
 * http://sooyoung32.github.io/dev/2016/03/14/n-queen-algorithm.html
 */
public class NQueensProblem2 {
    static int count = 0;
    public static boolean isPromising(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) return false;   // 같은 열인지
            if ((q[i] - q[n]) == (n - i)) return false;   // '\' 방향
            if ((q[n] - q[i]) == (n - i)) return false;   // '/' 방향
        }
        return true;
    }

    public static void enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int n) {
        int N = q.length;
        // n이 끝까지 돌았다면 카운트를 증가한다.
        if (n == N) {
            count++;
        } else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isPromising(q, n)) enumerate(q, n + 1);   // 유망하다면 계속 탐색(재귀호출)
            }
        }
    }

    public static void main(String[] args) {
        for (short n = 1; n < 14; n++) {
            enumerate(n);
            System.out.println("n = " + (n < 10 ? "0" : "") + n + ", solution count is " + count + ".");
            count = 0;
        }
    }
}
