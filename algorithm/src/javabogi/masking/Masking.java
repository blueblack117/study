package javabogi.masking;

import java.util.regex.Pattern;

/**
 주민번호 마스킹 (15분)
 *
 * 주민등록번호 등을 마스킹하는 함수 만들기
 * 예) 성명:홍아무개님->홍***님
 *     (한글만 허용, 숫자나 영문 입력시 Exception 처리)
 *
 *     주민번호:881110-2345678->881110-2******
 *     (숫자만 허용, 다른 문자 입력시 Exception 처리)
 *
 *     카드번호: 1234-5678-1234-5678->1234-56**-****-****
 *     (숫자만 허용, 다른 문자 입력시 Exception 처리)
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class Masking {

	public boolean matched(String regex, String inputTxt) {
		return Pattern.matches(regex, inputTxt);
	}

	public String maskName(String name) throws Exception {
		String regex = "^[가-힣]*$";
		if (!this.matched(regex, name)) {
			throw new Exception("name exception");
		}

		StringBuilder sb = new StringBuilder();
		int pivot = 1;
		for (int inx=0; inx<name.length(); inx++) {
			if (inx < pivot) {
				sb.append(name.charAt(inx));
			} else {
				sb.append("*");
			}
		}
		return sb.toString();
	}

	public String maskRrn(String rrn) throws Exception {
		String regex = "^[0-9]*$";
		String replaceRrn = rrn.replace("-", "");
		if (!this.matched(regex, replaceRrn)) {
			throw new Exception("rrn exception");
		}

		StringBuilder sb = new StringBuilder();
		int pivot = 8;
		for (int inx=0; inx<rrn.length(); inx++) {
			if (inx < pivot) {
				sb.append(rrn.charAt(inx));
			} else {
				sb.append("*");
			}
		}
		return sb.toString();
	}

	public String maskCardNumber(String cardNumber) throws Exception {
		String regex = "^[0-9]*$";
		String replaceCardNumber = cardNumber.replace("-", "");
		if (!this.matched(regex, replaceCardNumber)) {
			throw new Exception("cardNumber exception");
		}

		StringBuilder sb = new StringBuilder();
		int pivot = 7;
		for (int inx=0; inx<cardNumber.length(); inx++) {
			if (inx < pivot) {
				sb.append(cardNumber.charAt(inx));
			} else {
				if (cardNumber.charAt(inx) == '-') {
					sb.append(cardNumber.charAt(inx));
				} else {
					sb.append("*");
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		Masking masking = new Masking();
		System.out.println(masking.maskName("홍길동"));
		System.out.println(masking.maskRrn("881110-2345678"));
		System.out.println(masking.maskCardNumber("1234-5678-1234-5678"));
	}

}
