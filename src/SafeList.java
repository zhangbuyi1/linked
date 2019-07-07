import sun.security.pkcs11.wrapper.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class SafeList {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new CopyOnWriteArrayList<>();


        for (int i = 0; i < 10 ; i++) {
            new Thread(() -> {
                String substring = UUID.randomUUID().toString().substring(0, 8);

                list.add(substring);



                System.out.println(list);

            },i+"").start();

        }
        Thread.sleep(1000);
        System.out.println(list+"========");


    }


}
