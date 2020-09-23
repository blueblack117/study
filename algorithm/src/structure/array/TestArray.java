package structure.array;

import java.util.*;

/**
 * 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
 * 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.
 *
 * 제한사항
 * •배열의 길이는 10만 이하입니다.
 * •배열의 원소는 0 이상 10만 이하인 정수입니다.
 *
 * 입출력 예 설명
 *
 * 입출력 예 #1
 * 입력이 [4, 1, 3, 2]가 주어진 경우, 배열의 길이가 4이므로 배열에는 1부터 4까지 숫자가 모두 들어 있어야 합니다. [4, 1, 3, 2]에는 1부터 4까지의 숫자가 모두 들어 있으므로 true를 반환하면 됩니다.
 *
 * 입출력 예 #2
 *  [4, 1, 3]이 주어진 경우, 배열의 길이가 3이므로 배열에는 1부터 3까지 숫자가 모두 들어 있어야 합니다. [4, 1, 3]에는 2가 없고 4가 있으므로 false를 반환하면 됩니다.
 *
 */
public class TestArray {

    // 16.3/20 (효율성 2.2)
    public boolean solution(int[] arr) {
        boolean answer = false;

        SortedSet<Integer> checkSet = new TreeSet<>();
        for (int inx=0; inx<arr.length; inx++) {
            checkSet.add(arr[inx]);
        }

        if (checkSet.last() == arr.length && checkSet.size() == arr.length) {
            answer = true;
        }

        return answer;
    }

    // 17/20 (효율성 3)
    public boolean solution2(int[] arr) {
        boolean answer = false;

        Set<Integer> set = new HashSet<Integer>();
        for (int inx=0; inx<arr.length; inx++) {
            set.add(arr[inx]);
        }

        Integer[] arrSet = new Integer[set.size()];
        set.toArray(arrSet);
        Arrays.sort(arrSet);

        if (arrSet[arrSet.length-1] == arr.length && arrSet.length == arr.length) {
            answer = true;
        }
        return answer;
    }

    public static void main(String[] args) {

        TestArray alg = new TestArray();

        int[] arr = new int[] {4, 1, 3, 2};
        System.out.println(alg.solution(arr));
        System.out.println(alg.solution2(arr));

        int[] arr2 = new int[] {4, 1, 3};
        System.out.println(alg.solution(arr2));
        System.out.println(alg.solution2(arr2));
    }
}
