package structure.array;

import java.util.Arrays;

public class ArrayCompare {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{1, 2, 3};

        System.out.println(arr1.equals(arr2));
        System.out.println(Arrays.equals(arr1, arr2));

        int[] nums1 = {100, 200, 300};
        int[] nums2 = nums1;
        int[] nums3 = nums1.clone();

        System.out.println(nums1 == nums2);
        System.out.println(nums1 == nums3);
        System.out.println();


        // 깊은 비교
        // - 참조 주소 비교(X) -> 각 배열의 요소의 값들을 비교
        System.out.println(Arrays.equals(nums1, nums2));
        System.out.println(Arrays.equals(nums1, nums3));
        System.out.println();

        // 깊은 비교
        String[][] name1 = {{"홍길동", "아무개", "테스트"}, {"하하하", "호호호", "후후후"}};
        String[][] name2 = {{"홍길동", "아무개", "테스트"}, {"하하하", "호호호", "후후후"}};

        System.out.println(name1 == name2); // 얕은 비교 -> 다른애
        System.out.println(Arrays.equals(name1, name2)); // 깊은비교(1차원 비교)
        System.out.println(Arrays.deepEquals(name1, name2)); // 더욱..깊은비교(2차원 이상);
    }
}
