package org.evan.study.concurrent.chapter10;

import java.util.Collection;

/**
 * Created by marvel on 2017/10/19.
 */
public interface Lock {

    class TimeoutException extends Exception {
        public TimeoutException(String message) {
            super(message);
        }
    }

    void lock() throws InterruptedException;

    void lock(long millions) throws InterruptedException, TimeoutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();
}
