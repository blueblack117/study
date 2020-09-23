package quiz.test.no01;

import java.util.ArrayList;
import java.util.List;

//https://algs4.cs.princeton.edu/41graph/Maze.java.html
public class Maze2 {            // dimension of maze
    private boolean[][] north;     // is there a wall to north of cell i, j
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;
    private boolean done = false;
    int rows;
    int columns;

    public static void main(String[] args) {
        Maze2 alg = new Maze2();

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
        makeMaze(rows, columns, maze);

        List<Integer> traversalList = new ArrayList<>();
        for (int x = 1; x <= rows; x++)
            for (int y = 1; y <= columns; y++)
                visited[x][y] = false;
        done = false;
        solve(traversalList, 1, 1);

        int[] answer = new int[traversalList.size()];
        for (int inx=0; inx<answer.length; inx++) {
            answer[inx] = traversalList.get(inx);
        }
        return answer;
    }

    private void init() {
        // initialize border cells as already visited
        visited = new boolean[rows+2][columns+2];
        for (int x = 0; x < rows+2; x++) {
            visited[x][0] = true;
            visited[x][rows+1] = true;
        }
        for (int y = 0; y < columns+2; y++) {
            visited[0][y] = true;
            visited[rows+1][y] = true;
        }

        // initialze all walls as present
        north = new boolean[rows+2][columns+2];
        east  = new boolean[rows+2][columns+2];
        south = new boolean[rows+2][columns+2];
        west  = new boolean[rows+2][columns+2];
        for (int x = 0; x < rows+2; x++) {
            for (int y = 0; y < columns+2; y++) {
                north[x][y] = true;
                east[x][y]  = true;
                south[x][y] = true;
                west[x][y]  = true;
            }
        }
    }

    private void makeMaze(int rows, int columns, int[][] maze) {
        this.rows = rows;
        this.columns = columns;
        init();
        for (int inx=0; inx<maze.length; inx++) {
            int[] row = maze[inx];
            int r1 = row[0], c1 = row[1], r2 = row[2], c2 = row[3];
            if ((r2-r1 == 1) && (c2-c1 == 0)) { // down
                south[r1][c1] = false;
                north[r2][c2] = false;
            } else if ((r2-r1 == 0) && (c2-c1 == 1)) { // right
                east[r1][c1] = false;
                west[r2][c2] = false;
            } else if ((r2-r1 == -1) && (c2-c1 == 0)) { // up
                north[r1][c1] = false;
                south[r2][c2] = false;
            } else if ((r2-r1 == 0) && (c2-c1 == -1)) { // left
                west[r1][c1-1] = false;
                east[r2][c2] = false;
            }
        }
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

    public void addResult(List<Integer> result, int row, int column) {
        result.add(row + 1);
        result.add(column + 1);
    }

    // solve the maze using depth-first search
    private void solve(List<Integer> traversalList, int x, int y) {
        if (x == 0 || y == 0 || x == rows+1 || y == columns+1) return;
        if (done || visited[x][y]) return;

        visited[x][y] = true;
        addResult(traversalList, x, y);

        // reached middle
        if (x == rows/2 && y == columns/2) done = true;

        if (!north[x][y]) solve(traversalList, x, y + 1);
        if (!east[x][y])  solve(traversalList, x + 1, y);
        if (!south[x][y]) solve(traversalList, x, y - 1);
        if (!west[x][y])  solve(traversalList, x - 1, y);

        if (done) return;
    }
}
