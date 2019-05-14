package com.young.mywork.common.thread;

/**
 * Author 10248
 * Date 2019/5/14 15:50
 * Description
 */
public class ThreadTest4  implements Runnable {

    @Override
    public void run() {
        System.out.println("新启线程："+Thread.currentThread().toString());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadTest4());
            thread.start();
        }
    }
}
