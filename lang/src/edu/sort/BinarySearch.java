package edu.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearch {
    public static void main(String args[]) {
        // 배열 초기화
        int data[] = {11, 16, 21, 26, 35, 39, 47};
        int k = 0, cnt = 0;
        int low = 0;
        int high = data.length - 1;
        int middle;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("찾고자 하는 숫자를 2자리로 입력하세요: ");

        try {
            k = Integer.parseInt(in.readLine());
        } catch (Exception e) // 예외 처리
        {
            System.out.println("입력 오류");
        }

        // 무한 반복문 사용
        while (true) {
            if (low > high)    // low값이 high값 보다 커질시 데이터가 없음
            {
                System.out.println("검색 데이터가 없습니다.");
                break;
            }
            middle = (low + high) / 2; // 중앙값 구하기
            cnt++; // 몇번 만에 찾는지 확인하기위한 카운트 변수 증가

            System.out.println("비교값 : " + data[middle]);

            if (data[middle] == k)    // key값과 인덱스가 중앙값인 배열과 같을시 찾음
            {
                System.out.println(middle + 1 + "번쨰 위치 검색횟수 = " + cnt + "번");
                break;
            }
            // 키값이 더 클시 low 값을 +1
            if (k > data[middle]) {
                low = middle + 1;
            } else    // 키값보다 작을시 high값을 중앙값-1
            {
                high = middle - 1;
            }
        }
    }
}
