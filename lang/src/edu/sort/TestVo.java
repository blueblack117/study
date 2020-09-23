package edu.sort;

public class TestVo implements Comparable<TestVo>{
    private String str1;
    private String str2;
    private int intVal;

    public TestVo(String str1, String str2, int intVal) {
        this.str1 = str1;
        this.str2 = str2;
        this.intVal = intVal;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    @Override
    public int compareTo(TestVo o) {
        if (this.str1.compareTo(o.getStr1()) > 0) {
            return 1; // Str1 에 대해서는 오름차순
        } else if (this.str1.compareTo(o.getStr1()) < 0) {
            return -1;
        } else {
            if (this.str2.compareTo(o.getStr2()) > 0) {
                return 1; // Str2 에 대해서는 오름차순
            } else if (this.str2.compareTo(o.getStr2()) < 0) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "TestVo{" +
                "str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", intVal=" + intVal +
                '}';
    }
}
