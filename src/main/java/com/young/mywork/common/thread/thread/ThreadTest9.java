package com.young.mywork.common.thread.thread;

/**
 * Author 10248
 * Date 2019/5/17 10:19
 * Description
 */
public class ThreadTest9 implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("守护线程结束,我没有执行!");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest9());
        //在Java中，线程分为两大类型：用户线程和守护线程。

        //当我们将一个线程设置为守护线程，如果主线程执行结束，那么守护线程也会跟随主线程一起结束。

        //而用户线程却不同，如果主线程执行结束，但是用户线程还在执行，那么程序就不会停止。

        thread.setDaemon(true);
        thread.start();
        System.out.println("守护线程启动!");

        //新启动的线程被设置成了守护线程，当main线程结束时，守护线程也随之结束。但是，守护线程中的finally代码块并不会执行。
    }

    //多线程的使用并不是为了提高程序的运行速度，而是为了提高程序的运行效率，让CPU的使用率更高，让资源得到更合理的安排。

    /**
     * 线程的生命周期:
     * 初始状态-->运行状态-->阻塞状态-->等待状态-->终结状态
     *
     *
     * NEW
     * 线程的初始状态，也就是我们在代码中new Thread()后的状态，还没有调用start()方法
     *
     *
     * RUNNABLE
     * 运行状态，这一点与网上的很多文章不一样，在Thread类中，运行状态包含了就绪和运行，也就是调用了start()和实际执行run()
     *
     *
     * BLOCKED
     * 阻塞状态，线程在进入同步代码块之前，发现已经有线程获取到了锁，所以本线程阻塞等待锁的释放
     *
     *
     * WAITING
     * 等待状态，等待其他线程做一事情，例如当我们的一个线程被执行了Object.wait()，那么该线程实际在等待
     * 其他线程触发Object.notify、Object.notifyAll()
     *
     *
     * TIMED_WAITING
     * 定时等待，与WAITING不同的是，此种状态在达到一定时间便可返回运行状态，而不需要依赖其他线程处理，
     * 例如：Thread.sleep(x)、Object.wait(x)
     *
     *
     * TERMINATED
     * 终结状态，也就是说线程执行完毕了
     *
     */
}
