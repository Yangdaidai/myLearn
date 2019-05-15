package com.young.mywork.common.thread.threadPool.pool;

/**
 * Author 10248
 * Date 2019/5/15 17:34
 * Description
 */
public class MyRunnable implements Runnable {

    // 正在执行的任务数
    private int num;

    private MyRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行的MyRunnable " + num);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyRunnable " + num + "执行完毕");
    }
}
