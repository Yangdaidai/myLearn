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
        System.out.println("main线程为："+Thread.currentThread().toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //使正在运行的Java线程转到阻塞状态，millisec参数设定的是线程的睡眠时间，
        // 以毫秒为单位，sleep(long millisec)是静态方法，只能控制当前正在运行的线程。

        //当Java线程在睡眠结束后，便会转为就绪（Runnable）状态。

        //一个线程执行了sleep操作，如果这个线程获取到锁，那么sleep并不会让出锁。
        //
        //前面说了，一个线程在睡眠结束后，便会转为就绪状态，并不会立刻执行，需要等待CPU的调度，
        // 那么sleep中指定的时间就是线程休眠的最短时间。
    }
}
