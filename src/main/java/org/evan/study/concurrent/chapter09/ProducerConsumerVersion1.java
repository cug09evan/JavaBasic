package org.evan.study.concurrent.chapter09;

import java.util.stream.Stream;

/**
 * 单个生产者消费者模型实现
 * Created by marvel on 2017/10/15.
 */
public class ProducerConsumerVersion1 {
    private int i = 1;

    private final Object LOCK = new Object();
    private boolean isProduced = false;

    public void produce() {
        synchronized (LOCK) {
            if (isProduced) {    //如果已经生产，那么等待被消费即可
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {    //如果没有生产，那么就生产该产品
                i++;
                System.out.println("p-->" + i);
                LOCK.notifyAll();
                isProduced = true;
            }
        }
    }

    public void consume() {
        synchronized (LOCK) {
            if (isProduced) {    //如果已经生产了产品，那么就消费掉它
                System.out.println("C-->" + i);
                LOCK.notifyAll();
                isProduced = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerVersion1 pc = new ProducerConsumerVersion1();

        Stream.of("P1", "P2").forEach(n ->
                        new Thread("P") {
                            @Override
                            public void run() {
                                while (true)
                                    pc.produce();
                            }
                        }.start()
        );

        Stream.of("C1", "C2").forEach(n ->
                        new Thread("C") {
                            @Override
                            public void run() {
                                while (true)
                                    pc.consume();
                            }
                        }.start()
        );
    }

}
