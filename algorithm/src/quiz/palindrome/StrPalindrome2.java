package quiz.palindrome;

/**
 * 앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
 * 문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.
 *
 * 예를들면, 문자열 s가 “abcdcba”이면 7을 return하고 “abacde”이면 3을 return합니다.
 *
 * 제한사항
 * •문자열 s의 길이 : 2,500 이하의 자연수
 * •문자열 s는 알파벳 소문자로만 구성
 *
 *
 *
 * 입출력 예 설명
 *
 * 입출력 예 #1
 *  4번째자리 'd'를 기준으로 문자열 s 전체가 팰린드롬이 되므로 7을 return합니다.
 *
 * 입출력 예 #2
 *  2번째자리 'b'를 기준으로 “aba”가 팰린드롬이 되므로 3을 return합니다.
 *
 *  //https://www.crocus.co.kr/1001
 */
public class StrPalindrome2 {

    //정확성: 18.8
    //효율성: 4.6
    //합계: 23.4 / 30.0
    public int solution(String input)
    {
        String reverse = "";

        for(int i= input.length()-1; i >= 0; i--){
            reverse += input.charAt(i);
        }

        System.out.println(input);
        System.out.println(reverse);
        System.out.println("======================");

//    가장긴 리버스가 같은 문자열 고르기
        int max = 1;
        for(int i = input.length(); i > 1 ; i--){
            for(int j = 0; j <= input.length() - i; j++){
                if(reverse.contains(input.substring( j, i+j))){
                    max = i;
                    return max;
                }
            }
        }
        return max;
    }

    // 정확성: 20.8
    //효율성: 0.0
    //합계: 20.8 / 30.0
    public int solution2(String s)
    {
        int answer = 0;
        for (int i=0; i<=s.length(); i++) {
            for (int j=i+1; j<=s.length(); j++) {
                String subStr = s.substring(i, j);
                String reverse = new StringBuffer(subStr).reverse().toString();
                if (subStr.equals(reverse) && subStr.length() > answer) {
                    answer = subStr.length();
                }
            }
        }

        return answer;
    }

    // 정확성: 20.8
    //효율성: 9.2
    //합계: 30.0 / 30.0
    // https://gist.github.com/silleruss
    public int solution3(String str)
    {
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int answer = 1;

        int start = 0;
        int len = str.length();

        int low, high;

        for(int i = 1; i < len; ++i) {
            low = i - 1;
            high = i;
            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > answer) {
                    start = low;
                    answer = high - low + 1;
                }
                --low;
                ++high;
            }

            low = i - 1;
            high = i + 1;
            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > answer) {
                    start = low;
                    answer = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StrPalindrome2 alg = new StrPalindrome2();
        System.out.println(alg.solution("abcdcba"));
        System.out.println(alg.solution("abacde"));

        System.out.println(alg.solution2("abcdcba"));
        System.out.println(alg.solution2("abacde"));
    }
}
