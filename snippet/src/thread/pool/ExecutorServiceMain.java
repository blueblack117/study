package thread.pool;

import logger.TestLogger;

import java.util.concurrent.*;

public class ExecutorServiceMain {
    public static void main(String[] args) {
        try {

            TestLogger.print(Runtime.getRuntime().availableProcessors());

            createFixedThreadPool();
            createThreadPool();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 정해진 수의 Thread만 사용하는 ThreadPool
     */
    public static void createFixedThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(
                // CPU 코어의 수만큼 최대 스레드를 사용하는 스레드풀을 생성
//                Runtime.getRuntime().availableProcessors()
                3
        );

        Future future = threadPool.submit(new Runnable() {
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
        });
        future.get();

        threadPool.submit(new TestThread());
        threadPool.submit(new TestThread());
        threadPool.submit(new TestThread());
        threadPool.submit(new TestThread());

        // 작업 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀을 종료
        threadPool.shutdown();
    }

    /**
     * 최대 최소 Thread 수, 일정 시간 이상 노는 Thread는 자동으로 제거하는 ThreadPool
     */
    public static void createThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = new ThreadPoolExecutor(
                3,      // 코어 스레드 개수
                100,    // 최대 스레드 개수
                120L,   // 놀고 있는 시간
                TimeUnit.SECONDS,   // 놀고 있는 시간 단위
                new SynchronousQueue<Runnable>()    // 작업 큐
        );

//        Future future = threadPool.submit(new Runnable() {
//            @Override
//            public void run() {
//                // [[처리 로직 또는 다른 메서드 호출]]
//                int count = 100;
//                do {
//                    String threadName = Thread.currentThread().getName();
//                    TestLogger.print(threadName + " :: " + count--);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } while (count > 0);
//            }
//        });

        Future future = threadPool.submit(new TestThread());
        future.get();

        // 작업 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀을 종료
        threadPool.shutdown();
    }
}
