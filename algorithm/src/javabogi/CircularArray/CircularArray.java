package javabogi.CircularArray;

/**
 * CircularArray (15분)
 *
 * int타입의 배열을 입력받아 주어진 수 만큼 좌측 밀기, 우측 밀기, 구간 반전을 할 수 있는 메소드 구현
 *
 * 예) 입력 1234567
 * -> 우측 밀기 2: 6712345
 * -> 좌측 밀기 1: 7123456
 * -> 반전 2~4   : 7321456
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class CircularArray {

	private String intArray;

	public CircularArray(int[] array) {
		StringBuilder sb = new StringBuilder();
		for (int num : array) {
			sb.append(num);
		}
		this.intArray = sb.toString();
	}

	public void shiftRight(int i) {
		String newNumber = intArray.substring(intArray.length()-i, intArray.length()) + intArray.substring(0, intArray.length()-i);
		intArray = newNumber;
	}

	public void shiftLeft(int i) {
		String newNumber = intArray.substring(i, intArray.length()) + intArray.substring(0, i);
		intArray = newNumber;
	}

	public void reverse(int from, int to) {
		StringBuilder sb = new StringBuilder();
		sb.append(intArray.substring(from-1, to));

		String newNumber = intArray.substring(0, from-1) + sb.reverse() + intArray.substring(to, intArray.length());
		intArray = newNumber;
	}

	public void print() {
		System.out.println(intArray);
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		CircularArray circularArray = new CircularArray(array);
		circularArray.print();
		circularArray.shiftRight(2);
		circularArray.print();
		circularArray.shiftLeft(1);
		circularArray.print();
		circularArray.reverse(2, 4);
		circularArray.print();
	}

}
