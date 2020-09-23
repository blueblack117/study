package quiz.test.no02;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 설명
 * 0과 1로 이루어진 문자열에 대한 다음과 같은 변환 연산을 정의합니다.
 *
 * 해당 문자열 내에서 연속해서 같은 글자가 나타나는 개수를 모든 구간에 대해 셉니다. 이 수들을 '연속한 글자 구간의 크기들'이라고 합니다.
 * 연속한 글자 구간의 크기들을 2진법으로 변환한 뒤, 그것들을 문자열 형태로 이어붙입니다.
 * 예를 들어, 문자열 11000101111에 변환 연산을 적용하는 과정은 아래와 같습니다.
 *
 * 구간의 범위 (인덱스)	해당하는 문자열	길이(10진법)	길이(2진법)
 * 0 ~ 1	11	2	10
 * 2 ~ 4	000	3	11
 * 5 ~ 5	1	1	1
 * 6 ~ 6	0	1	1
 * 7 ~ 10	1111	4	100
 * 10, 11, 1, 1, 100을 그대로 이어붙인 101111100이 원본 문자열 11000101111에 대한 변환 연산 결과입니다.
 *
 * 0과 1로 이루어진 문자열 line과, 정수 k가 매개변수로 주어집니다. line에 이 변환 연산을 k번 연속해서 적용한 결과를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * line은 길이 1 이상 100,000 이하인 문자열입니다.
 * line은 0 또는 1로만 이루어져 있습니다.
 * k는 1 이상 10 이하인 정수입니다.
 * 입출력 예
 * line	k	result
 * "11000101111"	1	"101111100"
 * "1010101010"	2	"1010"
 * "01"	3	"11"
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제 예시와 같습니다.
 * 입출력 예 #2
 *
 * 이 예시에서 line의 변환 과정은 1010101010 → 1111111111 → 1010 입니다.
 * 다음은 첫 번째 변환 과정을 표로 나타낸 것입니다.
 * 구간의 범위 (인덱스)	해당하는 문자열	길이(10진법)	길이(2진법)
 * 0 ~ 0	1	1	1
 * 1 ~ 1	0	1	1
 * 2 ~ 2	1	1	1
 * 3 ~ 3	0	1	1
 * 4 ~ 4	1	1	1
 * 5 ~ 5	0	1	1
 * 6 ~ 6	1	1	1
 * 7 ~ 7	0	1	1
 * 8 ~ 8	1	1	1
 * 9 ~ 9	0	1	1
 * 따라서, 1111111111은 1010101010에 대한 변환 연산의 결과입니다.
 * 다음은 두 번째 변환 과정을 표로 나타낸 것입니다.
 * 구간의 범위 (인덱스)	해당하는 문자열	길이(10진법)	길이(2진법)
 * 0 ~ 9	1111111111	10	1010
 * 따라서, 1010은 1111111111에 대한 변환 연산의 결과이고, 1010을 return 해주어야 합니다.
 * 입출력 예 #3
 *
 * 이 예시에서 line의 변환 과정은 01 → 11 → 10 → 11 입니다.
 *
 */
public class Question03 {

    public static void main(String[] args) {
        Question03 alg = new Question03();

        System.out.println(alg.solution("11000101111", 1));
        System.out.println(alg.solution("1010101010", 2));
        System.out.println(alg.solution("01", 3));
    }

    public String solution(String line, int k) {
        String answer = line;
        for (int inx=0; inx<k; inx++) {
            answer = solution(answer);
        }
        return answer;
    }

    public String solution(String line) {
        List<Integer> transList = new ArrayList<>();
        char ch = line.charAt(0);
        int count = 1;
        for (int inx=1; inx<line.length(); inx++) {
            if (ch == line.charAt(inx)) {
                count++;
            } else {
                transList.add(count);
                ch = line.charAt(inx);
                count = 1;
            }
        }
        transList.add(count);

        StringBuffer sb = new StringBuffer();
        for (Integer trans : transList) {
            sb.append(Integer.toBinaryString(trans));
        }
        String answer = sb.toString();
        return answer;
    }
}
