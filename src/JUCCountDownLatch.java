import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class JUCCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(9);


        for (int i = 0; i < 9; i++) {
            new Thread(() ->{
                String substring = UUID.randomUUID().toString().substring(0, 8);
                list.add(substring);
                countDownLatch.countDown();
                },i+""

            ).start();
        }

        countDownLatch.await();
        System.out.println(list);


    }

}
