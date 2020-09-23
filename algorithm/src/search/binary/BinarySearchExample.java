package search.binary;

import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {

        //기본 타입값 검색
        int[] scores = {99, 97, 98};
        Arrays.sort(scores);
        int index = Arrays.binarySearch(scores, 99);
        System.out.println("찾은 인덱스: " + index);

        //문자열 검색
        String[] names = {"티스토리", "블로그", "알통몬"};
        Arrays.sort(names);
        index = Arrays.binarySearch(names, "알통몬");
        System.out.println("찾은 인덱스: " + index);

        //객체 검색
        Member m1 = new Member("티스토리");
        Member m2 = new Member("블로그");
        Member m3 = new Member("알통몬");
        Member[] members = {m1, m2, m3};
        Arrays.sort(members);
        index = Arrays.binarySearch(members, m1);
        System.out.println("찾은 인덱스: " + index);
    }
}

class Member implements Comparable<Member> {

    String name;

    Member(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Member o){
        return name.compareTo(o.name);
        // 리턴 값은 오름 차순일 때 자신이 매개 값보다 낮을 경우 음수, 같을 경우 0, 높을 경우 양수를 리턴하도록 하고,
        // 내림 차순일 경우 반대로 하면 됩니다.
    }
}