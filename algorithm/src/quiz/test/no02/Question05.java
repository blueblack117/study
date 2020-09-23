package quiz.test.no02;

/**
 *
 * 당신은 체스의 룩(Rook)과 나이트(Knight)를 합성한 새로운 말 룩나이트를 고안했습니다. 퀸이 룩과 비숍을 합친 것처럼, 룩나이트는 다음 그림과 같이 룩과 나이트가 이동할 수 있는 지점을 모두 이동할 수 있습니다.
 * *
 * 즉, n x n 크기의 체스판에서 x행 y열 (x, y)에 있던 룩나이트가 이동할 수 있는 칸들은 다음과 같습니다.
 *
 * x행 또는 y열에 있는 모든 칸
 * (x+2, y+1), (x+2, y-1), (x-2, y+1), (x-2, y-1)
 * (x+1, y+2), (x+1, y-2), (x-1, y+2), (x-1, y-2)
 * 단, 목적지가 체스판 바깥이거나 파손되었을 경우, 룩나이트는 해당 칸으로 이동할 수 없습니다. 하지만, 목적지가 체스판 안에 있는 파손되지 않은 칸이라면, 시작 지점에서 목적지까지 가는 중간에 있는 칸들의 파손 유무에 상관없이 항상 이동할 수 있습니다. 예를 들어, (1, 1)에서 (1, 3)까지 가는 길에 (1, 2)가 파손되었다 하더라도, (1, 3)이 파손되지만 않았다면 룩나이트는 이동할 수 있습니다.
 *
 * 정사각형 체스판의 행과 열의 개수 n, 그 체스판의 파손된 위치들을 나타내는 2차원 정수 배열 blocks가 매개변수로 주어집니다. 이때, n개의 룩나이트를 서로 공격할 수 없는 위치에 배치하는 경우의 수를 return 하도록 solution 함수를 완성해주세요. 단, 파손된 위치에는 룩나이트를 배치할 수 없습니다.
 *
 * 제한 사항
 * n은 2 이상 9 이하인 자연수입니다.
 * blocks의 행의 길이(= 파손된 위치의 개수)는 1 이상 n2 - n 이하입니다.
 * blocks의 각 행은 [r, c] 2개의 정수로 이루어져 있으며, 이는 체스판의 r행 c열이 파손되어 해당 위치에 룩나이트를 놓을 수 없음을 의미합니다.
 * r과 c는 1 이상 n 이하인 자연수입니다.
 * blocks의 모든 위치는 서로 다릅니다.
 *
 * 입출력 예
 * n	blocks	result
 * 3	[[1,2],[2,1]]	2
 * 4	[[1,3],[1,4],[2,1],[2,2],[3,3],[3,4],[4,1],[4,2]]	0
 * 2	[[1,1]]	1
 *
 * 입출력 예 설명
 * 입출력 예 #1 *
 * 주어진 체스판에서 가능한 경우의 수 2가지는 다음 그림과 같습니다.
 *
 * 입출력 예 #2 * *
 * 이 경우에서는 주어진 조건을 만족하면서 룩나이트 4개를 배치하는 것이 불가능하므로, 0을 return 해야 합니다.
 *
 * 입출력 예 #3 *
 * 주어진 체스판에서 가능한 경우의 수 1가지는 다음 그림과 같습니다.
 *
 */
public class Question05 {
    public static void main(String[] args) {
        Question05 alg = new Question05();
//        int[][] test1 = new int[][] {{1,2},{2,1}};
//        System.out.println(alg.solution(3, test1));
//
//        int[][] test2 = new int[][] {{1,3},{1,4},{2,1},{2,2},{3,3},{3,4},{4,1},{4,2}};
//        System.out.println(alg.solution(4, test2));
//
//        int[][] test3 = new int[][] {{1,1}};
//        System.out.println(alg.solution(2, test3));

        int[][] test4 = new int[][] {};
//        System.out.println(alg.solution(3, test4));
//        System.out.println(alg.solution(4, test4));
        System.out.println(alg.solution(5, test4));
//        System.out.println(alg.solution(6, test4));
    }

    static int count = 0;  //Solution 개수
    static int[][] checkMove = new int[][] {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2}
    };

    public int solution(int n, int[][] blocks) {
        count = 0;
        int[][] chess = new int[n][n];

        for (int inx=0; inx<blocks.length; inx++) {
            int[] crash = blocks[inx];
            chess[crash[0]-1][crash[1]-1] = -999;
        }

        calculateNumberOfCases(chess);

        int answer = count;
        return answer;
    }

    public void calculateNumberOfCases(int[][] chess) {
        int[] cols = new int[chess.length];
        calculateNumberOfCases(chess, cols, 0);
    }

    public void calculateNumberOfCases(int[][] chess, int[] cols, int x) {
        int N = chess.length;
        // n이 끝까지 돌았다면 카운트를 증가한다.
        if (x == N) {
            count++;
            printResult(cols);
        } else {
            for (int i = 0; i < N; i++) {
                cols[x] = i;
                if (isPossible(chess, cols, x)) {
                    calculateNumberOfCases(chess, cols, x + 1);   // 유망하다면 계속 탐색(재귀호출)
                }
            }
        }
    }

//    private boolean test(int[][] chess, int[] cols, int n) {
//        return true;
//    }

    private boolean isPossible(int[][] chess, int[] cols, int n) {
        if (chess[n][cols[n]] == -999) {
            return false;
        }

        for (int row = 0; row < n; row++) {
            int col = cols[row];

            // 같은 열인지 체크
            if (cols[row] == cols[n]) {
                return false;
            }

            // 이동 가능 위치 체크
            for (int inx=0; inx<checkMove.length; inx++) {
                int moveX = row + checkMove[inx][0];
                int moveY = col + checkMove[inx][1];
                if (moveX >=0 && moveX <= n
                        && moveY >=0 && moveY <= chess.length
                        && cols[moveX] == moveY) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isPossible(int[][] blocks, int[][] checkMove, int x, int y) {
//        boolean possible = true;
        if (blocks[x][y] == - 999 || blocks[x][y] == 1) {
            return false;
        }
        for (int inx=0; inx<blocks.length; inx++) {
            if ((inx != y && blocks[x][inx] == 1)
                    || (inx != x && blocks[inx][y] == 1)) {
                return false;
            }
        }
        for (int inx=0; inx<checkMove.length; inx++) {
            int moveX = x + checkMove[inx][0];
            int moveY = y + checkMove[inx][1];
            if (moveX >=0 && moveX <= blocks.length
                    && moveY >=0 && moveY <= blocks.length
                    && blocks[moveX][moveY] == 1) {
                return false;
            }
        }
        return true;
    }

    public void printResult(int[] answer) {
        for (int inx=0; inx<answer.length; inx++) {
            System.out.print(answer[inx] + ",");
        }
        System.out.println();
    }
}
