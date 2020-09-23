package javabogi.SelfNumber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.
 * 예를 들어
 * d(91) = 9 + 1 + 91 = 101
 * 이 때, n을 d(n)의 제네레이터(generator)라고 한다. 위의 예에서 91은 101의 제네레이터이다.
 *
 * 어떤 숫자들은 하나 이상의 제네레이터를 가지고 있는데, 101의 제네레이터는 91 뿐 아니라 100도 있다. 그런데 반대로, 제네레이터가 없는 숫자들도 있으며,
 * 이런 숫자를 인도의 수학자 Kaprekar가 셀프 넘버(self-number)라 이름 붙였다.
 * 예를 들어 1,3,5,7,9,20,31 은 셀프 넘버 들이다.
 *
 * 1 이상이고 5000 보다 작은 모든 셀프 넘버들의 합을 구하라.
 *
 * -----------
 * Pseudocode
 * -----------
 *
 */

public class SelfNumber {

	public int selfNumber(int num) {
		List<Integer> numList = new ArrayList<Integer>();
		getSelfNumbers(num, numList);
		System.out.println(numList);

		int result = 0;
		for (Integer number : numList) {
			result += number;
		}
		return result;
	}

	public void getSelfNumbers(int num, List<Integer> list) {
		Map<Integer, Integer> dnList = new HashMap<Integer, Integer>();

		for (int inx=0; inx<=num; inx++) {
			String generator = Integer.toString(inx);
			int dn = inx;
			for (int jnx=0; jnx<generator.length(); jnx++) {
				dn += Integer.parseInt(generator.substring(jnx, jnx+1));
			}
			dnList.put(inx, dn);
		}

		Collection<Integer> dnNumbers = dnList.values();
		for (int inx=1; inx<=num; inx++) {
			if (!dnNumbers.contains(inx)) {
				list.add(inx);
			}
		}
	}



	public static void main(String args[]) {
		SelfNumber selfNumber = new SelfNumber();

		System.out.println(selfNumber.selfNumber(37));  //  합 : 76
		System.out.println(selfNumber.selfNumber(42)); // 합 : 118
		System.out.println(selfNumber.selfNumber(5000)); // 합 : 1227365
	}
}
