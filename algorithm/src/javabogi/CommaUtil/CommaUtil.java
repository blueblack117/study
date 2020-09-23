package javabogi.CommaUtil;

/**
 * 숫자 형태의 문자열을 콤마가 포함된 금액 표기식 문자열로 바꾸어주는 프로그램을 작성하시오.
 *
 * 1000	-> 1,000
 * 20000000	-> 20,000,000
 * -3245.24	-> -3,245.24
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class CommaUtil {

	public String change(String num) {
		String retString = null;
		try {
			// check number
			Double.parseDouble(num);

			int pos = (num.indexOf(".") < 0) ? num.length() : num.indexOf(".");
			int repCount = (num.length() <= 3) ? 0 : (int)pos/3;
			String adjNum = num.substring(0, pos);
			if (repCount > 0) {
				StringBuffer sb = new StringBuffer();
				sb.append(adjNum);
				adjNum = sb.reverse().toString();
				sb.setLength(0);
				String unit = null;
				for (int inx = 0; inx<repCount; inx++) {
					unit = adjNum.substring((inx*3),(inx*3)+3);
					sb.append(unit).append(",");
				}
				unit = adjNum.substring(((repCount-1)*3)+3,adjNum.length());
				sb.append(unit);
				retString = sb.reverse().toString();
			} else {
				retString = adjNum;
			}

			if (pos != num.length()) {
				retString = retString + num.substring(pos, num.length());
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid Number Format..." + num);
		}
		return retString;
	}

	public static void main(String[] args) {
		System.out.println(new CommaUtil().change("1000"));
		System.out.println(new CommaUtil().change("20000000"));
		System.out.println(new CommaUtil().change("-3245.24"));
		System.out.println(new CommaUtil().change("123"));
		System.out.println(new CommaUtil().change("12"));
	}
}
