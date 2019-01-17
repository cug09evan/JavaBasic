package org.evan.study.concurrent.chapter03;

/**
 * Created by marvel on 2017/9/17.
 */
public class CreateThread {
    private static int counter = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    e.printStackTrace();
                    System.out.println(counter);
                }

            }

            private void add(int index) {
                counter++;
                add(index + 1);
            }
        }, "Test", 1<<24);

        thread.start();
    }
}
