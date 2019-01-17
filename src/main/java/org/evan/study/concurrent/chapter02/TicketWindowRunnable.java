package org.evan.study.concurrent.chapter02;

/**
 * Created by marvel on 2017/9/17.
 */
public class TicketWindowRunnable implements Runnable {
    private static final int MAX = 50;
    private static int index = 1;

    @Override
    public void run() {
        while(index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是："+(index++));
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
