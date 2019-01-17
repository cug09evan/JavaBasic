package org.evan.study.concurrent.chapter03;

/**
 * Created by marvel on 2017/9/17.
 */
public class CreateThreadConstructor {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("启动线程:"+this.getThreadGroup().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for(Thread temp : threads) {
            System.out.println("--------" + temp.getName());
        }
    }
}
