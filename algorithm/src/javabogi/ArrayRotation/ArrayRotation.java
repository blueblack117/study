package javabogi.ArrayRotation;

/**
 * ArrayRotation(20분)
 *
 * 다음과 같은 배열이 있을 경우 이것을 시계 방향으로 90도 회전시킨 값을 구하고, 원 배열과 회전된 배열을 합하여 출력하세요.
 * 예)
 *
 * 1 2 3                     7 4 1                          8 6 4
 * 4 5 6  -> (90도 회전) ->  8 5 2  -> (원 배열과의 합) ->  12 10 8
 * 7 8 9                     9 6 3                          16 14 12
 *
 * ----------- Pseudocode -----------
 * TODO
 *
 */
public class ArrayRotation {

	public void rotateAndSum(int[][] input) {
		print(input);

		int[][] rotArray = new int[input.length][input[0].length];
		rotate(input, rotArray);
		print(rotArray);

		int[][] sumArray = new int[input.length][input[0].length];
		sum(input, rotArray, sumArray);

		print(sumArray);
	}

	public void rotate(int[][] input, int[][] rotArray) {
		int length = input.length - 1;
		for (int inx=0; inx<input.length; inx++) {
			for (int jnx=0; jnx<input[inx].length; jnx++) {
				rotArray[jnx][length - inx] = input[inx][jnx];
			}
		}
	}

	public void sum(int[][] input, int[][] rotArray, int[][] sumArray) {
		for (int inx=0; inx<sumArray.length; inx++) {
			for (int jnx=0; jnx<sumArray[inx].length; jnx++) {
				sumArray[inx][jnx] = input[inx][jnx] + rotArray[inx][jnx];
			}
		}
	}

	public void print(int[][] sumArray) {
		for (int inx=0; inx<sumArray.length; inx++) {
			for (int jnx=0; jnx<sumArray[inx].length; jnx++) {
				System.out.print(sumArray[inx][jnx] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[][] array = {{1,2,3},
				{4,5,6},
				{7,8,9}};

		ArrayRotation arrayRotation = new ArrayRotation();
		arrayRotation.rotateAndSum(array);
	}

}
