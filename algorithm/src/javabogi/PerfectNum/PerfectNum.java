package javabogi.PerfectNum;

/**
 * PerfectNum (15분)
 *
 * 약수는 어떤 수를 나누어 떨어지게 하는 수이다.
 * 자기 자신을 제외한 모든 양의 약수들의 합이 자기 자신이 되는 자연수를 완전수라고 한다.
 * 예를 들면, 6과 28은 완전수이다.
 * 6=1+2+3 // 1,2,3은 각각 6의 약수
 * 28=1+2+4+7+14 // 1,2,4,7,14는 각각 28의 약수
 *
 * 자연수를 10000을 입력 받고, 출력으로 10000 이하의 모든 완전수를 출력하는 코드를 작성하라.
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class PerfectNum {

	private void getPerfectNum(int inx) {
		// TODO

	}

	void result(int num) {
		for (int inx = num; inx >= 2; inx--) {
			getPerfectNum(inx);
		}
	}

	public static void main(String[] args) {

		PerfectNum perfectNum = new PerfectNum();
		perfectNum.result(10000);
	}

}
