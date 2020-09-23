package javabogi.SortedArray;

import java.util.ArrayList;
import java.util.List;

/**
 * SortedArray (20분)
 *
 * 숫자가 정렬된 array를 2개 리턴하는 함수를 만드세요.
 *
 * 입력값: 넓이, 높이, 최대값
 *
 * 예) 4, 3, 14 (MaxNumber가 자리수보다 큰 경우)
 * =>
 *    1 2  3  4             1 4 7 10
 *    5 6  7  8       &&    2 5 8 11
 *    9 10 11 12            3 6 9 12
 *    (13, 14는 자리가 없으므로 생략됨)
 *
 * 에) 4, 3, 6 (MaxNumber가 자리수보다 작은 경우)
 * =>
 *    1 2 3 4               1 4 5 2
 *    5 6 5 4         &&    2 5 4 1
 *    3 2 1 0               3 6 3 0
 *    (MaxNumber까지 나열한 후 다시 역순으로 정렬, 그외 0으로 set)
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class SortedArray {

	boolean isReverse = false;
	public List<Integer[][]> get(int width, int height, int maxNumber) {
		List<Integer[][]> list = new ArrayList<>();

		Integer[][] arrInt1 = new Integer[width][height];
		Integer[][] arrInt2 = new Integer[width][height];

		Integer number = 0;
		isReverse = false;
		for (int inx=0; inx<width; inx++) {
			for (int jnx=0; jnx<height; jnx++) {
				number =  getNumber(number, maxNumber);
				arrInt1[inx][jnx] = number;
			}
		}

		number = 0;
		isReverse = false;
		for (int inx=0; inx<height; inx++) {
			for (int jnx=0; jnx<width; jnx++) {
				number = getNumber(number, maxNumber);
				arrInt2[jnx][inx] = number;
			}
		}

		list.add(arrInt1);
		list.add(arrInt2);
		return list;
	}

	private int getNumber(int curNumber, int maxNumber) {
		int number = 0;
		if (curNumber >= maxNumber) {
			isReverse = true;
		}

		if (isReverse) {
			if (curNumber > 0) {
				number = curNumber - 1;
			} else {
				number = 0;
			}
		} else {
			number = curNumber + 1;
		}
		return number;
	}

	public static void print(List<Integer[][]> list) {
		for (Integer[][] array: list) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					System.out.print(array[i][j]);
					if (j + 1 < array[i].length) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SortedArray sortArray = new SortedArray();
		print(sortArray.get(3, 4, 14));
		print(sortArray.get(3, 4, 6));
	}
}
