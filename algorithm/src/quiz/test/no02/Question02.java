package quiz.test.no02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 정수들로 이루어진 배열 a가 있습니다. 당신은 a를 다음과 같은 과정을 통해 재배열하려고 합니다.
 *
 * a에 있는 홀수들을 모두 뽑은 뒤, 그 홀수들을 오름차순으로 정렬합니다.
 * a에 있는 짝수들을 모두 뽑은 뒤, 그 짝수들을 오름차순으로 정렬합니다.
 * 정렬된 홀수들과 정렬된 짝수들을 그대로 이어붙입니다. 이때, 어느 한 쪽이 빈 배열일수도 있습니다.
 * 정수 배열 a가 매개변수로 주어집니다. 위 과정을 거쳐 a를 재배열한 결과를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * a의 길이는 1 이상 100,000 이하입니다.
 * a에 들어있는 숫자는 1 이상 1,000,000,000 이하입니다.
 *
 *
 * 입출력 예
 * a	result
 * [1,4,9,7,2]	[1,7,9,2,4]
 * [7,33,11,29]	[7,11,29,33]
 * [6,2,30,18,22,40]	[2,6,18,22,30,40]
 *
 * 입출력 예 설명
 *
 * 입출력 예 #1
 *
 * a에서 홀수만 뽑아 오름차순으로 정렬한 배열은 [1,7,9] 입니다.
 * a에서 짝수만 뽑아 오름차순으로 정렬한 배열은 [2,4] 입니다.
 * 이 둘을 이어붙이면 [1,7,9,2,4] 가 됩니다.
 *
 * 입출력 예 #2
 *
 * a에서 홀수만 뽑아 오름차순으로 정렬한 배열은 [7,11,29,33] 입니다.
 * a에는 짝수가 없으므로, a에서 짝수만 뽑아 오름차순으로 정렬한 배열은 빈 배열입니다.
 * 이 둘을 이어붙이면 [7,11,29,33] 입니다.
 *
 * 입출력 예 #3
 *
 * a에는 홀수가 없으므로, a에서 홀수만 뽑아 오름차순으로 정렬한 배열은 빈 배열입니다.
 * a에서 짝수만 뽑아 오름차순으로 정렬한 배열은 [2,6,18,22,30,40] 입니다.
 * 이 둘을 이어붙이면 [2,6,18,22,30,40] 입니다.
 */
public class Question02 {

    public static void main(String[] args) {
        Question02 alg = new Question02();

        int[] test1 = new int[] {1,4,9,7,2};
        System.out.println(Arrays.toString(alg.solution(test1)));

        int[] test2 = new int[] {7,33,11,29};
        System.out.println(Arrays.toString(alg.solution(test2)));

        int[] test3 = new int[] {6,2,30,18,22,40};
        System.out.println(Arrays.toString(alg.solution(test3)));
    }

    public int[] solution(int[] a) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        // divide
        for (int inx=0; inx<a.length; inx++) {
            if ((a[inx]%2) == 0) {
                even.add(a[inx]);
            } else {
                odd.add(a[inx]);
            }
        }

        // sort
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even, Collections.reverseOrder());

        // merge
        odd.addAll(even);

        int[] answer = new int[odd.size()];
        for (int inx=0; inx<odd.size(); inx++) {
            answer[inx] = odd.get(inx);
        }
        return answer;
    }
}
