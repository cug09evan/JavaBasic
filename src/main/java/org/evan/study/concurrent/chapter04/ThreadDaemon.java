package org.evan.study.concurrent.chapter04;

/**
 * Created by marvel on 2017/9/17.
 * 守护线程，当主线程死后，守护进程自动消亡
 * 应用事例： 在建立长链接的时候，双方需要进行心跳检测，此时可以将线程设置为deamon，当长连接消亡过后就不发送心跳检测
 */
public class ThreadDaemon {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread innerThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (true) {
                                System.out.println("Do some thing for health check");
                                Thread.sleep(500);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } );
                innerThread.setDaemon(true);
                innerThread.start();

                try {
                    Thread.sleep(1000);
                    System.out.println("T thread finish done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

//        t.setDaemon(true);
        t.start();
    }

}
