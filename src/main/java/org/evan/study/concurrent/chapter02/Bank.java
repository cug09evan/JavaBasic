package org.evan.study.concurrent.chapter02;

/**
 * Created by marvel on 2017/9/17.
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("一号柜台");
        TicketWindow ticketWindow2 = new TicketWindow("二号柜台");
        TicketWindow ticketWindow3 = new TicketWindow("三号柜台");

        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();
    }
}
