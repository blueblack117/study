package edu.thread.threadpool;

import java.util.concurrent.*;

/**
 * 3개의 Callable 작업을 처리 요청하고 처리가 완료되는 순으로 작업의 결과값을 출력
 */
public class CompleteResultService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        // CompleteResultService 생성
        CompletionService<Integer> completionService =
                new ExecutorCompletionService<>(executorService);

        System.out.println("처리 요청");

        for (int i = 0; i < 3; i++) {
            completionService.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    int sum = 0;

                    for (int i = 1; i <= 10; i++) {
                        sum += i;
                    }

                    return sum;
                }
            });
        }

        System.out.println("처리 완료된 작업 확인");
        executorService.submit(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Future<Integer> future = completionService.take();
                        int value = future.get();
                        System.out.println("처리 결과: " + value);
                    } catch (Exception e) {break;}
                }
            }
        });

        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        executorService.shutdownNow();
    }
}
