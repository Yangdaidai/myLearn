package com.young.mywork.common.thread.thread;

/**
 * Author 10248
 * Date 2019/5/14 11:50
 * Description
 */
public class ThreadTest1  extends Thread{
    //    创建创建有两种方法:
    //继承 Thread 类创建线程;
    //实现 Runnable 接口类创建线程;


    @Override
    public void run() {
        System.out.println("新启线程为："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadTest1 threadTest1 = new ThreadTest1();
        ThreadTest1 threadTest2 = new ThreadTest1();
        threadTest1.start();
        threadTest2.start();
        System.out.println("主线程为："+Thread.currentThread().getName());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
