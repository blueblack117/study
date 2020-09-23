package structure.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {

    public static void main(String[] args) {
        String[] names = {"AAA~", "BBB~", "COOL", "DiDiDi"};

        // 원본 배열 출력
        System.out.println(Arrays.toString(names));

        // 배열을 리스트로 변환
        List<String> list = Arrays.asList(names);

        // 리스트 뒤집어 주기
        Collections.reverse(list);

        // 리스트를 배열로 다시 변환
        names = list.toArray(new String[list.size()]);

        // 순서 뒤집어진 배열을 문자열로 변환 후 출력
        String s = Arrays.toString(names);
        System.out.println(s);
    }
}
