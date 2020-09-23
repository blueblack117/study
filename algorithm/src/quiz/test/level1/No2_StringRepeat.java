package quiz.test.level1;

/**
 * 문제 설명
 * 길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
 * 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.
 *
 * 제한 조건
 * n은 길이 10,000이하인 자연수입니다.
 *
 * 입출력 예
 * n	return
 * 3	수박수
 * 4	수박수박
 */
public class No2_StringRepeat {

    public static void main(String[] args) {
        No2_StringRepeat alg = new No2_StringRepeat();
        System.out.println(alg.solution(3));
        System.out.println(alg.solution(4));
    }

    // 정확성 50.0 / 50.0
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        int repeat = (int) n/2;
        int remainder = n % 2;
        for (int inx=0; inx<repeat; inx++) {
            sb.append("수").append("박");
        }
        if (remainder != 0) {
            sb.append("수");
        }
        String answer = sb.toString();
        return answer;
    }
}
