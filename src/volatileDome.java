public class volatileDome {
    public static void main(String[] args) {
        data data = new data();

        new Thread(()->{
              System.out.println("当前线程为"+Thread.currentThread().getName()+data.num);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.add();
            System.out.println(Thread.currentThread().getName()+"线程"+data.num);


          },"aaa").start();
        while(data.num==0){


        }
        System.out.println(Thread.currentThread().getName()+"线程"+data.num);

    }
}
class data{
    volatile int  num=0;
    public void add(){

        this.num=60;
    }



}