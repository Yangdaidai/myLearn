package com.young.mywork.common.thread.thread;

/**
 * Author 10248
 * Date 2019/5/17 10:19
 * Description
 */
public class ThreadTest7 implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                //如果任意线程已经把当前线程中断了,执行sleep()方法会抛出中断异常!
                Thread.sleep(1000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("终于明白sleep会抛出异常了捕获异常了");            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest7());
        thread.start();
       //线程中断了,如果任意线程已经把当前线程中断了,执行sleep()方法会抛出中断异常!
        thread.interrupt();
    }
}
