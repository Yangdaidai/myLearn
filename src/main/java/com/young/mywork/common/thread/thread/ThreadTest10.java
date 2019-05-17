package com.young.mywork.common.thread.thread;

/**
 * Author 10248
 * Date 2019/5/17 10:19
 * Description : 卖票的例子
 */
public class ThreadTest10 implements Runnable {

    //可售总数量 100张:
    private Integer count =1000;
    @Override
    public void run() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true){
            //如果大于0,就进行卖票
            if (count>0){
                System.out.println(Thread.currentThread().getName()+"正在售票,剩余票数 :  " + count--);
                continue;
            }
            System.out.println(Thread.currentThread().getName()+"票源不足，此时可售票数为："+ count);
            continue;
        }
    }

    //    一个线程从开始执行到执行结束的过程，如果在执行过程中有一个对象的变量被其他线程锁修改，
    //    那么对于当前线程来说，就发生了线程安全问题。如果每次运行结果和单线程运行的结果不一致，那么就会产生线程安全问题。


    //运行多线程环境； 多线程中存在共享变量；多线程中操作共享变量，主要操作行为--写操作；

    public static void main(String[] args) {
        ThreadTest10 ticket = new ThreadTest10();
        //开启4个窗口来卖票
        // 输出 : 窗口3票源不足，此时可售票数为：-1
        new Thread(ticket,"窗口1").start();
        new Thread(ticket,"窗口2").start();
        new Thread(ticket,"窗口3").start();
        new Thread(ticket,"窗口4").start();
    }



}
