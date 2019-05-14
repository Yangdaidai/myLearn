package com.young.mywork.common.thread;

/**
 * Author 10248
 * Date 2019/5/14 14:56
 * Description
 */
public class ThreadTest3 implements Runnable {

    @Override
    public void run() {
        System.out.println("新启线程" + Thread.currentThread().getName() + "的优先级为：" + Thread.currentThread().getPriority());//得到当前线程的优先级
    }

    public static void main(String[] args) {
        //设置线程的优先级
        Thread.currentThread().setPriority(10);
        System.out.println("设置主线程的优先级为: " + Thread.currentThread().getPriority());
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadTest3());
            if (i % 2 == 0) {
                //在Java线程中，每个线程都有默认的优先级，默认为5.
                thread.setPriority(6);
            }
            thread.start();
        }
        System.out.println("主线程为：" + Thread.currentThread().toString());
    }
}
