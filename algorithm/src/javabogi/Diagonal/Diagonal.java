package javabogi.Diagonal;

/*
 *  행렬 대각선으로 채우기
 *
 *  행렬 안의 수를 을 1부터 nxn까지 넣는데,
 *  숫자가 대각선으로 커지도록 채우기
 *
 *  만약 input이 5이면 5x5 행렬에 1~25를 대각선순으로 차례로 넣어야함
 *
 *   1   2   4   7  11
 *   3   5   8  12  16
 *   6   9  13  17  20
 * 10  14  18  21  23
 * 15  19  22  24  25
 * */


public class Diagonal {

	public static void printDiagonal( int number ){
		int[][] array = new int[number][number];
		int num = 1;
		int length = (number-1) * 2;

		for (int inx=0; inx<=length; inx++) {
			for (int jnx=0; jnx<=inx; jnx++) {
				if (jnx < number && (inx-jnx) < number) {
					array[jnx][inx-jnx] = num++;
				}
			}
		}
		printDiagonal(array);
	}

	public static void printDiagonal(int[][] array){
		for (int inx=0; inx<array.length; inx++) {
			for (int jnx=0; jnx<array[inx].length; jnx++) {
				System.out.print(array[inx][jnx] + "   ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		printDiagonal(3);
		printDiagonal(4);
		printDiagonal(5);
		printDiagonal(7);
	}
}
