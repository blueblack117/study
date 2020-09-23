package javabogi.VersionCheck;

/**
 * A씨는 두 개의 버전을 비교하는 프로그램을 작성해야 한다.
 *
 * 버전은 다음처럼 "." 으로 구분된 문자열이다.
 *
 * 버전 예) 1.0.0, 1.0.23, 1.1
 *
 * 두 개의 버전을 비교하는 프로그램을 작성하시오.
 * 앞 버전이 크면 음수, 같으면 0, 뒤 버전이 크면 양수를 리턴한다.
 *
 * 다음은 버전 비교의 예이다.
 *
 * 0.0.2 > 0.0.1
 * 1.0.10 > 1.0.3
 * 1.1.99 < 1.2.0
 * 1.0.1 < 1.1
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class VersionCheck {

	public int compare(String version1, String version2) {
		String[] arrVersion1 = version1.split("\\.");
		String[] arrVersion2 = version2.split("\\.");

		int ret = 0;
		int length = arrVersion1.length & arrVersion2.length;
		for (int inx=0; inx<length; inx++) {
			if (Integer.parseInt(arrVersion1[inx]) > Integer.parseInt(arrVersion2[inx])) {
				ret = -1;
				break;
			} else if (Integer.parseInt(arrVersion1[inx]) < Integer.parseInt(arrVersion2[inx])) {
				ret = 1;
				break;
			} else {
				// na
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new VersionCheck().compare("0.0.2", "0.0.1")); //negative
		System.out.println(new VersionCheck().compare("1.0.10", "1.0.3")); //negative
		System.out.println(new VersionCheck().compare("1.1.99", "1.2.0")); //positive
		System.out.println(new VersionCheck().compare("1.1", "1.0.1")); //negative
		System.out.println(new VersionCheck().compare("1.0.1", "1.1")); //positive
		System.out.println(new VersionCheck().compare("1.0.1", "1.0.1")); //positive
	}
}
