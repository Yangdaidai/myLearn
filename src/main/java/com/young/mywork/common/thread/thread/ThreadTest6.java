package com.young.mywork.common.thread.thread;

/**
 * Author 10248
 * Date 2019/5/17 10:19
 * Description
 */
public class ThreadTest6 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("我被中断了!");
            } else {
                System.out.println("我一直在运行.");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest6());
        thread.start();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        //interrupt()方法通过修改了被调用线程的中断状态来告知那个线程,
        // 告诉它自己已经被中断了，这里指的中断是一个中断信号，不是说将被调用的线程给干掉了，不要理解错了.
    }
}
