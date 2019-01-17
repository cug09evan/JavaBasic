package org.evan.study.concurrent.chapter02;

/**
 * Created by marvel on 2017/9/17.
 */
public class TicketWindow extends Thread {
    private static final int MAX = 50;
    private static int index = 1;

    private final String name ;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        while(index <= MAX) {
            System.out.println("柜台："+name+"当前号码是："+index++);
            try {
                Thread.sleep(1000L * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
