package quiz.practice;

import java.util.Arrays;

/**
 * n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다.
 * 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다.
 * 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다.
 * 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
 *
 * 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때
 * 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 선수의 수는 1명 이상 100명 이하입니다.
 * 경기 결과는 1개 이상 4,500개 이하입니다.
 * results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
 * 모든 경기 결과에는 모순이 없습니다.
 *
 * 입출력 예
 * n	results	return
 * 5	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	2
 * 입출력 예 설명
 * 2번 선수는 [1, 3, 4] 선수에게 패배했고 5번 선수에게 승리했기 때문에 4위입니다.
 * 5번 선수는 4위인 2번 선수에게 패배했기 때문에 5위입니다.
 */
public class Order {

    public static void main(String[] args) {
        Order alg = new Order();
        int[][] arr = new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(alg.solution(5, arr));
    }

    public int solution(int n, int[][] results) {
        int INF = 987654321;//방문불가를 뜻함

        int answer = 0;
        int[][] scores=new int[n+1][n+1];
        int win, lose;
        //배열 초기화
        for(int[] score:scores){
            Arrays.fill(score, INF);
        }
        //대각선을 0
        for(int i=0;i<scores.length;i++){
            for(int j=0;j<scores.length;j++){
                if(i==j) scores[i][j]=0;
            }
        }
        //한방향 그래프 win->lose
        for(int[] result:results){
            win=result[0];
            lose=result[1];
            scores[win][lose]=1;
        }
        //scores[i][j]로 가는 최단경로 저장
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(scores[i][j]>scores[i][k]+scores[k][j]){
                        scores[i][j]=scores[i][k]+scores[k][j];
                    }
                }
            }
        }
         for(int[] score:scores){
             System.out.println(Arrays.toString(score));
         }
        //선수들이 게임을 한 적이 있는지 확인
        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        for(int i=1;i<=n;i++){//사람 i 기준
            for(int j=1;j<=n;j++){//나머지 j선수들과 게임한적 있는지 체크
                if(i==j) continue;//나자신과 게임을 뜻하므로 패스
                if(scores[i][j]==INF && scores[j][i]==INF){//경로가 존재하지 않으면(i와 j가 게임하지 않았다면)
                    flag[i]=false;
                    break;//모두와 게임을 해야하므로
                }
            }
        }
        // System.out.println(Arrays.toString(flag));
        for(int i=1;i<flag.length;i++){
            if(flag[i]) answer++;
        }
        return answer;
    }
}
