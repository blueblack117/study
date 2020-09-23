package quiz.test.no02;

/**
 * 직사각형 모양의 격자가 있습니다. 이 격자는 1x1 크기 정사각형 칸들로 이루어져 있고,
 * 각 칸에는 거울이 대각선 방향으로 배치되어 있거나, 혹은 없습니다.
 * 빛을 격자의 가로 또는 세로 방향과 평행하고 격자칸의 중심을 지나도록 발사했을 때,
 * 빛이 격자 밖으로 나오기 전까지 가장 많이 반사되는 횟수는 몇 번인지 구하려고 합니다.
 *
 * 예를 들어, 다음과 같이 거울이 놓여져 있다면, 분홍색 선처럼 빛을 발사할 때 5번으로 가장 많이 반사됩니다.
 *
 * example.png
 *
 * 격자칸에 거울이 높인 상태를 나타내는 문자열 배열 mirrors가 매개변수로 주어집니다.
 * 이 격자에 빛을 발사했을 때 빛이 가장 많이 반사되는 횟수를 구하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * mirrors의 길이는 1 이상 200 이하입니다.
 * mirrors의 각 문자열 길이는 1 이상 200 이하입니다.
 * mirrors의 모든 문자열의 길이는 전부 동일합니다.
 * mirrors[i][j]는 위에서부터 i+1번째 행, 왼쪽에서부터 j+1번째 열의 상태를 의미합니다.
 * mirrors의 모든 문자열은 '0', '1', '2'로 이루어져 있습니다.
 * 각 숫자가 의미하는 상태는 다음 그림과 같습니다.
 * 012.png
 * 입출력 예
 * mirrors	result
 * ["111","200","212"]	5
 * ["1101","2101"]	6
 * ["00","00","00"]	0
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 본문에 예시가 설명되어 있습니다.
 * 입출력 예 #2
 *
 * 격자를 그림으로 표현하면 다음과 같습니다.
 * example2.png
 * 빨간색 선처럼 빛을 발사하면 빛이 6번 반사된 후 격자 밖으로 나옵니다.
 * 6번보다 많이 반사되는 경우는 없으므로 6을 return 하면 됩니다.
 * 입출력 예 #3
 *
 * 이 예시에서는 격자에 거울이 없습니다. 어디에서 어떻게 빛을 발사하더라도 단 1번도 반사되지 않으므로 0을 return 합니다.
 *
 * '방속의 거울'(SCPC 1회 예선, 12번)
 *
 */
public class Question04 {

    public static void main(String[] args) {
        Question04 alg = new Question04();

        String[] test1 = new String[] {"111","200","212"};
        System.out.println(alg.solution(test1));

        String[] test2 = new String[] {"1101","2101"};
        System.out.println(alg.solution(test2));

        String[] test3 = new String[] {"00","00","00"};
        System.out.println(alg.solution(test3));
    }

    public int solution(String[] mirrors) {
        int answer = -1;
        for (int i=0; i<mirrors.length; i++) {
            if (i==0) {
                for (int j=0; j<mirrors[0].length(); j++) {
                    int reflectCount = solution(mirrors, 2, i, j);
                    if (reflectCount > answer) {
                        answer = reflectCount;
                    }
                }
            } else if (i == mirrors.length-1) {
                for (int j=0; j<mirrors[0].length(); j++) {
                    int reflectCount = solution(mirrors, 1, i, j);
                    if (reflectCount > answer) {
                        answer = reflectCount;
                    }
                }
            } else {
                int reflectCount = solution(mirrors, 3, i, 0);
                if (reflectCount > answer) {
                    answer = reflectCount;
                }
                reflectCount = solution(mirrors, 4, i, mirrors[0].length()-1);
                if (reflectCount > answer) {
                    answer = reflectCount;
                }
            }
        }
        return answer;
    }

    public int solution(String[] mirrors, int direction, int i, int j) {
        int reflectCount = 0;
        do {
            char mirror = mirrors[i].charAt(j);
            if (mirror == '0') {            // X
                if (direction == 1) {       // up
                    i -= 1;
                } else if (direction == 2) { // down
                    i += 1;
                } else if (direction == 3) { // right
                    j += 1;
                } else if (direction == 4) { // left
                    j -= 1;
                }
            } else if (mirror == '1') {     // '/'
                if (direction == 1) {
                    j += 1;
                    direction = 3;
                } else if (direction == 2) {
                    j -= 1;
                    direction = 4;
                } else if (direction == 3) {
                    i -= 1;
                    direction = 1;
                } else if (direction == 4) {
                    i += 1;
                    direction = 2;
                }
                reflectCount++;
            } else if (mirror == '2') {         // '\'
                if (direction == 1) {
                    j -= 1;
                    direction = 4;
                } else if (direction == 2) {
                    j += 1;
                    direction = 3;
                } else if (direction == 3) {
                    i += 1;
                    direction = 2;
                } else if (direction == 4) {
                    i -= 1;
                    direction = 1;
                }
                reflectCount++;
            }
        } while ((i >= 0 && i < mirrors.length) && (j >= 0 && j < mirrors[0].length()));

        return reflectCount;
    }
}
