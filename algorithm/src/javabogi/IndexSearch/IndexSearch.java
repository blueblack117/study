package javabogi.IndexSearch;

/**
 IndexSearch (20분)

 빈 문자열이 섞여있는 정렬 상태의 배열이 주어졌을 때, 특정한 문자열의 위치를 찾는 메서드를 작성하라.
 배열이 상당히 클 수 있으니 이진 탐색을 이용하세요.

 예) 입력: {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""} 에서 "ball"을 찾기
 출력: 4

 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class IndexSearch {

	public static int search(String[] strings, String str, int first, int last) {
		if (first > last) {
			return -1;
		}

		/* Move mid to the middle */
		int mid = (last + first) / 2;

		/* If mid is empty, find closest non-empty string. */
		if (strings[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;

			while (true) {
				if (left < first && right > last) {
					return -1;
				} else if (right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}

		/* Check for string, and recurse if necessary */
		if (str.equals(strings[mid])) { // Found it!
			return mid;
		} else if (strings[mid].compareTo(str) < 0) { // Search right
			return search(strings, str, mid + 1, last);
		} else { // Search left
			return search(strings, str, first, mid - 1);
		}
	}

	public static int search(String[] strings, String str) {
		if (strings == null || str == null || str.isEmpty()) {
			return -1;
		}

		return search(strings, str, 0, strings.length - 1);
	}

	public static void main(String[] args) {
		String[] array = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(new IndexSearch().search(array, "ball"));
	}

}
