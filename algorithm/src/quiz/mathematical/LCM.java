package quiz.mathematical;

/**
 * LCM (Least Common Multiple) of two numbers is the smallest number which can be divided by both numbers.
 * For example LCM of 15 and 20 is 60 and LCM of 5 and 7 is 35.
 */
public class LCM {
    public static void main(String[] args) {
        LCM alg = new LCM();
        System.out.println(alg.solution(15, 20));
        System.out.println(alg.solution(5, 7));
//        System.out.println(alg.gcd(6, 18));
    }

    // method to return LCM of two numbers
    public int solution(int a, int b) {
        return (a*b)/gcd(a, b);
    }

    // Recursive method to return gcd of a and b
    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    /*public int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }*/
}
