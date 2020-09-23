package collection.sort;

import logger.TestLogger;

import java.util.*;

public class MapSort {
    public static void main(String[] args) {
        UserVo user0 = new UserVo("김김김", "8888-8777", 88);
        UserVo user1 = new UserVo("박박박", "7888-7777", 78);
        UserVo user2 = new UserVo("이이이", "6888-7777", 68);
        UserVo user3 = new UserVo("김아아", "5888-7777", 58);
        UserVo user4 = new UserVo("차차차", "8888-8777", 88);

        Map<String, UserVo> hashMap = new HashMap<>();
        hashMap.put(user0.getName(), user0);
        hashMap.put(user1.getName(), user1);
        hashMap.put(user2.getName(), user2);
        hashMap.put(user3.getName(), user3);
        hashMap.put(user4.getName(), user4);

        TestLogger.print("== HashMap");
        print(hashMap);

        TestLogger.print("== HashMap - sort key result");
        List<UserVo> resultList = getSortedList(hashMap);
        print(resultList);

        SortedMap<String, UserVo> sortedMap = new TreeMap<>();
        sortedMap.put(user0.getName(), user0);
        sortedMap.put(user1.getName(), user1);
        sortedMap.put(user2.getName(), user2);
        sortedMap.put(user3.getName(), user3);
        sortedMap.put(user4.getName(), user4);

        TestLogger.print("== TreeMap");
        print(sortedMap);
    }

    public static List<UserVo> getSortedList(Map<String, UserVo> map) {
        List<UserVo> userList = new ArrayList<UserVo>();
        String[] keys = map.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        for (String key: keys) {
            userList.add(map.get(key));
        }
        return userList;
    }

    public static void print(Map<String, UserVo> map) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            TestLogger.print(map.get(key));
        }
    }

    public static void print(List<UserVo> userList) {
        for (UserVo user : userList) {
            TestLogger.print(user);
        }
    }
}
