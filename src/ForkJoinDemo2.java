import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo2 {

    public static void main(String[] args) {





    }


}
class Resource9 extends RecursiveTask{

    private final int TASK_TEST=10;
    private int fost;
    private int end;
    private int test;
    public Resource9(Integer fost,Integer end){




    }


  @Override
    protected Object compute() {
        new ArrayBlockingQueue<>(3);
        if(end<=TASK_TEST){
            for(int i=0;i<end;i++){
                test+=i;

            }



        }




        return null;
    }
}
