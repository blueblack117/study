package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SequentialSearch {
    public static void main(String[] args) {
        // 배열 초기화
        int ar[] = {23, 47, 19, 63, 57, 26, 75, 73, 82, 89, 47, 11};
        int i, num;
        int key = 0, index = 0;
        num = ar.length;    // 배열의 길이

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("찾고자 하는 숫자를 2자리로 입력하세요: ");

        try {
            key = Integer.parseInt(in.readLine());
        } catch (Exception e)    // 예외 처리
        {
            System.out.println("입력 오류");
        }

        // 배열의 길이 만큼 반복
        for (i = 0; i < num; i++) {
            // 키값과 벼열의 값이 같아질경우
            // i+1값이 인덱스로 저장
            if (ar[i] == key) {
                index = i + 1;
            }
        }

        // 인덱스 0인경우 찾는 값이 없음
        if (index == 0) {
            System.out.println("찾고자 하는 값이 없습니다.");
        } else    // 인덱스가 0이 아닐경우 위에 저장한 인덱스
        {
            System.out.println("찾는 값은 " + index + "번째에 있습니다.");
        }
    }
}
