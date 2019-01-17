package org.evan.study.btrace;

import java.util.Random;
import java.util.UUID;

/**
 * Created by marvel on 2017/11/30.
 */
public class RemoteClass {
    public String display(String a, int b) {
        System.out.println(a + " " + b);
        return a;
    }

    public static void main(String[] args) {
        RemoteClass rc = new RemoteClass();
        while (true) {
            rc.display(UUID.randomUUID().toString(), new Random().nextInt());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
