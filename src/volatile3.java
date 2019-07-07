public class volatile3 {
    public static void main(String[] args) {
        t2 t2 = new t2();

        for (int i = 0; i <1000000 ; i++) {
            new Thread(()->{
                t2.add();;
            },String.valueOf(i)).start();
        }

    }
}
class t2 {
    int a = 0;
    boolean b = false;

    public void add() {
        a = 1;//
        b = true;
        if (b) {
            a += 5;
          if(a==5) {
              System.out.println(a);
          }

        }

    }

}