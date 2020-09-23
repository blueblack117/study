package javabogi.Minesweeper;

import java.util.Scanner;

/**
 지뢰찾기 게임은 M x N 매트릭스에 위치해 있는 지뢰를 찾는 게임이다.

 M x N 매트릭스 상의 격자(square)는 지뢰이거나 지뢰가 아니다.

 지뢰 격자는 *로 표시한다. 지뢰가 아닌 격자(square)는 숫자로 표시하며 그 숫자는 인접해 있는 지뢰의 수를 의미한다.
 (격자(sqaure)는 최대 8개의 인접한 지뢰를 가질 수 있다.)

 다음은 4x4 매트릭스에서 2개의 지뢰(*)를 표시하는 방법이다.

 *...
 ....
 .*..
 ....

 *100
 2210
 1*10
 1110

 [입력]
 * 첫번째 줄은 M x N 의 M(행)과 N(열)에 해당되는 숫자이다.
 N과 M은 0보다 크고 100 이하이다. (0< N, M<=100)
 그 다음 M개의 줄이 차례로 입력되고 각 줄은 정확하게 N개의 문자가 입력된다.
 지뢰 격자는 *로 표시하며 지뢰가 아닌 격자는 * .(dot)로 표시한다.
 M과 N에 0이 들어오면 프로그램은 종료된다.

 [출력]
 * 지뢰(*)를 제외한 나머지 격자의 숫자값을 찾아서 M x N 매트릭스를 출력한다.

 Sample Input

 4 4
 *...
 ....
 .*..
 ....
 3 5
 **...
 .....
 .*...
 0 0

 Sample Output

 Field #1:
 *100
 2210
 1*10
 1110

 Field #2:
 **100
 33200
 1*100

 (출처 : http://www.cplusplus.com/forum/beginner/73186/)
 *
 * ----------- Pseudocode -----------
 * TODO
 *
 */
public class Minesweeper {

	private void start() {
		int m = -1;
		int n = -1;
		Scanner in = new Scanner(System.in);
		while (m != 0 && n != 0) {
			String inputStr = in.nextLine();
			String[] inputNum = inputStr.split(" ");
			try {
				m = Integer.parseInt(inputNum[0]);
				n = Integer.parseInt(inputNum[1]);
				if ((m > 0 && m <= 100) && (n > 0 && n <= 100)) {
					String[][] input = inputMine(m, n, in);
					calculate(input);
					print(input);
				}
			} catch(NumberFormatException e) {
				System.out.println("Invalid input...");
			}
		}
		in.close();
		System.out.println("The End...");
	}

	private String[][] inputMine(int m, int n, Scanner in) {
		String[][] input = new String[m][n];
		String inputStr = null;
		for (int inx=0; inx<m; inx++) {
			inputStr = in.nextLine();
			if (inputStr.length() == n) {
				for (int jnx=0; jnx<n; jnx++) {
					String cell = inputStr.substring(jnx, jnx+1);
					if (cell.equals(".") || cell.equals("*")) {
						input[inx][jnx] = cell;
					} else {
						System.out.println("Invalid input...");
						inx--;
						break;
					}
				}
			} else {
				System.out.println("Invalid input...");
				inx--;
			}
		}
		return input;
	}

	private void calculate(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j].equals(".")) {
					int count = 0;
					if (((i-1 >= 0) && (j-1 >= 0)) && array[i-1][j-1].equals("*")) {
						count++;
					}
					if ((i-1 >= 0) && array[i-1][j].equals("*")) {
						count++;
					}
					if (((i-1 >= 0) && (j+1 < array[i].length)) && array[i-1][j+1].equals("*")) {
						count++;
					}
					if ((j-1 >= 0) && array[i][j-1].equals("*")) {
						count++;
					}
					if ((j+1 < array[i].length) && array[i][j+1].equals("*")) {
						count++;
					}
					if (((i+1 < array.length) && (j-1 >= 0)) && array[i+1][j-1].equals("*")) {
						count++;
					}
					if ((i+1 < array.length) && array[i+1][j].equals("*")) {
						count++;
					}
					if (((i+1 < array.length) && (j+1 < array[i].length)) && array[i+1][j+1].equals("*")) {
						count++;
					}
					array[i][j] = Integer.toString(count);
				}
			}
		}
	}

	private void print(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
				if (j + 1 < array[i].length) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Minesweeper minesweeper = new Minesweeper();
		minesweeper.start();
	}

}
