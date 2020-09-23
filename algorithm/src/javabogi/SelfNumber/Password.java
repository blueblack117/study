package javabogi.SelfNumber;

/**
 * Password(15분)
 *
 * password 문자열을 입력받아 아래의 조건을 검사하는 문제
 * 숫자/영문/특수로 구성 될 수 있음
 * 특수문자는 사용가능한 문자가 제한되어 제공
 * (제공된 특수문자는 정확하게 무엇이 있었는지 기억이 나지 않습니다...)
 *
 * 숫자/영문/특수 조합이 2가지면 10자 이상
 * 숫자/영문/특수 조합이 3가지면 8자 이상
 * 영문은 대소문자를 구분 a != A
 * 같은글자 반복되면 안됨(추가점)
 *
 * abcde1234 -> 2가지 조합에 9글자 이므로 false
 * abcde12345 -> 2가지 조합에 10글자 이므로 true
 * !abc1234 -> 3가지 조합에 8글자 이므로 true
 * aacde12345 -> a가 반복되므로 false
 * aAcde12345 -> true
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class Password {
	private static char[] SPECIAL_CHARACTER = {'~', '!', '@', '#', '$', '%', '^', '&', '*', '-', '+', '(', ')'};

	private static boolean isValid(String str) {
		String regexDigit = "^[0-9]*$";
		String regexChar = "^[A-Za-z]*$";
		String regexDigitNChar = "^[0-9A-Za-z]*$";

		boolean isIncludeSpec = false;
		char exCh = '_';
		for (int inx=0; inx<str.length(); inx++) {
			char ch = str.charAt(inx);
			if (exCh == ch) {
				return false;
			}
			exCh = ch;
		}

		String tempStr = new String(str);
		for (int jnx=0; jnx<SPECIAL_CHARACTER.length; jnx++) {
			String ch = "" + SPECIAL_CHARACTER[jnx];
			if (tempStr.contains(ch)) {
				tempStr = tempStr.replace(ch, "");
				isIncludeSpec = true;
			}
		}

		int typeCount = 0;
		if (isIncludeSpec) {
			typeCount++;
		}

		if (tempStr.matches(regexDigitNChar)) {
			typeCount += 2;
		} else if (tempStr.matches(regexDigit)) {
			typeCount += 1;
		} else if (tempStr.matches(regexChar)) {
			typeCount += 1;
		}

		if (typeCount == 3) {
			if (str.length() >= 8) {
				return true;
			}
		} else if (typeCount == 2) {
			if (str.length() >= 10) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isValid("abcde"));	//false
		System.out.println(isValid("1234"));	//false
		System.out.println(isValid("abcde1234"));	//false
		System.out.println(isValid("abcde12345"));	//true
		System.out.println(isValid("!abc1234"));	//true
		System.out.println(isValid("aacde12345"));	//false		

	}

}

