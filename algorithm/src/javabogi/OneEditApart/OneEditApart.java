package javabogi.OneEditApart;

/**
 * 아래와 같은 결과를 출력하는 function을 구현하라
 *
 * bool OneEditApart(string s1, string s2)
 *
 * OneEditApart("cat", "dog") = false OneEditApart("cat", "cats") = true
 * OneEditApart("cat", "cut") = true OneEditApart("cat", "cast") = true
 * OneEditApart("cat", "at") = true OneEditApart("cat", "acts") = false
 *
 * 한개의 문자를 삽입, 제거, 변환을 했을때 s1, s2가 동일한지를 판별하는 OneEditApart 함수를 작성하시오.
 *
 * 출처: https://www.careercup.com/question?id=4793416529477632
 *
 * ----------- Pseudocode ----------- 
 * TODO
 *
 */
public class OneEditApart {

	private static boolean test(String str1, String str2) {
		if (str1.length() == str2.length()) {
			if (str1.equals(str2)) {
				return true;
			} else {
				for (int inx=0; inx<str1.length(); inx++) {
					String subString = str1.substring(0, inx) + str1.substring(inx+1, str1.length());
					if (check(subString, str2)) {
						return true;
					}
				}
			}
			return false;
		} else if (Math.abs(str1.length() - str2.length()) > 1) {
			return false;
		} else {
			String shortString = (str1.length() > str2.length()) ? str2 : str1;
			String longString = (str1.length() > str2.length()) ? str1 : str2;
			return check(shortString, longString);
		}
	}

	public static boolean check(String shortString, String longString) {
		for (int inx=0; inx<longString.length(); inx++) {
			String subString = longString.substring(0, inx) + longString.substring(inx+1, longString.length());
			if (shortString.equals(subString)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(OneEditApart.test("cat", "dog")); // false
		System.out.println(OneEditApart.test("cat", "cats")); // true
		System.out.println(OneEditApart.test("cat", "cut")); // true
		System.out.println(OneEditApart.test("cat", "cast")); // true
		System.out.println(OneEditApart.test("cat", "at")); // true
		System.out.println(OneEditApart.test("cat", "acts")); // false
	}

}
