import java.util.concurrent.*;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                Runtime.getRuntime().availableProcessors(),
                3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {

            System.out.println("文哥来了");

        });
        for (int i = 0; i <5 ; i++) {
            threadPoolExecutor.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"等文哥");
                    cyclicBarrier.await();

                }catch (Exception e){

                }finally {
                    threadPoolExecutor.shutdown();

                }
            });





        }


    }
}
