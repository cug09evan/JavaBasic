package org.evan.study.myJavaConcurrent;

/**
 * Created by marvel on 2017/11/3.
 * 线程A打印A，线程B打印B，运行两个线程，让他们交替打印ABABABABABA
 */
public class PrintABThread {
    public final Object LOCK = new Object();
    private boolean isPrint = false;

    public void printA() {
        for(int i=0; i<30; i++) {
            synchronized (LOCK) {
                if(isPrint) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print("A");
                    LOCK.notifyAll();
                    isPrint = true;
                }
            }
        }
    }

    public void printB() {
        for(int j=0; j<30; j++) {
            synchronized (LOCK) {
                if(isPrint) {
                    System.out.print("B");
                    LOCK.notifyAll();
                    isPrint = false;

                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintABThread print = new PrintABThread();

        Thread thread = new Thread() {
            @Override
            public void run() {
                print.printA();
            }
        };
        thread.start();




        Thread thread1 = new Thread() {
            @Override
            public void run() {
                print.printB();
            }
        };
        thread1.start();

    }
}
