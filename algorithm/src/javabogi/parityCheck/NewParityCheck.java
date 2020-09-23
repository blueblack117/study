package javabogi.parityCheck;

/**
 * Parity Check(패리티 체크) (20분)
 *
 * 1 또는 0 만 들어있는 4x4 int 2차 배열에서 각 행과 열에 1의 개수가 0이거나 짝수이면 패리티체크를 통과했다고 합니다.
 *
 * 2차배열을 파라미터로 받아서 패리티 체크를 한뒤 패리티체크를 통과할 수 있는지 하나만 수정해서 패리티체크를 통과할 수 있다면 어떤 행과
 * 어떤 열을 수정해야하는지 하나만 수정해서는 통과할 수 없는지를 판별하는 함수를 구현.
 *
 * 패리티체크 성공/실패 판별(기본점수) 한개만 수정해서 체크성공할때 해당 위치 판멸(추가점수)
 *
 * 예)
 * 1 0 1 0
 * 0 1 1 0
 * 1 0 1 0
 * 0 1 1 0
 * OK!
 *
 * 1 0 1 0
 * 0 1 1 0
 * 1 1 1 0
 * 0 1 1 0
 * change(3,2)
 *
 * 1 0 1 0
 * 0 1 1 0
 * 1 1 1 1
 * 0 1 1 0
 * NO!
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class NewParityCheck {

	private String checkParity(int[][] array) {
		String result = null;
		int length = array.length;
		int countCol = -1;
		int countRow = -1;
		for (int inx = 0; inx < length; inx++) {
			int sumRow = 0;
			int sumCol = 0;
			for (int jnx = 0; jnx < length; jnx++) {
				sumRow += array[inx][jnx];
				sumCol += array[jnx][inx];
			}
			if ((sumRow % 2) != 0) {
				if (countRow == -1) {
					countRow = inx;
				} else {
					return "NO!";
				}
			}
			if ((sumCol % 2) != 0) {
				if (countCol == -1) {
					countCol = inx;
				} else {
					return "NO!";
				}
			}
		}

		if (countRow == -1 && countCol == -1) {
			result = "OK!";
		} else {
			result = "change(" + (countRow + 1) + "," + (countCol + 1) + ")";
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 0, 1, 0 },
				{ 0, 1, 1, 0 },
				{ 1, 0, 1, 0 },
				{ 0, 1, 1, 0 } };

		int[][] array2 = { { 1, 0, 1, 0 },
				{ 0, 1, 1, 0 },
				{ 1, 1, 1, 0 },
				{ 0, 1, 1, 0 } };

		int[][] array3 = { { 1, 0, 1, 0 },
				{ 0, 1, 1, 0 },
				{ 1, 1, 1, 1 },
				{ 0, 1, 1, 0 } };

		NewParityCheck parityCheck = new NewParityCheck();
		System.out.println(parityCheck.checkParity(array));
		System.out.println(parityCheck.checkParity(array2));
		System.out.println(parityCheck.checkParity(array3));
	}
}
