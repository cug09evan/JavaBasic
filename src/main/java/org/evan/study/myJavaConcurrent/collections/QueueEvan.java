package org.evan.study.myJavaConcurrent.collections;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by marvel on 2017/9/9.
 */
public class QueueEvan {
    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.offer("OK");
        queue.poll();
    }
}
