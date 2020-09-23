package quiz.test.no02;

/**
 * 정수들이 담긴 배열 numbers가 매개변수로 주어집니다. 이들을 각 그룹에 속한 원소들의 합을 구했을 때 합의 차이가 최소가 되도록 두 그룹으로 나누고, 그때의 합의 차이를 return 하도록 solution 함수를 완성해주세요. 단, 각 그룹에는 숫자가 적어도 하나 이상은 들어있어야 합니다.
 *
 * 제한 사항
 * numbers의 길이는 2 이상 17 이하입니다.
 * numbers에 들어있는 모든 수는 -100,000,000 이상 100,000,000 이하입니다.
 * 입출력 예
 * numbers	result
 * [1, 2, 3, 5]	1
 * [-1, -2, 1, 2]	0
 * [-50, 50]	100
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * [1, 2, 3, 5]를 두 그룹 [1, 2, 3]과 [5]로 나누면 두 그룹의 합은 각각 6과 5가 되고, 이 때의 두 합의 차이는 1로 최솟값이 됩니다.
 * 두 합의 차이를 1로 만드는 또 다른 방법은 [1, 5]와 [2, 3]으로 나누는 방법이 있습니다.
 * 입출력 예 #2
 *
 * [-1, -2, 1, 2]을 두 그룹 [-1, 1]과 [-2, 2]로 나누면 두 그룹의 합은 0으로 같습니다.
 * 입출력 예 #3
 *
 * [-50, 50]을 두 그룹으로 나누는 경우는 [-50]과 [50]으로 나누는 경우 단 1가지입니다. 이때 두 그룹의 합의 차이는 100입니다.
 */
public class Question07 {
    public static void main(String[] args) {
        Question07 alg = new Question07();

//        int[] test1 = new int[] {1, 2, 3, 5};
//        System.out.println(alg.solution(test1));
//
//        int[] test2 = new int[] {-1, -2, 1, 2};
//        System.out.println(alg.solution(test2));

        int[] test3 = new int[] {-50, 50};
        System.out.println(alg.solution(test3));
    }

    static int min = 999999999;

    public int solution(int[] numbers) {
        boolean[] visited = new boolean[numbers.length];
        powerSet(numbers, visited, numbers.length, 0);

        int answer = min;
        return answer;
    }

    static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
        if (idx == n) {
            checkSumMin(arr, visited, n);
            return;
        }

        visited[idx] = false;
        powerSet(arr, visited, n, idx + 1);

        visited[idx] = true;
        powerSet(arr, visited, n, idx + 1);
    }

    static void checkSumMin(int[] arr, boolean[] visited, int n) {
        int tSum = 0;
        int fSum = 0;
        int tCount = 0;
        int fCount = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                tSum += arr[i];
                tCount++;
            } else {
                fSum += arr[i];
                fCount++;
            }
        }
        if (tCount > 0 && fCount > 0) {
            int substract = Math.abs(tSum-fSum);
            if (min > substract) {
                min = substract;
            }
        }
    }
}
