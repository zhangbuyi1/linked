import java.util.UUID;
import java.util.concurrent.*;

public class ContDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> str = new CopyOnWriteArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i <10 ; i++) {
            threadPoolExecutor.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"线程进入");
                    String substring = UUID.randomUUID().toString().substring(0, 8);
                    str.add(substring);
                    countDownLatch.countDown();

                }catch (Exception e){

                }finally {
                    threadPoolExecutor.shutdown();

                }




            });
        }
        countDownLatch.await();
        System.out.println(str);


    }
}
