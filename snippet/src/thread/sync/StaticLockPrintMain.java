package thread.sync;

/**
 * 쓰레드와 자원 공유 - 동기화
 * 여러 개의 쓰레드에서 같은 자원을 동시에 사용할 수 없게 만들자.
 * 동기화(Synchronized) 이유와 사용법을 배운다.
 * synchronized 키워드를 사용한다.
 */
public class StaticLockPrintMain {
    public static void main(String[] args) {
        StaticLockPrint mr1 = new StaticLockPrint();
        StaticLockPrint mr2 = new StaticLockPrint();
        StaticLockPrint mr3 = new StaticLockPrint();
        Thread t1 = new Thread(mr1, "a");
        Thread t2 = new Thread(mr2, "b");
        Thread t3 = new Thread(mr3, "c");
        t1.start();
        t2.start();
        t3.start();
    }
}
