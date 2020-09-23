package quiz.test.no02;

/**
 * rows x columns 크기의 행렬이 있습니다. 각 칸은 숫자가 들어있는 정사각형입니다.
 * 당신은 이 행렬의 부분 직사각형을 여러 번 골라 그 내부를 스와이프하려고 합니다.
 *
 * 행렬의 직사각형을 스와이프한다는 것은,
 * 다음 그림과 같이 특정 영역의 숫자들을 빨간색 화살표 방향으로 밀어내고,
 * 사라진 숫자들을 다시 빈 칸에 순서대로 채워넣는다는 것을 의미합니다.
 *
 * ex.png
 *
 * 위 그림의 첫 번째 예시에서는 2행 2열부터 3행 4열까지를 스와이프했으며,
 * 여기서 사라졌다가 다시 빈 칸에 채워진 숫자들은 8과 12입니다.
 * 위 그림의 두 번째 예시에서는 1행 3열부터 4행 4열까지를 스와이프했으며,
 * 여기서 사라졌다가 다시 빈 칸에 채워진 숫자들은 15와 16입니다.
 *
 * 스와이프를 하는 방향은 다음과 같이 4가지입니다.
 *
 * 행 번호가 증가하는 방향. r행 c열에 있던 숫자는 r+1행 c열로 이동하게 됩니다.
 * 행 번호가 감소하는 방향. r행 c열에 있던 숫자는 r-1행 c열로 이동하게 됩니다.
 * 열 번호가 증가하는 방향. r행 c열에 있던 숫자는 r행 c+1열로 이동하게 됩니다.
 * 열 번호가 감소하는 방향. r행 c열에 있던 숫자는 r행 c-1열로 이동하게 됩니다.
 * 편의상 위 4개의 방향들을 순서대로 1번, 2번, 3번, 4번 방향이라고 합니다.
 *
 * 행렬의 가로줄(행)의 개수 rows, 세로줄(열)의 개수 columns,
 * 그리고 스와이프 행위의 방향과 범위를 나타내는 수들의 목록 swipes가 매개변수로 주어집니다.
 * 각각의 스와이프 행위에 대해서, 사라졌다가 다시 행렬에 채워지는 숫자들의 합을 배열에 담아 return 하도록
 * solution 함수를 완성해주세요.
 *
 * 제한 사항
 * rows는 2 이상 50 이하의 정수입니다.
 * columns는 2 이상 50 이하의 정수입니다.
 * 초기 상태에서 행렬의 i행 j열에 들어있는 숫자는 ((i-1) x columns + j) 입니다.
 * swipes의 행의 개수(= 스와이프 행위의 개수)는 1 이상 100 이하입니다.
 * swipes의 각 행은 5개의 정수 d, r1, c1, r2, c2로 이루어져 있습니다.
 * 이는 r1행 c1열부터 r2행 c2열까지의 모든 숫자들을 d번 방향으로 스와이프한다는 의미입니다.
 * d는 1 이상 4 이하입니다.
 * 1 ≤ r1 ≤ r2 ≤ rows, 1 ≤ c1 ≤ c2 ≤ columns 입니다.
 * 단, 스와이핑으로 인해 해당 영역의 모든 수가 사라지는 경우는 입력으로 주어지지 않습니다.
 * 모든 스와이핑은 순서대로 이루어집니다.
 * 예를 들어 2번째 스와이핑에 대한 답을 구할 때는 1번째 스와이핑을 실행하고 나서,
 * 2번째 스와이핑을 실행한 결과를 return 해야 합니다.
 *
 * 입출력 예
 * rows	columns	swipes	result
 * 4	3	[[1,1,2,4,3],[3,2,1,2,3],[4,1,1,4,3],[2,2,1,3,3]]	[23,3,21,9]
 * 2	4	[[3,1,2,2,4],[3,1,2,2,4],[4,2,1,2,3],[1,1,1,2,3]]	[12,10,5,20]
 * 2	2	[[3,1,1,1,2],[1,1,2,2,2],[4,2,1,2,2],[2,1,1,2,1]]	[2,4,3,2]
 *
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 주어진 입력대로 스와이핑을 수행하는 과정을 그림으로 표현하면 다음과 같습니다.
 * ex1.png
 * 각각의 스와이핑 행위에 대해서, 사라졌다가 다시 채워지는 숫자들은 (11, 12), (3), (1, 3, 7, 10), (4, 2, 3) 입니다. 따라서 [23, 3, 21, 9]를 return 해야 합니다.
 * 입출력 예 #2
 *
 * 주어진 입력대로 스와이핑을 수행하는 과정을 그림으로 표현하면 다음과 같습니다.
 * ex2.png
 * 각각의 스와이핑 행위에 대해서, 사라졌다가 다시 채워지는 숫자들은 (4, 8), (3, 7), (5), (7, 8, 5) 입니다. 따라서 [12, 10, 5, 20]을 return 해야 합니다.
 * 입출력 예 #3
 *
 * 주어진 입력대로 스와이핑을 수행하는 과정을 그림으로 표현하면 다음과 같습니다.
 * ex3.png
 * 각각의 스와이핑 행위에 대해서, 사라졌다가 다시 채워지는 숫자들은 (2), (4), (3), (2) 입니다. 따라서 [2, 4, 3, 2]를 return 해야 합니다.
 * *
 * 4	3	{{1,1,2,4,3},{3,2,1,2,3},{4,1,1,4,3},{2,2,1,3,3}}	{23,3,21,9}
 * 2	4	{{3,1,2,2,4},{3,1,2,2,4},{4,2,1,2,3},{1,1,1,2,3}}	{12,10,5,20}
 * 2	2	{{3,1,1,1,2},{1,1,2,2,2},{4,2,1,2,2},{2,1,1,2,1}}	{2,4,3,2}
 */
public class Question06 {
    public static void main(String[] args) {
        Question06 alg = new Question06();
        int[][] test1 = new int[][] {{1,1,2,4,3},{3,2,1,2,3},{4,1,1,4,3},{2,2,1,3,3}};
        int[] result1 = alg.solution(4, 3, test1);
        alg.printResult(result1);

        int[][] test2 = new int[][] {{3,1,2,2,4},{3,1,2,2,4},{4,2,1,2,3},{1,1,1,2,3}};
        int[] result2 = alg.solution(2, 4, test2);
        alg.printResult(result2);

        int[][] test3 = new int[][] {{3,1,1,1,2},{1,1,2,2,2},{4,2,1,2,2},{2,1,1,2,1}};
        int[] result3 = alg.solution(2, 2, test3);
        alg.printResult(result3);
    }

    public int[] solution(int rows, int columns, int[][] swipes) {
        int[][] arr = new int[rows][columns];
        for (int inx=1; inx<=rows; inx++) {
            for (int jnx=1; jnx<=columns; jnx++) {
                arr[inx-1][jnx-1] = ((inx-1) * columns + jnx);
            }
        }

        int[] answer = new int[swipes.length];
        int result = 0;
        for (int inx=0; inx<swipes.length; inx++) {
            result = swipe(arr, swipes[inx]);
            answer[inx] = result;
        }
        return answer;
    }

    private int swipe(int[][] arr, int[] swipe) {
        int result = 0;
        int d = swipe[0], r1 = swipe[1]-1, c1 = swipe[2]-1, r2 = swipe[3]-1, c2 = swipe[4]-1;

        switch (d) {
            case 1: // row -> row + 1
                for (int col=c1; col<=c2; col++) {
                    int drop = arr[r2][col];
                    for (int row=r2; row>r1; row--) {
                        arr[row][col] = arr[row-1][col];
                    }
                    arr[r1][col] = drop;
                    result += drop;
                }
                break;
            case 2: // row -> row - 1
                for (int col=c1; col<=c2; col++) {
                    int drop = arr[r1][col];
                    for (int row=r1; row<r2; row++) {
                        arr[row][col] = arr[row+1][col];
                    }
                    arr[r2][col] = drop;
                    result += drop;
                }
                break;
            case 3: // c -> col + 1
                for (int row=r1; row<=r2; row++) {
                    int drop = arr[row][c2];
                    for (int col=c2; col>c1; col--) {
                        arr[row][col] = arr[row][col-1];
                    }
                    arr[row][c1] = drop;
                    result += drop;
                }
                break;
            case 4: // c -> col - 1
                for (int row=r1; row<=r2; row++) {
                    int drop = arr[row][c1];
                    for (int col=c1; col<c2; col++) {
                        arr[row][col] = arr[row][col+1];
                    }
                    arr[row][c2] = drop;
                    result += drop;
                }
                break;
        }
        return result;
    }

    public void printResult(int[] answer) {
        for (int inx=0; inx<answer.length; inx++) {
            System.out.print(answer[inx] + ",");
            if (inx % 2 == 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
