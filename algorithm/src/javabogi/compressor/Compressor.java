package javabogi.compressor;

/**
 * Compressor (15분)
 *
 * 같은 문자열이 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하세요.
 *
 * 예) abc -> abc
 *     aaAaBbBBcDdddaaA -> a4b4c1d4a3
 *
 * 단, 압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우엔
 * 원래 문자열을 소문자로 치환해서 출력한다.
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class Compressor {

	public String compress(String str) {
		StringBuilder sb = new StringBuilder();
		str = str.toLowerCase();
		char exChar = str.charAt(0);
		int count = 1;
		for (int inx=1; inx<str.length(); inx++) {
			char ch = str.charAt(inx);
			if (exChar == ch) {
				count++;
			} else {
				sb.append(exChar).append(count);
				exChar = ch;
				count = 1;
			}
		}

		sb.append(exChar).append(count);
		String result = sb.toString();
		if (result.length() > str.length()) {
			return str;
		}
		return result;
	}

	public static void main(String[] args) {
		Compressor compressor = new Compressor();
		System.out.println(compressor.compress("abc"));
		System.out.println(compressor.compress("aaAaBbBBcDdddaaA"));
		System.out.println(compressor.compress("aaAaBbBBcDdddaaAb"));
	}
}
