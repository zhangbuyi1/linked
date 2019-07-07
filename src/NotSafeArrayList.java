import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotSafeArrayList {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        for (int i=0;i<3;i++){

            new Thread(()->{
                String substring = UUID.randomUUID().toString().substring(0, 8);
                list.add(substring);
            System.out.println(list); },i+"").start();



        }

    }





}
