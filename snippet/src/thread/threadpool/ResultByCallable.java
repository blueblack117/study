package thread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 1부터 10까지의 합을 리턴하는 작업을 Callable 객체로 생성하고, 스레드풀의 스레드가 처리하는 예제
 */
public class ResultByCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        System.out.println("[작업 처리 요청]");
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;

                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }

                return sum;
            }
        };

        Future<Integer> future = executorService.submit(task);

        try {
            int sum = future.get();
            System.out.println("[처리 결과] : " + sum);
            System.out.println("[작업 처리 완료]");
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
