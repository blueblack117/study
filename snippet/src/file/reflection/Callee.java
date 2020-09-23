package file.reflection;

public class Callee {
    // 생성자
    public Callee() { }

    // 함수 생성
    public void print() {
        // 콘솔 출력
        System.out.println("Hello world");
    }

    @Override
    public String toString() {
        return "toString() Hello world";
    }
}
