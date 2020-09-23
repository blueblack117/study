package javabogi.masking;

import java.util.regex.Pattern;

public class Masking4 {
	public boolean matched(String regex, String inputTxt) {
		return Pattern.matches(regex, inputTxt);
	}

	public String mask(String org, int pivot) {
		StringBuilder sb = new StringBuilder();
		for (int inx=0; inx<org.length(); inx++) {
			if (inx < pivot) {
				sb.append(org.charAt(inx));
			} else {
				if (org.charAt(inx) == '-') {
					sb.append(org.charAt(inx));
				} else {
					sb.append("*");
				}
			}
		}
		return sb.toString();
	}

	public String maskName(String name) throws Exception {
		String regex = "^[가-힣]*$";
		if (!this.matched(regex, name)) {
			throw new Exception("name exception");
		}
		return mask(name, 1);
	}

	public String maskRrn(String rrn) throws Exception {
		String regex = "^[0-9]{6}-[1-4][0-9]{6}$";
		if (!this.matched(regex, rrn)) {
			throw new Exception("rrn exception");
		}
		return mask(rrn, 8);
	}

	public String maskCardNumber(String cardNumber) throws Exception {
		String regex = "^[0-9\\-]*$";
		if (!this.matched(regex, cardNumber)) {
			throw new Exception("cardNumber exception");
		}
		return mask(cardNumber, 7);
	}

	public static void main(String[] args) throws Exception {
		Masking4 masking = new Masking4();
		System.out.println(masking.maskName("홍길동"));
		System.out.println(masking.maskRrn("881110-2345678"));
		System.out.println(masking.maskCardNumber("1234-5678-1234-5678"));
	}
}
