package com.young.mywork.common.thread.thread;

/**
 * Author 10248
 * Date 2019/5/17 10:19
 * Description
 */
public class ThreadTest9 implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("守护线程结束,我没有执行!");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest9());
        //在Java中，线程分为两大类型：用户线程和守护线程。

        //当我们将一个线程设置为守护线程，如果主线程执行结束，那么守护线程也会跟随主线程一起结束。

        //而用户线程却不同，如果主线程执行结束，但是用户线程还在执行，那么程序就不会停止。

        thread.setDaemon(true);
        thread.start();
        System.out.println("守护线程启动!");

        //新启动的线程被设置成了守护线程，当main线程结束时，守护线程也随之结束。但是，守护线程中的finally代码块并不会执行。
    }
}
