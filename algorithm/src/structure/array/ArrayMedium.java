package structure.array;

import java.util.Arrays;

public class ArrayMedium {
    public static void main(String[] args) {
        test();

        int[] arrayInt = new int[] {24, 31, 35, 49};
        float result = getMedian(arrayInt);
        System.out.print(result);
    }

    public static void test() {
        int[][] arr = {{7, 9, 14}, {24, 31, 35, 49}, {17, 37, 37, 47, 57}};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length % 2 == 0) {
                int idx = arr[i].length / 2 - 1;
                System.out.println((arr[i][idx] + arr[i][++idx]) / 2);
            } else {
                int idx = arr[i].length / 2;
                System.out.println(arr[i][idx]);
            }
        }
    }

    private static float getMedian(int[] arrayInt) {
        Arrays.sort(arrayInt);//오름차순 정렬
        int size = arrayInt.length;
        float result;
        if (size % 2 == 0) { //배열크기가 짝수일경우
            int m = size / 2;
            int n = size / 2 - 1;
            result = (float) (arrayInt[m] + arrayInt[n]) / 2; //중앙값 2개의  평균
        } else { //배열크기가 홀수인경우
            int m = size / 2;
            result = arrayInt[m]; //중앙값
        }
        return result;
    }

    public static double searchMedium(int[] numbers) {
        return (numbers[(numbers.length - 1) / 2] + numbers[(numbers.length) / 2]) / 2.0;
    }
}
