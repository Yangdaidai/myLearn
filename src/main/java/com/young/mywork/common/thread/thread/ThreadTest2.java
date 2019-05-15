package com.young.mywork.common.thread.thread;

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

    //我们都是使用实现Runnable接口的方式来完成线程的创建和启动。对于继承Thread来说，
    // 该方式实现起来编码更简单，在run()方法内部即可调用Thread类的方法；
    // 而实现Runnable接口方式，则极大避免了Java单继承的局限。

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new ThreadTest2()).start();
        }
        System.out.println("main线程为: " + Thread.currentThread().toString());
        //main线程为: Thread[main,5,main]
        //线程的名称，线程的优先级，线程组的名称；
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
