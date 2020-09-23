package thread.pool;

import logger.TestLogger;

public class TestThread implements Runnable {

    @Override
    public void run() {
        // [[처리 로직 또는 다른 메서드 호출]]
        String threadName = Thread.currentThread().getName();
        int count = 100;
        do {
            TestLogger.print(threadName + " :: " + count--);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (count > 0);
    }
}
