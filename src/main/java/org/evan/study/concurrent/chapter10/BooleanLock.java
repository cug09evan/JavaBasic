package org.evan.study.concurrent.chapter10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by marvel on 2017/10/19.
 */
public class BooleanLock implements Lock {
    //if the value of initValue is true, it means the Lock has been used
    //if the value of initValue is false, it means the Lock if free.
    private boolean initValue;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();
    private Thread currentThread;

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while(initValue) {
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }

        blockedThreadCollection.remove(Thread.currentThread());
        initValue = true;
    }

    @Override
    public synchronized void lock(long millions) throws InterruptedException, TimeoutException {

    }

    @Override
    public synchronized void unlock() {
        this.initValue = false;
        Optional.of(Thread.currentThread().getName() + " release the lock monitor")
                .ifPresent(System.out::println);
        this.notifyAll();
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
