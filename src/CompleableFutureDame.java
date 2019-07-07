import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleableFutureDame {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"沒有返回值");


        });
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {

            System.out.println(Thread.currentThread().getName() + "有返回值");
            int a=10/0;
            return 1000;
        });
        CompletableFuture<Integer> exceptionally = integerCompletableFuture.whenComplete((t, u) -> {
            System.out.println("t=====" + t);
            System.out.println("u=====" + u);

        }).exceptionally(f -> {
            System.out.println("異常為" + f.getMessage());
            return 4000;
        });
        System.out.println(exceptionally.get());


    }
}
