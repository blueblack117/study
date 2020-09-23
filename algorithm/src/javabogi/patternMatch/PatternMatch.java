package javabogi.patternMatch;

/**
 * 패턴 찾기 (15분)
 *
 * 14. 패턴찾기
 * 주어진 문자열(LGOLOLOLGOLOL) 에서 정의된(GOL, LOL) 문자열이 몇 개 있는지 확인하는 함수를 구현.
 * 예) GOL 2개 LOL 3개 총 5개 - 겹쳐진 것도 체크해야 함
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class PatternMatch {

	public static void main(String[] args) {
		String inputStr = "LGOLOLOLGOLOL";

		PatternMatch macher = new PatternMatch();
		int count = macher.getCountRepeat(inputStr, "GOL");
		count += macher.getCountRepeat(inputStr, "LOL");

		System.out.println("count = " + count);
	}

	public int getCountRepeat(String sentance, String pkg) {
		int count = 0;
		boolean isSearch = true;
		while (sentance.length() > 1 && isSearch) {
			int index = sentance.indexOf(pkg);
			if (index > -1) {
				sentance = sentance.substring(index+1);
				count++;
			} else {
				isSearch = false;
			}
		}
		return count;
	}
}
