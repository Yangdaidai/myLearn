package com.young.mywork.common.thread.thread;

/**
 * Author 10248
 * Date 2019/5/17 9:56
 * Description
 */
public class ThreadTest8 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("新启线程 : " + i);
            //暂停当前正在执行的线程
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadTest8()).start();
        System.out.println("新线程启动了!");
        for (int i = 0; i < 10; i++) {
            System.out.println("main 线程: " + i);
            Thread.yield();

            //暂停当前正在执行的线程，执行其他线程。对于其他线程(包括自身)，这里面包含了两种含义。

            //   Thread.yield()执行后，允许其他线程获得运行机会。因此，使用yield()让多个线程之间能适当的轮转执行。
            //   但是，测试结果来看无法完全保证Thread.yield()的目的，执行Thread.yield()的线程有可能被线程调度程序再次选中，
            //   也就是说自己被认为了其他线程。
            //   值得注意的是，Thread.yield()是将线程从运行状态转为了就绪状态，并没有阻塞线程。


        }
    }
}
