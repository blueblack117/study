package javabogi.SpecialSort;

import java.util.ArrayList;
import java.util.List;

/**
 * n개의 정수를 가진 배열이 있다. 이 배열은 양의정수와 음의 정수를 모두 가지고 있다.
 * 이제 당신은 이 배열을 좀 특별한 방법으로 정렬해야 한다.
 정렬이 되고 난 후, 음의 정수는 앞쪽에 양의정수는 뒷쪽에 있어야 한다.
 또한 양의정수와 음의정수의 순서에는 변함이 없어야 한다.

 입력: -1 1 3 -2 2
 출력: -1 -2 1 3 2

 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class SpecialSort {

	private static int[] sort(int[] list) {
		List<Integer> minusList = new ArrayList<Integer>();
		List<Integer> plusList = new ArrayList<Integer>();

		for (int num : list) {
			if (num < 0) {
				minusList.add(num);
			} else {
				plusList.add(num);
			}
		}

		int inxArr = 0;
		int[] retList = new int[list.length];
		for (int num : minusList) {
			retList[inxArr++] = num;
		}
		for (int num : plusList) {
			retList[inxArr++] = num;
		}
		return retList;
	}

	public static void main(String[] args) {
		int[] list = {-1, 1, 3, -2, 2};
		int[] result = SpecialSort.sort(list);
		for (int num: result) {
			System.out.print(num + " ");
		}
	}

}
