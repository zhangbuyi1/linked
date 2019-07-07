import java.util.concurrent.*;

public class SemaPhoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 8; i++) {

            threadPoolExecutor.execute(()->{
                try {

                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"进入程序");
                        Thread.sleep(200);
                        System.out.println(Thread.currentThread().getName()+"结束");

                }catch (Exception e){

                }finally {
                 semaphore.release();
                 threadPoolExecutor.shutdown();
                }


            });

        }

    }
}
