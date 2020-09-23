package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// https://palpit.tistory.com/732
public class Execute {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);

                    int value = Integer.parseInt("숫자");
                }
            };

            // execute() : 작업 처리 도중 예외가 발생하여 해당 스레드는 제거되고 새 스레드를 생성했기 때문
            // submit() : 예외가 발생하더라도 스레드는 종료되지 않고 계속 재사용되어 다른 작업을 처리하고 있는 것

//            executorService.execute(runnable);
            executorService.submit(runnable);

            Thread.sleep(10);
        }
        executorService.shutdown();

    }
}
