package javabogi.Rank;

/**
 * Rank (10분)
 *
 * ID, 수학, 영어 점수 2차원 배열이 주어졌을 때 총점, 등수, 순번을 출력하는 문제입니다. 단, 점수가 동일할 경우 같은 등수로
 * 표시하고 다음 등수는 건너뜁니다.
 *
 * 예) 실행결과
 * ID 총점 등수 순번
 * 56789 180 1 1
 * 45678 160 2 2
 * 34567 140 3 3
 * 12345 130 4 4
 * 67890 130 4 5
 * 23456 90 6 6
 *
 * ----------- Pseudocode ----------- TODO
 *
 */
public class Rank {

	public void show(int[][] scores) {
		int rowLength = scores.length;
		int[][] ranking = new int[rowLength][2];

		for (int inx = 0; inx < rowLength; inx++) {
			ranking[inx][0] = scores[inx][0]; // id
			ranking[inx][1] = scores[inx][1] + scores[inx][2];
		}

		for (int i = 0; i < ranking.length; i++) {
			for (int j = i; j < ranking.length; j++) {
				if(ranking[i][1] < ranking[j][1]) {
					swap(ranking, i, j, 0);
					swap(ranking, i, j, 1);
				}
			}
		}

		printArray(ranking);
	}

	private void swap(int[][] ranking, int i, int j, int index) {
		int temp = ranking[i][index];
		ranking[i][index] = ranking[j][index];
		ranking[j][index] = temp;
	}

	private void printArray(int[][] ranking) {
		int order = 1;
		int grade = 1;
		int sameGrade = 1;
		for (int i = 0; i < ranking.length; i++) {
			System.out.print(ranking[i][0] + " " + ranking[i][1]);
			if (i == 0) {
				System.out.print(" " + grade + " " + order++);
			} else {
				if (ranking[i-1][1] == ranking[i][1]) {
					sameGrade++;
					System.out.print(" " + grade + " " + order++);
				} else {
					grade += sameGrade;
					System.out.print(" " + grade + " " + order++);
					sameGrade = 1;
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] scores = {
				// ID, 수학, 영어
				{ 12345, 60, 70 }, { 23456, 50, 40 }, { 34567, 40, 100 }, { 45678, 80, 80 }, { 56789, 80, 100 },
				{ 67890, 80, 50 } };

		Rank rank = new Rank();
		rank.show(scores);
	}
}
