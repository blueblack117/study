package javabogi.Maze;

/**
 Maze (미로찾기) (20분)

 미로를 나타내는 n * n의 int 배열 A가 주어진다.
 0인 경우 지나갈 수 있는 길이고 1인 경우 지나갈 수 없는 길이다.

 A[0][0](아래 예시의 좌상단) 에서 출발해 상/하/좌/우/오른쪽아래대각선 5가지 방향으로만 이동하여 A[n-1][n-1](아래 예시의 우하단) 까지의 경로가 존재하면 true,
 아닐 경우 false를 출력하는 프로그램을 작성하시오.
 (단, A[0][0] = 0, A[n-1][n-1] = 0 이라고 가정한다.)

 예시) □ = true, ■ = false, n = 10

 - map1
 □□□■■■□□□□
 □□■□□□□□□■
 □□□□■□□□□■
 ■□■■■■■■□■
 ■□■□□□■□□□
 ■■□□□■■□■■
 □□■□■■□■■□
 ■□■□■■■□□□
 □■■□□□□■□□
 ■□□■□■■□□□
 true

 - map2
 □□■■■□□■□□
 ■□■■□□□□■□
 ■□□□□■■■■■
 ■■■□■■■□■□
 ■■□□■□□□□□
 ■■■□□■□■■□
 □■■□■□■□■■
 □□□■■■■□■■
 □■□■□■□□□□
 □■□■■□■□□□
 false
 **/

import java.util.Random;

public class Maze {

	private int[][] map;

	public Maze(int[][] map) {
		this.map = map.clone();
	}

	public Maze(int n) {
		/* 랜덤 테스트케이스 생성 */
		map = new int[n][n];
		Random r = new Random();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = (r.nextInt()) % 2;
			}
		}
		map[0][0] = map[n - 1][n - 1] = 0;
	}

	public void printMap() {
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				sb.append((map[i][j] == 0 ? '□' : '■'));
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}

	public boolean isSolvable() {
		// TODO
		return false;
	}

	public static void main(String[] args) {
		int n = 10;
		int[][] map1 = {
				{0,0,0,1,1,1,0,0,0,0},
				{0,0,1,0,0,0,0,0,0,1},
				{0,0,0,0,1,0,0,0,0,1},
				{1,0,1,1,1,1,1,1,0,1},
				{1,0,1,0,0,0,1,0,0,0},
				{1,1,0,0,0,1,1,0,1,1},
				{0,0,1,0,1,1,0,1,1,0},
				{1,0,1,0,1,1,1,0,0,0},
				{0,1,1,0,0,0,0,1,0,0},
				{1,0,0,1,0,1,1,0,0,0}
		};
		int[][] map2 = {
				{0,0,1,1,1,0,0,1,0,0},
				{1,0,1,1,0,0,0,0,1,0},
				{1,0,0,0,0,1,1,1,1,1},
				{1,1,1,0,1,1,1,0,1,0},
				{1,1,0,0,1,0,0,0,0,0},
				{1,1,1,0,0,1,0,1,1,0},
				{0,1,1,0,1,0,1,0,1,1},
				{0,0,0,1,1,1,1,0,1,1},
				{0,1,0,1,0,1,0,0,0,0},
				{0,1,0,1,1,0,1,0,0,0}
		};

		Maze maze1 = new Maze(map1);
		Maze maze2 = new Maze(map2);
		Maze maze = new Maze(n);

		maze1.printMap();
		System.out.println(maze1.isSolvable());	// true
		maze2.printMap();
		System.out.println(maze2.isSolvable());	// false
		maze.printMap();
		System.out.println(maze.isSolvable());	// ?
	}
}
