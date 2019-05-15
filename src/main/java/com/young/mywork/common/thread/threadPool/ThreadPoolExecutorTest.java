package com.young.mywork.common.thread.threadPool;

import java.util.concurrent.*;

/**
 * Author 10248
 * Date 2019/5/15 17:41
 * Description
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        //关注点1 线程池大小
        //
        //线程池有两个线程数的设置，一个为核心池线程数，一个为最大线程数。
        //在创建了线程池后，默认情况下，线程池中并没有任何线程，等到有任务来才创建线程去执行任务，除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法
        //当创建的线程数等于 corePoolSize 时，会加入设置的阻塞队列。当队列满时，会创建线程执行任务直到线程池中的数量等于maximumPoolSize。

        //池中所保存的线程数，包括空闲线程。
        final int corePoolSize = 5;
        //池中允许的最大线程数。
        final int maximumPoolSize = 10;
        //当线程数大于核心线程时，此为终止前多余的空闲线程等待新任务的最长时间
        final long keepAliveTime = 200;
        //时间单位
        TimeUnit unit = TimeUnit.MILLISECONDS;

        //关注点2 适当的阻塞队列
        //ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
        //LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
        //PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。
        //DelayQueue： 一个使用优先级队列实现的无界阻塞队列。
        //SynchronousQueue： 一个不存储元素的阻塞队列。
        //LinkedTransferQueue： 一个由链表结构组成的无界阻塞队列。
        //LinkedBlockingDeque： 一个由链表结构组成的双向阻塞队列。


        //执行前用于保持任务的队列 5，即任务缓存队列
        //一个由数组结构组成的有界阻塞队列
        final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);


        //关注点3 明确拒绝策略
        //ThreadPoolExecutor.AbortPolicy: 丢弃任务并抛出RejectedExecutionException异常。 (默认)
        //ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
        //ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
        //ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务

        //丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
        myTask(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }


    /**
     * @param corePoolSize    正常线程数量
     * @param maximumPoolSize 最大线程数量
     * @param keepAliveTime   存活时间
     * @param unit            时间单位
     * @param blockingQueue   任务缓存队列
     * @param handler         拒绝策略
     */
    public static void myTask(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler handler) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, blockingQueue, handler);

        for (int i = 0; i < 15; i++) {
            MyRunnable myRunnable = new MyRunnable(i);
            threadPoolExecutor.execute(myRunnable);

            System.out.println("线程池中现在的线程数目是：" + threadPoolExecutor.getPoolSize() + ",  队列中正在等待执行的任务数量为：" +
                    threadPoolExecutor.getQueue().size());
        }
        //关掉线程池
        threadPoolExecutor.shutdown();
    }
}
