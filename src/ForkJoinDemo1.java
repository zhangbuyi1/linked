import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task1 task12 = new Task1(0, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit11 = forkJoinPool.submit(task12);
        System.out.println(submit11.get());
        forkJoinPool.shutdown();


    }



}

class Task1 extends RecursiveTask<Integer>{
    private static  final Integer TASK_NUM=10;
    private int fast;
    private int end;
    private  int result;



    public Task1(int fast,int end){
        this.fast=fast;
        this.end=end;


    }


    @Override
    protected Integer compute() {
        if((end-fast)<=TASK_NUM){
            for (int i = fast; i <=end; i++) {
                result=result+i;



            }
        }else {
            int test=(fast+end)/2;

            Task1 task1 = new Task1(fast, test);
            Task1 task11 = new Task1(test + 1, end);
            System.out.println(test);
            task1.fork();
            task11.fork();
            result=task11.join()+task1.join();



        }



        return result;
    }
}
