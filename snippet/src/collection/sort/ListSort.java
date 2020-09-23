package collection.sort;

import logger.TestLogger;

import java.util.*;

public class ListSort {
    public static void main(String[] args) {
        UserVo user0 = new UserVo("김김김", "8888-8777", 88);
        UserVo user1 = new UserVo("박박박", "7888-7777", 78);
        UserVo user2 = new UserVo("이이이", "6888-7777", 68);
        UserVo user3 = new UserVo("김김김", "5888-7777", 58);
        UserVo user4 = new UserVo("차차차", "8888-8777", 88);

        List<UserVo> userList = new ArrayList<UserVo>();
        userList.add(user0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        TestLogger.print("== Original");
        print(userList);

        List<UserVo> userListTest1 = new ArrayList<UserVo>(userList.size());
//        Collections.copy(userListTest1, userList);
        userListTest1.addAll(userList);
        comparableTest(userListTest1);

        List<UserVo> userListTest2 = new ArrayList<UserVo>(userList.size());
        userListTest2.addAll(userList);
        comparatorTest(userListTest2);

        List<UserVo> userListTest3 = new ArrayList<UserVo>(userList.size());
        userListTest3.addAll(userList);
        comparatorDescTest(userListTest3);
    }

    public static void comparableTest(List<UserVo> userList) {
        TestLogger.print("== Comparable Test");

        Collections.sort(userList);

        print(userList);
    }

    /**
     * 1차 : age 기준 오름차순
     * 2차 : name 기준 오름차순
     */
    public static void comparatorTest(List<UserVo> userList) {
        TestLogger.print("== Comparator Test");

        Collections.sort(userList, new Comparator<UserVo>() {
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

        print(userList);
    }

    /**
     * 1차 : age 기준 내림차순
     * 2차 : name 기준 오름차순
     */
    public static void comparatorDescTest(List<UserVo> userList) {
        TestLogger.print("== Comparator Test(Desc)");

        Collections.sort(userList, new Comparator<UserVo>() {
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

        print(userList);
    }

    public static void print(List<UserVo> userList) {
        for (UserVo user : userList) {
            TestLogger.print(user);
        }
    }
}
