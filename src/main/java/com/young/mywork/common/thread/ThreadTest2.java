package com.young.mywork.common.thread;

/**
 * Author 10248
 * Date 2019/5/14 13:59
 * Description
 */
public class ThreadTest2 implements Runnable {
    @Override
    public void run() {
        System.out.println("新启线程为: " + Thread.currentThread().toString());

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new ThreadTest2()).start();
        }
        System.out.println("main线程为: " + Thread.currentThread().toString());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
