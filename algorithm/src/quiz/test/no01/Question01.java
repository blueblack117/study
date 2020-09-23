package quiz.test.no01;

import java.util.Arrays;

/**
 * 여러 개의 나무가 x축 위에 심어져 있습니다.
 * 나무의 훼손과 산불 방지를 위해, 가운데 심어진 나무에 감시 카메라를 부착하려고 합니다.
 *
 * 가운데 심어진 나무란, 좌.우 양 끝에 심어진 두 나무의 중간지점에서 가장 가까운 나무를 의미합니다.
 *
 * 만약 심어진 나무가 1개밖에 없다면, 그 나무가 가운데 심어진 나무가 됩니다.
 * 만약 중간지점에 가장 가까운 나무가 여러 개라면, 그중 x좌표가 가장 작은 나무가 가운데 심어진 나무라고 가정합니다.
 * 나무들이 심어진 x좌표가 담긴 배열 numbers가 주어집니다. 가운데 심어진 나무의 x좌표를 찾아 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * numbers는 길이 1 이상 100,000 이하인 정수 배열입니다.
 * numbers의 모든 원소는 -100,000,000 이상 100,000,000 이하인 정수입니다.
 * numbers의 모든 원소는 서로 다른 수입니다. 즉, 모든 나무는 서로 다른 위치에 심어져 있습니다.
 * 입출력 예
 * numbers	result
 * [9,2,-1,6,3]	3
 * [-1,-3,6,1,2,4]	1
 * [0]	0
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 가장 왼쪽에 심어진 나무의 좌표는 -1, 가장 오른쪽에 심어진 나무의 좌표는 9이므로, 이 두 나무들의 중간지점은 4입니다.
 * 따라서 중간지점에 가장 가까운 나무의 좌표인 3을 return 해야 합니다.
 * 입출력 예 #2
 *
 * 가장 왼쪽에 심어진 나무의 좌표는 -3, 가장 오른쪽에 심어진 나무의 좌표는 6이므로, 이 두 나무들의 중간지점은 1.5입니다.
 * 중간지점에 가장 가까운 나무들은 2개로, 좌표는 각각 1과 2입니다. 이들 중 가장 왼쪽에 심어진 나무의 좌표인 1을 return 해야 합니다.
 * 입출력 예 #3
 *
 * 이 예시에서는 나무가 하나만 심어져 있으므로, 그 나무의 좌표인 0을 return 해야 합니다.
 */
public class Question01 {

    public static void main(String[] args) {
        Question01 alg = new Question01();

        int[] test1 = new int[] {9,2,-1,6,3};
        System.out.println(alg.solution(test1));

        int[] test2 = new int[] {-1,-3,6,1,2,4};
        System.out.println(alg.solution(test2));

        int[] test3 = new int[] {0};
        System.out.println(alg.solution(test3));

        int[] test4 = new int[] {1,2,-1,19,3};
        System.out.println(alg.solution(test4));

        int[] test5 = new int[] {1,2,3,4,5,6,7,8,9,1000};
        System.out.println(alg.solution(test5));

        int[] test6 = new int[] {0,-1,-2,-3,-4,-5,-6,-7,-8,-9,1000};
        System.out.println(alg.solution(test6));

        int[] test7 = new int[] {0,-500,-2,-3,-4,-5,-6,-7,-8,900,1000};
        System.out.println(alg.solution(test7));
    }

    public int solution(int[] numbers) {
        int answer = 123456789;

        Arrays.sort(numbers);
        double avg = (numbers[0] + numbers[numbers.length-1]) / 2.0;

        int index = binarySearch(numbers, avg);
        if (index < 0) {
            answer = numbers[-(index)];
        } else {
            answer = numbers[index];
        }
        return answer;
    }

    private int binarySearch(int[] a, double key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if ((double)midVal < key)
                low = mid + 1;
            else if ((double)midVal > key)
                high = mid - 1;
            else {
                return mid; // key found
            }
        }
        // key not found.
        if (Math.abs(key - (double)a[low]) < Math.abs(key - (double)a[high])) {
            return -low;
        } else if (Math.abs(key - (double)a[low]) > Math.abs(key - (double)a[high])) {
            return -high;
        }
        return (low > high) ? -(high) : -(low);
    }

    /**
     * 정확성: 40.0
     * 효율성: 0.0
     * 합계: 40.0 / 100.0
     */
    public int solution3(int[] numbers) {
        int answer = 123456789;

        Arrays.sort(numbers);
        int avg = (numbers[0] + numbers[numbers.length-1]) / 2;

        int index = Arrays.binarySearch(numbers, avg);
        if (index < 0) {
            answer = numbers[(-(index)) -1  -1];
        } else {
            answer = numbers[index];
        }
        return answer;
    }

    /**
     * 정확성: 40.0
     * 효율성: 0.0
     * 합계: 40.0 / 100.0
     */
    public int solution2(int[] numbers) {
        Arrays.sort(numbers);
        int avg = (numbers[0] + numbers[numbers.length-1]) / 2;

        int answer = -9999;
        for (int inx=0; inx<numbers.length; inx++) {
            if (numbers[inx] > answer && numbers[inx] <= avg) {
                answer = numbers[inx];
            } else if (numbers[inx] > avg) {
                break;
            }
        }
        return answer;
    }
}
