package quiz.test.no02;

/**
 * 정수 a, b, c가 매개변수로 주어집니다.
 * 이들 중 둘을 선택하여 더하거나, 빼거나, 또는 곱했을 때 나올 수 있는 수들 중 최댓값을 구하여 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * a, b, c는 모두 -10,000 이상 10,000 이하인 정수입니다.
 *
 * 입출력 예
 * a	b	c	result
 * -2	4	-5	10
 * 1	0	1	2
 * 1	-7	5	12
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * a와 c를 곱하면 10이 되며, 이 값이 최댓값입니다.
 * 입출력 예 #2
 *
 * a와 c를 더하면 2가 되며, 이 값이 최댓값입니다.
 * 입출력 예 #3
 *
 * c에서 b를 빼면 12가 되며, 이 값이 최댓값입니다.
 */
public class Question01 {

    public static void main(String[] args) {
        Question01 alg = new Question01();

        System.out.println(alg.solution(-2, 4, -5));
        System.out.println(alg.solution(1, 0, 1));
        System.out.println(alg.solution(1, -7, 5));
    }

    public int solution(int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        int[][] addArr = new int[arr.length][arr.length];
        int[][] subArr = new int[arr.length][arr.length];
        int[][] mulArr = new int[arr.length][arr.length];

        for (int inx=0; inx<arr.length; inx++) {
            for (int jnx=0; jnx<arr.length; jnx++) {
                if (inx == jnx) {
                    addArr[inx][jnx] = -999;
                } else {
                    addArr[inx][jnx] = arr[inx] + arr[jnx];
                    subArr[inx][jnx] = arr[inx] - arr[jnx];
                    mulArr[inx][jnx] = arr[inx] * arr[jnx];
                }
            }
        }
        int answer = -999;
        for (int inx=0; inx<arr.length; inx++) {
            for (int jnx=0; jnx<arr.length; jnx++) {
                if (addArr[inx][jnx] > answer) {
                    answer = addArr[inx][jnx];
                }
                if (subArr[inx][jnx] > answer) {
                    answer = subArr[inx][jnx];
                }
                if (mulArr[inx][jnx] > answer) {
                    answer = mulArr[inx][jnx];
                }
            }
        }
        return answer;
    }
}
