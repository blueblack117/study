package quiz.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Maze {
    static int[][] map, visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        map = new int[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] map_data = br.readLine().trim().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(map_data[j]);
                // System.out.print(map[i][j]);
             }
                // System.out.println();
         }
            bfs(0, 0, n, m);
            printMap(n,m);
    }

    private static void bfs(int a, int b, int n, int m) {
        // TODO Auto-generated method stub
        int x, y, ax, ay, dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(a, b));
        visit[a][b] = 1; // visit
        while (!queue.isEmpty()) {
            x = queue.peek().x;
            y = queue.poll().y;
            for (int i = 0; i < 4; i++) {
                ax = x + dx[i];
                ay = y + dy[i];
                if (isPossible(x, y, ax, ay, n, m)) {
                    cnt++;
                    map[ax][ay] = map[x][y] + 1;
                    visit[ax][ay] = 1;
                    queue.offer(new Node(ax, ay));
                }
            }
        }
    }
    private static boolean isPossible(int x, int y,int ax, int ay, int n, int m) {
        // 범위 안에 들어가는지?
        boolean isRange = (ax >= 0 && ax < n) && (ay >= 0 && ay < m);
        if(!isRange) {
            return false;
        }else {
            // 방문 안한곳인지?
            boolean isNotVisit = (visit[ax][ay] == 0);
            // 유효한 길인지?
            boolean isCanGoing = (map[ax][ay] != 0);
            return (isNotVisit && isCanGoing);
        }
    }
    private static void printMap(int n, int m) {
        for(int i=0; i< n; i++) {
            for(int j=0; j< m; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(cnt + "번의 연산");
    }
}
class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
