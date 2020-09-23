package javabogi.PascalTriangle;

/**
 * PascalTriangle (20분)
 *
 * 입력 받은 row수 만큼 파스칼의 삼각형을 출력하세요. (2차원 배열을 이용하세요)
 * 예) 입력:7
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 * 1 6 15 20 15 6 1
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class PascalTriangle {

	public String get(int row) {
		int[][] pascalTriangle = new int[row][row];

		for (int inx=0; inx<row; inx++) {
			for (int jnx=0; jnx<=inx; jnx++) {
				if (jnx == 0) {
					pascalTriangle[inx][jnx] = 1;
				} else if (jnx < inx) {
					pascalTriangle[inx][jnx] = pascalTriangle[inx-1][jnx-1] + pascalTriangle[inx-1][jnx];
				} else {
					pascalTriangle[inx][jnx] = 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int inx=0; inx<row; inx++) {
			for (int jnx=0; jnx<=inx; jnx++) {
				sb.append(pascalTriangle[inx][jnx]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		System.out.println(pascalTriangle.get(7));
	}

}
