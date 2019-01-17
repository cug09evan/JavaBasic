package org.evan.study.concurrent.chapter09;

import org.evan.study.concurrent.chapter04.ThreadDaemon;

import java.util.stream.Stream;

/**
 * Created by marvel on 2017/10/15.
 * # The diffrence of sleep and wait:
 *      1. sleep is the method of Thread, and the wait is the method of Object;
 *      2. sleep will not release the Object monitor(Lock), but the wait will be release the monitor and add to the Object monitor waiting queue;
 *      3. use sleep not depend on the monitor, but wait need;
 *      4. The sleep method not need be wakeup, but wait need(except wait(10));
 */
public class DiffrenceOfWaitAndSleep {
    private final static Object LOCK = new Object();

    public static void main(String[] args) {
//        new Thread("T1") {
//            @Override
//            public void run() {
//                m2();
//            }
//        }.start();

        Stream.of("T1", "T2").forEach(n ->
            new Thread() {
                @Override
                public void run() {
                    m2();
                }
            }.start()
        );
    }

    /**
     * m1 method is to test the sleep method of application
     */
    public static void m1() {
        synchronized (LOCK) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " Enter.");
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * m2 method is to test the wait method of application.
     */
    public static void m2() {
        synchronized (LOCK) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " Enter.");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
