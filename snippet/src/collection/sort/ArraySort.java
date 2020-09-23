package collection.sort;

import logger.TestLogger;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {
    public static void main(String[] args) {
        UserVo user0 = new UserVo("김김김", "8888-8777", 88);
        UserVo user1 = new UserVo("박박박", "7888-7777", 78);
        UserVo user2 = new UserVo("이이이", "6888-7777", 68);
        UserVo user3 = new UserVo("김김김", "5888-7777", 58);
        UserVo user4 = new UserVo("차차차", "8888-8777", 88);

        UserVo[] userArrOrg = new UserVo[5];
        userArrOrg[0] = user0;
        userArrOrg[1] = user1;
        userArrOrg[2] = user2;
        userArrOrg[3] = user3;
        userArrOrg[4] = user4;

        TestLogger.print("== Original");
        print(userArrOrg);

        UserVo[] userArrTest1 = userArrOrg.clone();
        comparableTest(userArrTest1);

        UserVo[] userArrTest2 = userArrOrg.clone();
        comparatorTest(userArrTest2);

        UserVo[] userArrTest3 = userArrOrg.clone();
        comparatorDescTest(userArrTest3);
    }

    public static void comparableTest(UserVo[] userArr) {
        TestLogger.print("== Comparable Test");

        Arrays.sort(userArr);

        print(userArr);
    }

    /**
     * 1차 : age 기준 오름차순
     * 2차 : name 기준 오름차순
     */
    public static void comparatorTest(UserVo[] userArr) {
        TestLogger.print("== Comparator Test");

        Arrays.sort(userArr, new Comparator<UserVo>() {
            @Override
            public int compare(UserVo value0, UserVo value1) {
                 if (value0.getAge() > value1.getAge()) {
                    return 1;
                 } else if (value0.getAge() < value1.getAge()) {
                    return -1;
                 } else {
                     return value0.getName().compareTo(value1.getName());
                 }
            }
        });

        print(userArr);
    }

    /**
     * 1차 : age 기준 내림차순
     * 2차 : name 기준 오름차순
     */
    public static void comparatorDescTest(UserVo[] userArr) {
        TestLogger.print("== Comparator Test(Desc)");

        Arrays.sort(userArr, new Comparator<UserVo>() {
            @Override
            public int compare(UserVo value0, UserVo value1) {
                if (value0.getAge() < value1.getAge()) {
                    return 1;
                } else if (value0.getAge() > value1.getAge()) {
                    return -1;
                } else {
                    return value0.getName().compareTo(value1.getName());
                }
            }
        });

        print(userArr);
    }

    public static void print(UserVo[] userArr) {
        for (UserVo user : userArr) {
            TestLogger.print(user);
        }
    }
}
