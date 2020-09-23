package quiz.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Budgets {
    public static void main(String[] args) {
        Budgets alg = new Budgets();
        int[] budgets = new int[] {120, 110, 140, 150};
        System.out.println(alg.solution(budgets, 485));
    }

    public int solution(int[] budgets, int M) {
        Arrays.sort(budgets);

        int answer = 0;
        int left = 0;
        int right = budgets[budgets.length-1];
        int middle = 0;
        while (left <= right) {
            long sum = 0;
            middle = (left + right) / 2;
            for (int budget : budgets) {
                if (budget >= middle) {
                    sum += middle;
                } else {
                    sum += budget;
                }
            }
            if (sum > M) {
                right = middle - 1;
            } else {
                answer = middle;
                left = middle + 1;
            }
        }
        return answer;
    }

    // 정확성: 0.0
    //효율성: 0.0
    //합계: 0.0 / 100.0
    public int solution2(int[] budgets, int M) {
        Arrays.sort(budgets);
        List<Integer> budgetList = new ArrayList<>();
        for (int inx=0; inx<budgets.length; inx++) {
            budgetList.add(budgets[inx]);
        }

        int answer = 0;
        IntegerHolder mount = new IntegerHolder(M);
        List<Integer> result = null;
        do {
            result = calculator(budgetList, mount);
            if (result == null) {
                // what to do?
                break;
            } else if (result.size() == 1) {
                answer = result.get(0);
                break;
            } else {
                // repeat
                budgetList = result;
            }
        } while (true);

        return answer;
    }

    public List<Integer> calculator(List<Integer> budgets, IntegerHolder mount) {
        int sum = 0;
        for (int inx=0; inx<budgets.size(); inx++) {
            sum += budgets.get(inx);
        }
        int avg = sum / budgets.size();
        if (sum <= mount.getInteger()) {
            return null;
        } else if (budgets.size() <= 2) {
            List<Integer> result = new ArrayList<Integer>() ;
//            result.add(avg);
            result.add(mount.getInteger()/2);
            return result;
        }

        List subArray = new ArrayList();
        for (int inx=0; inx<budgets.size(); inx++) {
            if (budgets.get(inx) > avg) {
                subArray.add(budgets.get(inx));
            } else {
                mount.subInteger(budgets.get(inx));
            }
        }
        return subArray;
    }

}

class IntegerHolder {
    int integer;

    public IntegerHolder(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public void subInteger(int integer) {
        this.integer -= integer;
    }
}
