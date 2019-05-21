package com.young.mywork.common.thread.thread;

/**
 * Author 10248
 * Date 2019/5/17 10:19
 * Description : 卖票的例子
 */
public class ThreadTest10 implements Runnable {

    //可售总数量 100张:
    private Integer count = 1000;

    @Override
    public void run() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            //如果大于0,就进行卖票
            if (count > 0) {
                synchronized (this) {
                    //同步代码块
                    //加锁 会导致程序性能的下降
                    //使用同步：在线程执行逻辑中，给读写共享变量的操作同时加锁处理，使得同一时刻只有一个线程可以操作访问共享数据。
                    if (count > 0) {

                        System.out.println(Thread.currentThread().getName() + "正在售票,剩余票数 :  " + count--);
                        continue;
                    }
                }
            }

            System.out.println(Thread.currentThread().getName() + "票源不足，此时可售票数为：" + count);
        }
    }

    //造成线程不安全的原因
    //    一个线程从开始执行到执行结束的过程，如果在执行过程中有一个对象的变量被其他线程锁修改，
    //    那么对于当前线程来说，就发生了线程安全问题。如果每次运行结果和单线程运行的结果不一致，那么就会产生线程安全问题。

    //运行多线程环境； 多线程中存在共享变量；多线程中操作共享变量，主要操作行为--写操作；

    //    同步方法：在类中的方法上加synchronized修饰符； //同步方法中的锁是：this，即调用者本身；
    //   静态同步方法: 在类中的静态方法上加synchronized //静态同步方法中的锁是：类名.class，即Class对象；
    //    同步代码块：在需要同步的代码上写一个synchronized(Object obj){}代码块； //同步代码块中的锁是：任意对象；

    public static void main(String[] args) {
        ThreadTest10 ticket = new ThreadTest10();
        //开启4个窗口来卖票,不加锁时,会造成余票不对
        // 输出 : 窗口3票源不足，此时可售票数为：-1
        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();
        new Thread(ticket, "窗口4").start();
    }


}
