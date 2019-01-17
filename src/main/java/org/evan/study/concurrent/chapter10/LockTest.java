package org.evan.study.concurrent.chapter10;

import org.evan.study.concurrent.chapter04.ThreadDaemon;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by marvel on 2017/10/19.
 */
public class LockTest {
    public static void main(String[] args) {
        final BooleanLock booleanLock = new BooleanLock();

        Stream.of("T1", "T2" ,"T3", "T4")
                .forEach(name ->
                    new Thread(()-> {
                                try {
                                    booleanLock.lock();
                                    work();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } finally {
                                    booleanLock.unlock();
                                }

                            }, name).start()
                );
    }

    public static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is working")
                .ifPresent(System.out::println);
        Thread.sleep(4_000);
    }
}
