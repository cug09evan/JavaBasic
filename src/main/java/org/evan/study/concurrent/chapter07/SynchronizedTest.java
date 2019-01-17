package org.evan.study.concurrent.chapter07;

import org.evan.study.concurrent.chapter04.ThreadDaemon;

/**
 * Created by marvel on 2017/10/15.
 */
public class SynchronizedTest {
    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("线程"+ Thread.currentThread().getName()+"执行完成");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
    }
}
