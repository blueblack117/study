package structure.array;

public class MedianTest {
    // Returns mean of a given
// matrix of size n x n.
    static double findMean(int a[][], int n) {
        int sum = 0;
        int N = n;

        // total sum calculation of matrix
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                sum += a[i][j];

        return (double) sum / (N * N);
    }

    // Function for calculating median
    static double findMedian(int a[][], int n) {
        int N = n;

        if (N % 2 != 0)
            return a[N / 2][N / 2];

        if (N % 2 == 0)
            return (a[(N - 2) / 2][N - 1] +
                    a[N / 2][0]) / (2.0);
        return 0;
    }

    // Function for calculating median
    static void findMedian(int a[][], int x, int y, int mask) {
        int M = a[0].length;
        int N = a.length;
        int m = M / mask;
        int n = N / mask;

        // 기본식은 m=M/5, n=N/5,
        // 5*5 배열에서 (x, y)에 해당하는 중앙값 계산
        double x_mid = m * x + m / 2.0;
        double y_mid = n * y + n / 2.0;

        System.out.println("x_mid = " + x_mid);
        System.out.println("y_mid = " + y_mid);
    }

    // Driver Code
    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int n = a.length;
        System.out.println("Mean   : " + findMean(a, n));
        System.out.println("Median : " + findMedian(a, n));

        int b[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        findMedian(b, 0, 1, 5);
    }
}
