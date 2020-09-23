package edu.sort;

import utils.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        TestVo vo1 = new TestVo("s1", "s2", 3);
        TestVo vo2 = new TestVo("s11", "s266", 3);
        TestVo vo3 = new TestVo("s11", "s22", 2);
        TestVo vo4 = new TestVo("r2", "22", 5);
        TestVo vo5 = new TestVo("w3", "52", 6);

        List<TestVo> list = new ArrayList<>();
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        list.add(vo4);
        list.add(vo5);

        Logger.print("org list");
        Logger.print(list);

        Collections.sort(list, new Comparator<TestVo> (){
            @Override
            public int compare(TestVo p1, TestVo p2) {
                if (p1.getIntVal() > p2.getIntVal()) {
                    return 1; // intVal 에 대해서는 오름차순
                } else if (p1.getIntVal() < p2.getIntVal()) {
                    return -1;
                } else {
                    if (p1.getStr1().compareTo(p2.getStr1()) > 0) {
                        return 1; // Str1 에 대해서는 오름차순
                    } else if (p1.getStr1().compareTo(p2.getStr1()) < 0) {
                        return -1;
                    }
                }
                return -1;
            }
        });

        Logger.print("sort asc list");
        Logger.print(list);
    }
}
