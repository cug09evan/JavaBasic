package org.evan.study.concurrent.chapter07;

/**
 * Created by marvel on 2017/10/15.
 */
public class SynchronizedClassTest {
    public static void main(String[] args) {
        new Thread("T1") {
            @Override
            public void run() {
                SynchronizedClass.m1();
            }
        }.start();

        new Thread("T2") {
            @Override
            public void run() {
                SynchronizedClass.m2();
            }
        }.start();

        new Thread("T3") {
            @Override
            public void run() {
                SynchronizedClass.m3();
            }
        }.start();
    }
}
