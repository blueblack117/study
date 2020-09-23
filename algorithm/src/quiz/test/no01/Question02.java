package quiz.test.no01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 당신에게 학생들의 이름, 거주지역 좌표, GPA가 주어집니다.
 * 다음의 우선순위에 따라 학생들에게 기숙사 배정순위를 부여해주세요.
 *
 * GPA의 앞자리가 높을수록 배정순위가 높습니다.
 * 예를 들어, GPA가 3.9인 학생과 4.1인 학생 중에서는 4.1이 배정순위가 더 높습니다.
 * 하지만 GPA가 3.9인 학생과 GPA가 3.7인 학생은 GPA에서 순위가 갈리지 않고 다른 기준에서 갈리게 됩니다.
 * GPA의 앞자리가 동일한 학생들끼리는, 학교에서부터 거주지역까지의 직선거리가 더 먼 학생이 배정순위가 더 높습니다. 학교의 좌표는 (0, 0)입니다.
 * 예를 들어, (2, 3)에 사는 학생보다 (1, 4)에 사는 학생의 배정순위가 더 높습니다.
 * GPA의 앞자리, 학교와 거주지역 사이의 거리가 둘 다 동일한 학생들끼리는 이름이 사전 순으로 더 빠를수록 배정순위가 더 높습니다.
 * 예를 들어, azad의 배정순위가 daza의 배정순위 보다 더 높습니다.
 * 가장 배정순위가 높은 사람의 순위는 1이고, 그 뒤로 2, 3, 4,... 순위를 배정받습니다.
 *
 * 학생들의 이름이 담긴 문자열 배열 names, 거주지역의 좌표가 담긴 2차원 정수 배열 homes, 그리고 GPA가 담긴 실수 배열 grades가 매개변수로 주어집니다.
 * 각 학생별로 받을 배정순위를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * names의 길이는 1 이상 100,000 이하입니다.
 * names[i] 는 i+1번째 학생의 이름을 의미합니다.
 * names의 각 원소는 영어 소문자로 이루어져 있으며, 길이는 1 이상 30 이하입니다.
 * 동명이인은 존재하지 않습니다.
 * homes의 길이는 names의 길이와 같습니다.
 * homes[i] 는 i+1번째 학생의 거주지역 좌표를 의미합니다.
 * homes의 각 원소는 [x, y] 2개의 정수로 이루어져 있으며, 이는 해당 학생의 거주지역 좌표를 의미합니다.
 * x, y는 -10,000 이상 10,000 이하의 정수입니다.
 * 같은 좌표에 사는 학생들이 여러 명 있을 수도 있습니다.
 * grades의 길이는 names의 길이와 같습니다.
 * grades[i] 는 i+1번째 학생의 GPA를 의미합니다.
 * grades의 각 원소는 1.0 이상 4.5 이하의 실수이며, 소수점 아래 자리 수는 최대 2자리입니다.
 *
 *
 *
 * 입출력 예
 * names	homes	grades	result
 * ["azad","andy","louis","will","edward"]	[[3,4}, {-1,5}, {-4,4}, {3,4}, {-5,0]]	[4.19, 3.77, 4.41, 3.65, 3.58]	[2,3,1,5,4]
 * ["clanguage","csharp","java","python"]	[[3,-3}, {-2,7}, {-1,-1}, {5,4]]	[1.27, 4.31, 4.26, 3.99]	[4,1,2,3]
 * ["zzzzzzzzzz"]	[[9999,-9999]]	[1.0]	[1]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 학생들에게 주어진 기준에 따라 순위를 배정하면 다음과 같습니다.
 * GPA	GPA 앞자리	거주 지역	학교까지의 거리의 제곱	이름	순위
 * 4.41	4	(-4, 4)	32	louis	1
 * 4.19	4	(3, 4)	25	azad	2
 * 3.77	3	(-1, 5)	26	andy	3
 * 3.58	3	(-5, 0)	25	edward	4
 * 3.65	3	(3, 4)	25	will	5
 * louis와 azad가 GPA의 앞자리가 4로 가장 높으므로, 두 사람이 1~2순위를 나눠갖습니다.
 * louis가 학교에서 더 먼 곳에 살고 있으므로, louis가 1순위, azad가 2순위를 갖습니다.
 * andy, edward, will이 GPA 앞자리가 3이므로, 세 사람이 3~5순위를 나눠갖습니다.
 * andy가 학교에서 가장 먼 곳에 살고 있으므로, andy가 3순위입니다.
 * edward와 will은 학교에서부터 동일한 거리에서 살고 있으므로, 이름을 비교하여 사전 순서로 앞인 edward가 4순위를, 뒤인 will이 5순위를 갖습니다.
 * 입출력 예 #2
 *
 * 학생들에게 주어진 기준에 따라 순위를 배정하면 다음과 같습니다.
 * GPA	GPA 앞자리	거주 지역	학교까지의 거리의 제곱	이름	순위
 * 4.31	4	(-2, 7)	53	csharp	1
 * 4.26	4	(-1, -1)	2	java	2
 * 3.99	3	(5, 4)	41	python	3
 * 1.27	1	(3, -3)	18	clanguage	4
 * 입출력 예 #3
 *
 * 이 예시에서는 학생의 수가 1명이므로, 그 학생은 항상 1순위입니다.
 */
public class Question02 {

    public static void main(String[] args) {
        Question02 alg = new Question02();

        String[] names1 = new String[] {"azad","andy","louis","will","edward"};
        int[][] homes1 = new int[][] {{3,4}, {-1,5}, {-4,4}, {3,4}, {-5,0}};
        double[] grades1 = new double[] {4.19, 3.77, 4.41, 3.65, 3.58};
        alg.printResult(alg.solution(names1, homes1, grades1));

        String[] names2 = new String[] {"clanguage","csharp","java","python"};
        int[][] homes2 = new int[][] {{3,-3}, {-2,7}, {-1,-1}, {5,4}};
        double[] grades2 = new double[] {1.27, 4.31, 4.26, 3.99};
        alg.printResult(alg.solution(names2, homes2, grades2));

        String[] names3 = new String[] {"zzzzzzzzzz"};
        int[][] homes3 = new int[][] {{9999,-9999}};
        double[] grades3 = new double[] {1.0};
        alg.printResult(alg.solution(names3, homes3, grades3));
    }

    public int[] solution(String[] names, int[][] homes, double[] grades) {
        List<Person> list = new ArrayList<>();
        for (int inx=0; inx<names.length; inx++) {
            Person person = new Person(names[inx], homes[inx], grades[inx]);
            person.setIndex(inx);
            list.add(person);
        }

        Collections.sort(list);

        int[] answer = new int[names.length];
        for (int inx=0; inx<answer.length; inx++) {
            answer[list.get(inx).getIndex()] = inx+1;
        }
        return answer;
    }

    public void printResult(int[] answer) {
        for (int inx=0; inx<answer.length; inx++) {
            System.out.print(answer[inx] + ",");
        }
        System.out.println();
    }
}

class Person implements Comparable<Person> {

    int index;
    String name;
    int[] home;
    double grade;
    double distance;

    public Person(String name, int[] home, double grade) {
        this.name = name;
        this.home = home;
        this.grade = grade;
        calDistance();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getHome() {
        return home;
    }

    public void setHome(int[] home) {
        this.home = home;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Person o) {
        if ((int)this.grade > (int)o.getGrade()) {
            return -1;
        } else if ((int)this.grade < (int)o.getGrade()) {
            return 1;
        } else {
            if (this.getDistance() > o.getDistance()) {
                return -1;
            } else if (this.getDistance() < o.getDistance()) {
                return 1;
            } else {
                return this.name.compareTo(o.getName());
            }
        }
    }

    private void calDistance() {
        distance = Math.sqrt(Math.pow(Math.abs(home[0]-0), 2) + Math.pow(Math.abs(home[1]-0), 2));
    }
}