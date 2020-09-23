package quiz.mathematical.sequence.permutations;

import java.util.ArrayList;

/**
 * 문자열의 모든 순열을 찾는 메서드를 작성하라.
 *
 * 예) a1a2a3 → a1a2a3, a1a3a2, a1a2a3, a3a2a1, a2a3a1, a2a1a3
 */
public class PermutationChar {
    public static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;
        }

        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // 초기 사례
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // 첫 문자열을 가져옴
        String remainder = str.substring(1); // 첫 문자 제거
        ArrayList<String> words = getPerms(remainder); //이전 문자열의 결과를 가져옴
        for (String word : words) { // 곳곳에 첫 문자열을 삽입
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }

        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abcde");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
