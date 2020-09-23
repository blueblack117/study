package thread.threadpool;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletionHandler
 * - completed(): 작업을 정상 처리 완료했을 때 호출되는 콜백 메소드
 * - failed(): 작업 처리 도중 예외가 발생했을 때 호출되는 콜백 메소드
 */
public class Callback {
    private ExecutorService executorService;
    private CompletionHandler<Integer, Void> callback =
            new CompletionHandler<Integer, Void>() {

                @Override
                public void completed(Integer result, Void attachment) {
                    System.out.println("completed() 실행: " + result);
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    System.out.println("failed() 실행: " + exc.toString());
                }

            };

    public Callback() {
        executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
    }

    public static void main(String[] args) {
        Callback exam = new Callback();
        exam.doWork("4", "7");
        exam.doWork("4", "자바");
        exam.finish();
    }

    public void doWork(final String x, final String y) {
        Runnable task = new Runnable() {
            public void run() {
                try {
                    int intX = Integer.parseInt(x);
                    int intY = Integer.parseInt(y);

                    int result = intX + intY;
                    callback.completed(result, null);

                } catch (NumberFormatException e) {
                    callback.failed(e, null);
                }
            }
        };
        executorService.submit(task);
    }

    public void finish() {
        executorService.shutdown();
    }
}
