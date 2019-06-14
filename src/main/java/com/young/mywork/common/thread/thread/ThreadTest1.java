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

//因此Runnable具有更好的扩展性。
//此外，Runnable还可以用于“资源的共享”。即，多个线程都是基于某一个Runnable对象建立的，它们会共享Runnable对象上的资源。
//通常，建议通过“Runnable”实现多线程！

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
