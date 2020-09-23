package quiz.test.no01;

import java.util.ArrayList;
import java.util.List;

/**
 * 1x1 크기의 정사각형 칸들이 여러 개의 행과 열로 배치된 미로가 있습니다.
 * 당신은, 이 미로의 1행 1열의 왼쪽 벽면에서부터 시작하여 반시계방향으로 벽을 더듬어가면서 미로를 한 바퀴 순회해야 합니다.
 *
 * 예를 들어, 다음과 같은 3행 3열의 미로가 있다면, 미로의 순회 과정은 다음과 같습니다.
 * 빨간색으로 칠해진 선은 순회를 시작하면서 처음으로 마주하는 벽면을 나타냅니다.
 *
 * maze_example.png
 *
 * 각 벽면들은 만나는 순서대로 번호를 부여받습니다. 그리고 각 벽면들에 대해 그 벽면이 있는 위치를 알아내려고 합니다.
 * 예를 들어, 순회를 시작한 후 만나게 되는 20개 벽면들에 대한 위치들은 다음과 같습니다.
 *
 * 1, 19, 20번 벽면은 1행 1열에 있습니다.
 * 2번 벽면은 2행 1열에 있습니다.
 * 3, 4, 5번 벽면은 3행 1열에 있습니다.
 * 6, 7번 벽면은 3행 2열에 있습니다.
 * 8, 9번 벽면은 3행 3열에 있습니다.
 * 10, 16번 벽면은 2행 3열에 있습니다.
 * 11, 12번 벽면은 1행 3열에 있습니다.
 * 13, 14, 15번 벽면은 1행 2열에 있습니다.
 * 17, 18번 벽면은 2행 2열에 있습니다.
 * 1번 벽면부터 20번 벽면까지의 위치 정보(행과 열)들을 차례대로 1차원 배열에 넣는다면 다음과 같습니다.
 *
 * [1,1,2,1,3,1,3,1,3,1,3,2,3,2,3,3,3,3,2,3,1,3,1,3,1,2,1,2,1,2,2,3,2,2,2,2,1,1,1,1]
 * 미로의 행의 개수 rows, 열의 개수 columns, 그리고 미로의 정보를 나타내는 2차원 정수 배열 maze가 매개변수로 주어집니다.
 * 1행 1열의 왼쪽 벽면에서부터 반시계방향으로 미로를 순회하면서,
 * 먼저 만나는 순서대로 각 벽면의 위치를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * rows는 2 이상 200 이하의 정수입니다.
 * columns는 2 이상 200 이하의 정수입니다.
 * maze의 길이(행의 개수)는 rows x columns - 1 입니다.
 * maze의 각 행은 [r1, c1, r2, c2] 4개의 정수로 이루어져 있으며,
 * 이는 (r1행, c1열)의 칸과 (r2행, c2열)의 칸이 벽으로 막히지 않고 연결되어 있음을 나타냅니다.
 * r1, r2는 1 이상 rows 이하인 정수입니다.
 * c1, c2는 1 이상 columns 이하인 정수입니다.
 * (r1행, c1열)과 (r2행, c2열)의 두 칸은 항상 인접해 있습니다.
 * 순회하면서 만날 수 없는 벽면이 존재하는 미로는 입력으로 주어지지 않습니다.
 * 입출력 예
 * rows	columns	maze	result
 * 3	3	[[1,1,2,1],[2,2,2,1],[3,1,2,1],[3,2,2,2],[3,3,3,2],[2,3,1,3],[1,2,1,3],[2,3,3,3]]	[1,1,2,1,3,1,3,1,3,1,3,2,3,2,3,3,3,3,2,3,1,3,1,3,1,2,1,2,1,2,2,3,2,2,2,2,1,1,1,1]
 * 2	2	[[1,1,1,2],[1,2,2,2],[2,2,2,1]]	[1,1,1,1,2,1,2,1,2,1,2,2,2,2,1,2,1,2,1,1]
 * 2	3	[[1,1,2,1],[2,1,2,2],[2,2,2,3],[1,2,2,2],[1,3,1,2]]	[1,1,2,1,2,1,2,2,2,3,2,3,2,3,1,3,1,3,1,3,1,2,1,2,1,1,1,1]
 *
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제 예시와 같습니다.
 * 입출력 예 #2
 *
 * 주어진 입력을 그림으로 표현하면 다음과 같습니다.
 * maze_example_2.png
 * 입출력 예 #3
 *
 * 주어진 입력을 그림으로 표현하면 다음과 같습니다.
 * maze_example_3.png
 *
 */
public class Question04 {

    public static void main(String[] args) {
        Question04 alg = new Question04();

        int[][] test1 = new int[][] {{1,1,2,1},{2,2,2,1},{3,1,2,1},{3,2,2,2},{3,3,3,2},{2,3,1,3},{1,2,1,3},{2,3,3,3}};
        alg.printResult(alg.solution(3,3, test1));
        int[][] test5 = new int[][] {{1,1,2,1},{2,1,2,2},{2,1,3,1},{2,2,3,2},{3,3,3,2},{2,3,1,3},{1,3,1,2},{2,3,3,3}};
        alg.printResult(alg.solution(3,3, test5));
        System.out.println("1,1, 2,1, 3,1, 3,1, 3,1, 3,2, 3,2, 3,3, 3,3, 2,3, 1,3, 1,3, 1,2, 1,2, 1,2, 2,3, 2,2, 2,2, 1,1, 1,1");
        // {1,1,2,1,3,1,3,1,3,1,3,2,3,2,3,3,3,3,2,3,1,3,1,3,1,2,1,2,1,2,2,3,2,2,2,2,1,1,1,1}

        int[][] test2 = new int[][] {{1,1,1,2},{1,2,2,2},{2,2,2,1}};
        alg.printResult(alg.solution(2,2, test2));

        int[][] test4 = new int[][] {{1,2,1,1},{2,2,1,2},{2,1,2,2}};
        alg.printResult(alg.solution(2,2, test4));
        System.out.println("1,1, 1,1, 2,1, 2,1, 2,1, 2,2, 2,2, 1,2, 1,2, 1,1");
        // {1,1, 1,1, 2,1, 2,1, 2,1, 2,2, 2,2, 1,2, 1,2, 1,1}

        int[][] test3 = new int[][] {{1,1,2,1},{2,1,2,2},{2,2,2,3},{1,2,2,2},{1,3,1,2}};
        alg.printResult(alg.solution(2,3, test3));
        System.out.println("1,1, 2,1, 2,1, 2,2, 2,3, 2,3, 2,3, 1,3, 1,3, 1,3, 1,2, 1,2, 1,1, 1,1");
        // {1,1, 2,1, 2,1, 2,2, 2,3, 2,3, 2,3, 1,3, 1,3, 1,3, 1,2, 1,2, 1,1, 1,1}
    }

    public int[] solution(int rows, int columns, int[][] maze) {
        Position[][] pMaze = makeMaze(rows, columns, maze);
//        printMaze(pMaze);

        List<Integer> traversalList = new ArrayList<>();
        traversal(pMaze, traversalList, 1, 0, 0);

        int[] answer = new int[traversalList.size()];
        for (int inx=0; inx<answer.length; inx++) {
            answer[inx] = traversalList.get(inx);
        }
        return answer;
    }

    private Position[][] makeMaze(int rows, int columns, int[][] maze) {
        Position[][] pMaze = new Position[rows][columns];
        for (int inx=0; inx<rows; inx++) {
            for (int jnx=0; jnx<columns; jnx++) {
                Position position = new Position(inx, jnx);
                pMaze[inx][jnx] = position;
            }
        }

        for (int inx=0; inx<maze.length; inx++) {
            int[] row = maze[inx];
            int r1 = row[0], c1 = row[1], r2 = row[2], c2 = row[3];
            if ((r2-r1 == 1) && (c2-c1 == 0)) { // down
                pMaze[r1-1][c1-1].setBottom(false);
                pMaze[r2-1][c2-1].setTop(false);
            } else if ((r2-r1 == 0) && (c2-c1 == 1)) { // right
                pMaze[r1-1][c1-1].setRight(false);
                pMaze[r2-1][c2-1].setLeft(false);
            } else if ((r2-r1 == -1) && (c2-c1 == 0)) { // up
                pMaze[r1-1][c1-1].setTop(false);
                pMaze[r2-1][c2-1].setBottom(false);
            } else if ((r2-r1 == 0) && (c2-c1 == -1)) { // left
                pMaze[r1-1][c1-1].setLeft(false);
                pMaze[r2-1][c2-1].setRight(false);
            }
        }
        return pMaze;
    }

    public boolean traversal(Position[][] pMaze, List<Integer> result, int direction, int row, int column) {
        if ((row < 0 || row >= pMaze.length) || (column < 0 || column >= pMaze[0].length)) {
            return false;
        } else if (pMaze[row][column].getVisitMaze((direction-1)/2)) {
            return false;
        }

        Position pos = pMaze[row][column];
        if (direction == 1 && pos.isLeft()) { // left
            addResult(result, row, column, direction, pos);

            if (traversal(pMaze, result, 3, row, column)
                    || traversal(pMaze, result, 1, row + 1, column)
//                    || traversal(pMaze, result, 7, row + 1, column-1)
                    || traversal(pMaze, result, 5, row, column-1)) {
                return true;
            }
        } else if (direction == 2 && pos.isLeft()) { // left
            addResult(result, row, column, direction, pos);

            if (traversal(pMaze, result, 8, row, column)
                    || traversal(pMaze, result, 2, row - 1, column)
                    || traversal(pMaze, result, 4, row - 1, column - 1)
                    || traversal(pMaze, result, 6, row, column - 1)) {
                return true;
            }
        } else if (direction == 3 && pos.isBottom()) { // bottom
            addResult(result, row, column, direction, pos);

            if (traversal(pMaze, result, 5, row, column)
                    || traversal(pMaze, result, 3, row, column + 1)
                    || traversal(pMaze, result, 1, row + 1, column + 1)
                    || traversal(pMaze, result, 7, row + 1, column)) {
                return true;
            }
        } else if (direction == 4 && pos.isBottom()) { // bottom
            addResult(result, row, column, direction, pos);

            if (traversal(pMaze, result, 2, row, column)
                    || traversal(pMaze, result, 4, row, column - 1)
                   /* || traversal(pMaze, result, 6, row + 1, column - 1)
                    || traversal(pMaze, result, 8, row + 1, column)*/) {
                return true;
            }
        } else if (direction == 5 && pos.isRight()) { // right
            addResult(result, row, column, direction, pos);

            if (traversal(pMaze, result, 7, row, column)
                    || traversal(pMaze, result, 5, row - 1, column)
//                    || traversal(pMaze, result, 3, row - 1, column + 1)
                    || traversal(pMaze, result, 1, row, column + 1)) {
                return true;
            }
        } else if (direction == 6 && pos.isRight()) { // right
            addResult(result, row, column, direction, pos);

            if (traversal(pMaze, result, 4, row, column)
                    || traversal(pMaze, result, 6, row + 1, column)
//                    || traversal(pMaze, result, 8, row + 1, column + 1)
                    || traversal(pMaze, result, 2, row, column + 1)) {
                return true;
            }
        } else if (direction == 7 && pos.isTop()) { // top
            addResult(result, row, column, direction, pos);

            if (traversal(pMaze, result, 1, row, column)
                    || traversal(pMaze, result, 7, row, column - 1)
//                    || traversal(pMaze, result, 5, row - 1, column - 1)
                    || traversal(pMaze, result, 3, row - 1, column)) {
                return true;
            }
        } else if (direction == 8 && pos.isTop()) { // top
            addResult(result, row, column, direction, pos);

            if (traversal(pMaze, result, 6, row, column)
                    || traversal(pMaze, result, 8, row, column + 1)
//                    || traversal(pMaze, result, 2, row - 1, column + 1)
                    || traversal(pMaze, result, 4, row - 1, column)) {
                return true;
            }
        } else {
            return false;
        }

        if (row == 0 && column == 0 /*&& direction == 7*/ && pMaze[0][0].getVisitMaze((direction-1)/2)) {
            return true;
        }
        return false;
    }

    public void addResult(List<Integer> result, int row, int column, int direction, Position pos) {
        result.add(row + 1);
        result.add(column + 1);
        pos.setVisitMaze((direction-1)/2);
    }

    public void printResult(int[] answer) {
        for (int inx=0; inx<answer.length; inx++) {
            System.out.print(answer[inx] + ",");
            if (inx % 2 == 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public void printMaze(Position[][] pMaze) {
        for (int inx=0; inx<pMaze.length; inx++) {
            for (int jnx=0; jnx<pMaze[0].length; jnx++) {
                System.out.println(pMaze[inx][jnx]);
            }
        }
    }
}

class Position {
//    int row;
//    int column;

    boolean left = true;
    boolean right = true;
    boolean top = true;
    boolean bottom = true;

    boolean[] visitMaze = new boolean[4];

    public Position(int x, int y) {
//        this.row = x;
//        this.column = y;
    }

//    public int getRow() {
//        return row;
//    }
//
//    public void setRow(int row) {
//        this.row = row;
//    }
//
//    public int getColumn() {
//        return column;
//    }
//
//    public void setColumn(int column) {
//        this.column = column;
//    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    public boolean getVisitMaze(int direction) {
        return visitMaze[direction];
    }

    public void setVisitMaze(int direction) {
        this.visitMaze[direction] = true;
    }

    //    @Override
//    public String toString() {
//        return "(" + row +
//                "," + column +
//                ") = left=" + left +
//                ", right=" + right +
//                ", top=" + top +
//                ", bottom=" + bottom;
//    }
}
