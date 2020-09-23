package javabogi.LargestPrimeFactor;

import java.util.ArrayList;
import java.util.List;

/**
 LargestPrimeFactor

 어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 한다.

 예를 들면 13195의 소인수는 5, 7, 13, 29 이다.

 600851475143의 소인수 중에서 가장 큰 수를 구하시오.

 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class LargestPrimeFactor {

	List<Long> list = new ArrayList<Long>();

	public long get(long num) {
		factor(num);
		long maxValue = 0L;
		for (Long number : list) {
			if (maxValue < number) {
				maxValue = number;
			}
		}
		System.out.println("Input Number is " + num + ", aliquot part List is " + list);
		return maxValue;
	}

	public boolean factor(long r) {
		long range = (long) Math.sqrt(r);

		for (long i = 2; i <= range; i++) {
			if (r % i == 0) {
				list.add(i);
				if (isPrime(r / i) == true) {
					list.add((long)r / i);
				}
				factor(r / i);
				return true;
			}
		}
		return false;
	}

	public boolean isPrime(long n) {
		long range = (long) Math.sqrt(n); // 검사할 범위

		// 2는 소수
		if (n == 2)
			return true;

		// n이 짝수 혹은 1 -> 소수 아님
		if (n % 2 == 0 || n == 1)
			return false;

		// i는 2부터 루트n 까지 홀수만 검사
		for (long inx = 3; inx <= range; inx += 2) {
			// n을 i로 나눈 나머지가 0 -> 소수 아님
			if (n % inx == 0)
				return false;
		}

		// n은 소수
		return true;
	}

	public static void main(String[] args) {
		LargestPrimeFactor largestPrimeFactor = new LargestPrimeFactor();
		System.out.println(largestPrimeFactor.get(100L));
		System.out.println(largestPrimeFactor.get(13195L));
		System.out.println(largestPrimeFactor.get(600851475143L));
	}

}
