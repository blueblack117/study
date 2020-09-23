package javabogi.Diagonal;

import java.util.Arrays;

/**
 * NxN 2차원 배열로 주어진 matrix를 나선형(시계방향)으로 돌면서 1차원 배열로 출력 (20분)
 *  입력예시
 1  2  3  4  5
 6  7  8  9  10
 11 12 13 14 15
 16 17 18 19 20
 21 22 23 24 25

 출력예시
 {1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13}

 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class Spiral {

	public static void main(String[] args){
		int[][] matrix = {
				{1,  2,  3,  4,  5 },
				{6,  7,  8,  9,  10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20},
				{21, 22, 23, 24, 25}
		};

		int[] result = makeSpiralLine(matrix);
		System.out.println(Arrays.toString(result));
	}

	public static int[] makeSpiralLine(int[][] matrix){
		int[][] copyMatrix = matrix.clone();
		int[][] moveMask = {
				{0, 1}, {1, 0}, {0, -1}, {-1, 0}
		};

		int[] result = new int[matrix.length * matrix.length];
		int count = matrix.length * matrix[0].length;

		result[0] = copyMatrix[0][0];
		copyMatrix[0][0] = -1;
		int num = 1;
		int direction = 0;
		int x = 0;
		int y = 0;
		do {
			int nextX = x + moveMask[direction % 4][1];
			int nextY = y + moveMask[direction % 4][0];
			if (nextX >= 0 && nextX < matrix[0].length && nextY >= 0 && nextY < matrix.length) {
				if (copyMatrix[nextY][nextX] == -1) {
					direction++;
				} else {
					result[num] = copyMatrix[nextY][nextX];
					copyMatrix[nextY][nextX] = -1;
					num++;
					x = nextX;
					y = nextY;
				}
			} else {
				direction++;
			}
		} while (num < count);

		return result;
	}
}
