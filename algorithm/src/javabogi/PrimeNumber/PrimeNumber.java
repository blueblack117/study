package javabogi.PrimeNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * PrimeNumber (10분)
 *
 * 소수(prime number)는 1과 자기 자신만으로 나누어 지는 1보다 큰 자연수로 정의된다.
 *
 * 입력된 수보다 작은 모든 소수를 리턴하는 메소드를 작성하세요.
 *
 * 예) 입력 100
 *     리턴 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
 *
 * ----------- Pseudocode -----------
 * TODO
 *
 */
public class PrimeNumber {

	private List<Integer> getPrimeNumber(int max) {
		List<Integer> list = new ArrayList<>();
		for (int inx=2; inx<max+1; inx++) {
			if (isPrime(inx)) {
				list.add(inx);
			}
		}
		return list;
	}

	public boolean isPrime(int n) {
		int i;
		int range = (int) Math.sqrt(n); // 검사할 범위

		// 2는 소수
		if (n == 2)
			return true;

		// n이 짝수 혹은 1 -> 소수 아님
		if (n % 2 == 0 || n == 1)
			return false;

		// i는 2부터 루트n 까지 홀수만 검사
		for (i = 3; i <= range; i += 2) {
			// n을 i로 나눈 나머지가 0 -> 소수 아님
			if (n % i == 0)
				return false;
		}

		// n은 소수
		return true;
	}

	public static void main(String[] args) {
		PrimeNumber primeNumber = new PrimeNumber();
		List<Integer> numbers = primeNumber.getPrimeNumber(100);
		System.out.println(numbers);
	}

}
