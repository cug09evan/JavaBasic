package org.evan.study.concurrent.chapter04;

import javax.xml.crypto.Data;

/**
 * Created by marvel on 2017/9/17.
 */
public class ThreadJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DataCapture("M1", 10000));
        Thread t2 = new Thread(new DataCapture("M2", 15000));
        Thread t3 = new Thread(new DataCapture("M3", 30000));

        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("程序执行完毕。。。");
    }
}

class DataCapture implements Runnable {
    private String machineName; //采集机器名称
    private long spendTime;     //采集该机器所要花费的时间

    public DataCapture(String machineName, long spendTime) {
        this.spendTime = spendTime;
        this.machineName = machineName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("machine " + machineName + "capture date spend time is " + spendTime + " and succesfully. ");
    }
}