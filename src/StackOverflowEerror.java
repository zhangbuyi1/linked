public class StackOverflowEerror {

    public static void main(String[] args) {

        while (true){

            test1();
        }


    }

    private static void test1() {
        test1();
    }

}
