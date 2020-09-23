package thread.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 리턴값이 없고 단순히 1부터 10까지의 합을 출력하는 작업을 Runnable 객체로 생성하고 스레드 풀의 스레드가 처리하도록 요청하는 예제
 */
public class NoResult {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        System.out.println("[작업 처리 요청]");

        Runnable run = new Runnable() {
            @Override
            public void run() {
                int sum = 0;

                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }

                System.out.println("[처리 결과] : " + sum);
            }
        };

        Future future = executorService.submit(run);

        try {
            future.get();
            System.out.println("[작업 처리 완료]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
