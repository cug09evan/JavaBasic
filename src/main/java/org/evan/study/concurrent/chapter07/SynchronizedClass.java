package org.evan.study.concurrent.chapter07;

/**
 * Created by marvel on 2017/10/15.
 */
public class SynchronizedClass {
    //类中静态同步代码块，锁是什么？SynchronizedClass.class,在加载类的时候只会加载一次
    static {
        synchronized (SynchronizedClass.class) {
            try {
                System.out.println("static" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void m1() {
        System.out.println("m1 " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized  void m2() {
        System.out.println("m2 " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m3() {
        System.out.println("m3 " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}