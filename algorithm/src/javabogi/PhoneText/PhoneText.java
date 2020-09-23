package javabogi.PhoneText;

/**
 * PhoneText (20분)
 *
 * 휴대폰에 자판이 다음과 같이 배치되어 있습니다.
 *
 *   1(ABC)  2(DEF)  3(GHI)
 *   4(JKL)  5(MNO)  6(PQR)
 *   7(ST)   8(UV)   9(WX)
 *   *       0(YZ)   #
 *
 * 1을 출력하려면 1
 * A를 출력하려면 11
 * B를 출력하려면 111
 * C를 출력하려면 1111 와 같이 입력하면 됩니다.
 *
 * 소문자를 입력하려면 *을 입력하면 됩니다.
 * a를 출력하려면 *11
 *
 * 중복된 숫자를 누를 때는 중간에 #을 입력합니다.
 * 1a를 출력하려면 1#*11
 *
 * 임의의 주어진 문자열을 입력하기 위해 눌러야 하는 문자열을 구현하세요.
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class PhoneText {

	private String getTextPlan(String text) {
		//TODO

		return null;
	}

	public static void main(String[] args) {
		PhoneText phone = new PhoneText();
		System.out.println(phone.getTextPlan("Goo0d"));	//33*5555#*55550*22
	}

}
