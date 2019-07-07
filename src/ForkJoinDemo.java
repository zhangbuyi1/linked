import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    public static void main(String[] args) throws Exception {
        TaskDemo task = new TaskDemo(0, 20);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
        System.out.println(submit.get());
        forkJoinPool.shutdown();


    }




}
class TaskDemo extends RecursiveTask<Integer>{
    private static final  Integer ADJUST_VALUE=10;
    private int fast;
    private int end;
    private int result;


    public TaskDemo( int fast,int end){
        this.fast=fast;
        this.end=end;

    }




    @Override
    protected Integer compute() {

        if((end-fast)<=ADJUST_VALUE){
            for (int i = fast; i <=ADJUST_VALUE ; i++) {
                result+=i;
            }
        }else {
            int test=(end-fast)/2;
            TaskDemo task = new TaskDemo(fast, test);
            TaskDemo task1 = new TaskDemo(test + 1, end);
            task.fork();
            task1.fork();
            result=task1.join()+task.join();


        }


        return result;
    }
}
