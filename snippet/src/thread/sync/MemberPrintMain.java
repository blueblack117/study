package thread.sync;

/**
 * 쓰레드와 자원 공유 - 멤버필드
 * 세 개의 쓰레드가 멤버 필드 하나를 공유하게 만들자
 * 멤버 필드를 공유하는 경우를 알아본다.
 * 같은 자원(같은 객체의 멤버 필드)을 여러 개의 쓰레드가 공유할 수 있다.
 *
 * 여러 개의 쓰레드에서 한 객체의 멤버 필드를 사용하려는 경우
 * 여러 개의 쓰레드에서 동일 타입으로 생성된 객체의 스태릭 필드를 사용하려는 경우
 */
public class MemberPrintMain {
    public static void main(String[] args) {
        MemberPrint mr1 = new MemberPrint();
        Thread t1 = new Thread(mr1, "a");
        Thread t2 = new Thread(mr1, "b");
        Thread t3 = new Thread(mr1, "c");
        t1.start();
        t2.start();
        t3.start();
    }
}
