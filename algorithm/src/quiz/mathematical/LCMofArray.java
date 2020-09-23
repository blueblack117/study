package quiz.mathematical;

/**
 * LCM of given array elements
 *
 * Input : {1, 2, 8, 3}
 * Output : 24
 *
 * Input : {2, 7, 3, 9, 4}
 * Output : 252
 */
public class LCMofArray {
    public static void main(String[] args) {
        LCMofArray alg = new LCMofArray();

        int[] arr = new int[] {2,6,8,14};
        System.out.println(alg.solution(arr));

        int[] arr2 = new int[] {1,2,3};
        System.out.println(alg.solution(arr2));
    }

    public int solution(int[] arr) {
        int answer = 0;
        answer = lcm(arr[0], arr[1]);
        for (int inx=2; inx<arr.length; inx++) {
            answer = lcm(answer, arr[inx]);
        }
        return answer;
    }

    // Recursive method to return gcd of a and b
    public int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    public int lcm(int a, int b)
    {
        return (a*b)/gcd(a, b);
    }
}
