import java.util.TreeMap;

public class SingletonDome {
    //保证可见性，不保证原子性，禁止指令重排，Atomic可以解决原子性
    public static volatile SingletonDome instence =null;
    private SingletonDome(){
        System.out.println("构造器被调用"+Thread.currentThread().getName());


    }
    public static SingletonDome getInstance(){
        if(instence ==null){
            synchronized (SingletonDome.class) {
                if(instence==null) {
                    instence = new SingletonDome();
                }
            }
        }

     return instence;
    }



    public static void main(String[] args) {
//        System.out.println(getInstance()==getInstance());
//        System.out.println(getInstance()==getInstance());
//        System.out.println(getInstance()==getInstance());
//        System.out.println(getInstance()==getInstance());

        for (int i = 0; i <1000 ; i++) {
            new Thread(()->{
                getInstance();


            },String.valueOf(i)).start();
        }
    }
}
