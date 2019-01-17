package org.evan.study.concurrent.chapter02;

/**
 * Created by marvel on 2017/9/17.
 */
public class BankVersion2 {
    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();

        Thread windowThread1 = new Thread(ticketWindowRunnable, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindowRunnable, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindowRunnable, "三号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
