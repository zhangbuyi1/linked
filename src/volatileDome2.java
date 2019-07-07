import java.util.concurrent.atomic.AtomicInteger;

public class volatileDome2 {
    public static void main(String[] args) {
        Ti ti = new Ti();
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    ti.add();
                    ti.myAtomicInteger();

                }



            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();

        }
        System.out.println(Thread.currentThread().getName()+ti.num);
        System.out.println(Thread.currentThread().getName()+ti.atomicInteger);

    }
}
class Ti{
   volatile int num=0;
   public void add(){

       num++;


   }
   AtomicInteger atomicInteger= new AtomicInteger();
   public void myAtomicInteger(){
       atomicInteger.getAndIncrement();


   }



}
