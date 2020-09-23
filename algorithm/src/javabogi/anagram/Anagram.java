package javabogi.anagram;

/**
 * Anagram(아나그램)만들기 (10분)
 *
 * 어떠한 단어의 문자를 재배열하여 다른 뜻을 가지는 다른 단어로 바꾸는 것을 아나그램이라 합니다.
 * 문자 두개가 주어졌을 때, 아나그램 여부를 리턴하는 함수를 작성하세요.
 *
 * 예) "dirty room", "dormitory" = true
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class Anagram {
	public boolean isAnagram(String[] words) {
		String strWord1 = getSortedString(words[0].trim().replace(" ", ""));
		String strWord2 = getSortedString(words[1].trim().replace(" ", ""));
		
		if (strWord1.equals(strWord2)) {
			return true;
		}		
		return false;
	}
	
	private String getSortedString(String original) {
		String result = null;
		char[] word = original.toCharArray();
		
		for (int inx=0; inx<word.length-1; inx++) {			
			for (int jnx=inx+1; jnx<word.length; jnx++) {
				if (word[inx] > word[jnx]) {
					char temp = word[inx];
					word[inx] = word[jnx];
					word[jnx] = temp;
				}
			}
		}
		result = String.copyValueOf(word);
		return result;
	}
	
	public static void main(String[] args) {
		String[] words = {"dirty room", "dormitory"};
		
		Anagram anagram = new Anagram();
		System.out.println(anagram.isAnagram(words));
	}
}
