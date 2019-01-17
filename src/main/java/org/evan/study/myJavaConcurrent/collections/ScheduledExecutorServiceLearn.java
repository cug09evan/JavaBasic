package org.evan.study.myJavaConcurrent.collections;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by marvel on 2017/9/10.
 */
public class ScheduledExecutorServiceLearn {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        Runnable pinger = new Runnable() {
            @Override
            public void run() {
                System.out.println("ping ...");
            }
        };

        ses.scheduleAtFixedRate(pinger, 5, 5, TimeUnit.SECONDS);
    }
}
