package quiz.test.level3;

import java.util.LinkedList;

/**
 * 2xN 타일링
 *
 * 가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다.
 * 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다.
 * 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.
 *
 * 타일을 가로로 배치 하는 경우
 * 타일을 세로로 배치 하는 경우
 *
 * 예를들어서 n이 7인 직사각형은 다음과 같이 채울 수 있습니다.
 * 직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 가로의 길이 n은 60,000이하의 자연수 입니다.
 * 경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.
 *
 *
 * 입출력 예
 * n	result
 * 4	5
 * 7    21
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 다음과 같이 5가지 방법이 있다.
 */
public class No1 {

    public static void main(String[] args) {
        No1 alg = new No1();
        System.out.println(alg.solution(4));
        System.out.println(alg.solution(7));
    }

    // 정확성: 35.0
    //효율성: 15.0
    //합계: 50.0 / 50
    public long solution(int n) {
        int answer = 0;
        int[] wh = new int[n+1];
        int s = 1000000007;
        wh[0] = 1;
        wh[1] = 1;
        for(int i = 2; i <= n; i++) {
            wh[i] = (wh[i-1] + wh[i-2])%s;
        }
        answer = wh[n];
        return answer;
    }


    public int solution2(int n) {
        LinkedList<Integer> perArr = new LinkedList<>();
        boolean[] perCheck = new boolean[n];
        permutation(n, n, perArr, perCheck);
        int answer = perArr.size() % 1000000007;
        return answer;
    }

    private static void permutation(int n, int r, LinkedList<Integer> perArr, boolean[] perCheck) {
        if(perArr.size() == r){
            for(int i : perArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(perCheck[i] == false){
//                perArr.add(i);
                if (perArr.size() >= 3) {

                } else {

                }
                perArr.add(1);
                perCheck[i] = true;
                permutation(n, r, perArr, perCheck);
                perCheck[i] = false;
                perArr.removeLast();
            }
        }
    }
}
