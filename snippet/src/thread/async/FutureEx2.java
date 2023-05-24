package thread.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureEx2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("START");

        ExecutorService es = Executors.newCachedThreadPool();
        FutureTask<String> f = new FutureTask<String>(()->{
            Thread.sleep(2000);
            System.out.println("Async");
            return "Hello";
        }) { //비동기 작업이 모두 완료되면 호출되는 hook같은 것.
            @Override
            protected void done() {
                try {
                    System.out.println(get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        es.execute(f);
        es.shutdown(); //이 메서드를 쓰더라도 하던 작업이 중단되지는 않음

        System.out.println("END");
    }
}
