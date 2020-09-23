package collection.sort;

import java.io.Serializable;

public class UserVo implements Comparable<UserVo>, Serializable {
    private int age;
    private String name;
    private String id;

    public UserVo() {
    }

    public UserVo(String name, String id, int age) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 1차 : id 기준 오름차순
     * 2차 : name 기준 내림차순
     */
    @Override
    public int compareTo(UserVo o) {
        // id asc
        if (this.id.compareTo(o.getId()) > 0) {
            return 1;
        } else if (this.id.compareTo(o.getId()) < 0) {
            return -1;
        } else {
            // name asc
//            return this.name.compareTo(o.getName());

            // name desc
            if (this.name.compareTo(o.getName()) < 0) {
                return 1;
            } else if (this.name.compareTo(o.getName()) > 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "name=" + name +
                ", age='" + age + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
