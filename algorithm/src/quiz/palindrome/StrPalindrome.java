package quiz.palindrome;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

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
 */
public class StrPalindrome {

    //정확성: 20.8
    //효율성: 0.0
    //합계: 20.8 / 30.0
    public int solution(String s)
    {
        int answer = 0;

        String[] stringSet = doSubset(s);
        for (int inx=0; inx<stringSet.length; inx++) {
//            System.out.println(stringSet[inx]);
            if (checkPalindrome(stringSet[inx])) {
                return stringSet[inx].length();
            }
        }
        return answer;
    }

    public String[] doSubset(String text){
        Set stringSet = new HashSet<>();
        int count = 0;
        while(count<text.length()){
            for (int i = 0; i < text.length(); i++) {
                split(count, text, i, stringSet);
            }
            count++;
        }

        String[] arrSet = new String[stringSet.size()];
        stringSet.toArray(arrSet);
        Arrays.sort(arrSet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                }
                return 0;
            }
        });
        return arrSet;
    }

    public void split(int count, String text, int index, Set stringSet){
        String temp = "";
        for (int i = index; i <= count; i++) {
            temp+=text.charAt(i);
        }
        stringSet.add(temp);
    }


    public boolean checkPalindrome(String str) {
        boolean result = true;

        if (str.length() == 1) {
            return true;
        }
        for (int inx=0; inx<(str.length()/2); inx++) {
            if (str.charAt(inx) == str.charAt((str.length()-1)-inx)) {
                continue;
            } else {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        StrPalindrome alg = new StrPalindrome();
        System.out.println(alg.solution("abcdcba"));
        System.out.println(alg.solution("abacde"));
    }
}
