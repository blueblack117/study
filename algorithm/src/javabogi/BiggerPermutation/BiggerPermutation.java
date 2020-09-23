package javabogi.BiggerPermutation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * BiggerPermutation (30분)
 *
 * 문자를 입력 받아 각 자리를 변경하여 나올수 있는 문자를 사전순으로 정렬하여 원래의 문자보다 나중에 정렬되는 문자를 찾아 출력하세요.
 *
 * 예) BAC: ABC, ACB, BAC, BCA, CAB, CBA -> BCA, CAB, CBA
 *
 * ----------- Pseudocode ----------- TODO
 *
 */
public class BiggerPermutation {

	public String execute(String word) {
		List<String> permutationList = new ArrayList<String>();
		this.permutation("", word, permutationList);
//		System.out.println("before sort : " + permutationList);

		boolean isEqual = false;
		StringBuilder sb = new StringBuilder();
//		Collections.sort(permutationList);
		Ascending asc = new Ascending();
		permutationList.sort(asc);
//		System.out.println("after sort : " + permutationList);

		String[] wordList = new String[permutationList.size()];
		wordList = permutationList.toArray(wordList);
		for (String str : wordList) {
			if (isEqual) {
				sb.append(str).append(", ");
			}
			if (str.equals(word)) {
				isEqual = true;
			}
		}
		String result = sb.toString();
		return result.substring(0, result.length()-2);
	}

	public void permutation(String prefix, String str, List<String> permutationList) {
		int length = str.length();
		if (length == 0) {
			permutationList.add(prefix);
		} else {
			for (int inx = 0; inx < length; inx++) {
				permutation(prefix + str.substring(inx, inx + 1),
						str.substring(0, inx) + str.substring(inx + 1, length), permutationList);
			}
		}
	}

	public static void main(String[] args) {
		BiggerPermutation biggerPermutation = new BiggerPermutation();
		System.out.println(biggerPermutation.execute("BAC")); // BCA, CAB, CBA
		System.out.println(biggerPermutation.execute("CDBA")); // DABC, DACB, DBAC, DBCA, DCAB, DCBA
		System.out.println(biggerPermutation.execute("CDBAEFGDHGGH"));
	}

}

class Ascending implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

}