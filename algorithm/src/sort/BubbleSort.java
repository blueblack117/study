package sort;

public class BubbleSort {
    public static void main(String[] args) {
        // 정렬 할 배열 선언
        int test[] = {20, 30, 40, 50, 10};
        int i, j, temp, flag;
        System.out.println("정렬 전");
        for (i = 0; i < 5; i++)     // 정렬 전 배열 출력
        {
            System.out.println((i + 1) + "번째 데이터" + test[i]);
        }

        // 버블 정렬
        for (i = 0; i < 4; i++) {
            flag = 0;
            for (j = 0; j < 4 - i; j++) {
                if (test[j] < test[j + 1]) {
                    temp = test[j];
                    test[j] = test[j + 1];
                    test[j + 1] = temp;
                    flag = 1;
                }
            }

            if (flag == 0) {
                break;
            }
        }

        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println("정렬 후");
        for (i = 0; i < 5; i++)     // 정렬 후 배열
        {
            System.out.println((i + 1) + "번째 데이터" + test[i]);
        }
    }
}
