import java.util.concurrent.TimeUnit;

public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Resource5 resource5 = new Resource5();
        Resource5 resource51 = new Resource5();
                 new Thread(() -> {resource51.email();},"A").start();
                new Thread(() -> {resource5.sms();},"B").start();
                // new Thread(() -> {resource5.hello();},"C").start();


        }




    }


class Resource5{
    public synchronized  void sms(){
        try {
            //Thread.sleep(4000);
        }catch (Exception e){

        }finally {

        }
        System.out.println(Thread.currentThread().getName()+"sms");

    }

    public synchronized void email(){
         System.out.println(Thread.currentThread().getName()+"email");

     }
     public void hello(){

         System.out.println(Thread.currentThread().getName()+"hello");

     }



}