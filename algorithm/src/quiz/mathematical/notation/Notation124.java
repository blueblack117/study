package quiz.mathematical.notation;

public class Notation124 {
    public static void main(String[] args) {
        Notation124 alg = new Notation124();
//        System.out.println(alg.solution(4));
//        System.out.println(alg.solution(12));
        System.out.println(alg.solution(13));
//        System.out.println(alg.solution(40));
//        System.out.println(alg.solution(41));
    }

    public String solution(int n) {
        int length = 1;
        int cal = 0;
        int precal = 0;
        while(true) {
            cal += Math.pow(3, length);
            if (n <= cal)
                break;
            length++;
            precal = cal;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=length; i++) {
            int slice = (cal-precal)/3;
            if(n > precal+slice*2) {
                sb.append("4");
                precal = precal+slice*2;
            } else if (n > precal+slice) {
                sb.append("2");
                cal = precal+slice*2;
                precal = precal+slice;
            } else {
                sb.append("1");
                cal = precal+slice;
            }
        }
        return sb.toString();
    }
}
