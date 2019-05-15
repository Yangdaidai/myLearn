package com.young.mywork.common.thread.threadPool.executors;

import java.util.concurrent.*;

/**
 * Author 10248
 * Date 2019/5/15 15:54
 * Description
 */
public class FutureTaskExample {

    //创建线程的2种方式，一种是直接继承Thread，另外一种就是实现Runnable接口。
    //这2种方式都有一个缺陷就是：在执行完任务之后无法获取执行结果。
    //如果需要获取执行结果，就必须通过共享变量或者使用线程通信的方式来达到效果，这样使用起来就比较麻烦。
    //而自从Java 1.5开始，就提供了Callable和Future，通过它们可以在任务执行完毕之后得到任务执行结果。
    public static void main(String[] args) {
        MyCallable myCallable1 = new MyCallable(1000); //要执行的任务,返回线程名称;
        MyCallable myCallable2 = new MyCallable(2000);

        FutureTask<String> futureTask1 = new FutureTask<>(myCallable1);// 将Callable写的任务封装到一个由执行者调度的FutureTask对象
        FutureTask<String> futureTask2 = new FutureTask<>(myCallable2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(futureTask1);
        executorService.execute(futureTask2);
        while (true) {
            if (futureTask1.isDone() && futureTask2.isDone()) { //  两个任务都完成
                System.out.println("all task is done !");
                executorService.shutdown();  // 关闭线程池和服务
                return;
            }
            try {

                if (!futureTask1.isDone()) { // 任务1没有完成，会等待，直到任务完成
                    System.out.println("futureTask1.isDone() = " + futureTask1.isDone());

                    //get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回；
                    System.out.println("FutureTask1 output=" + futureTask1.get());
                    System.out.println("futureTask1.isDone() = " + futureTask1.isDone());

                }
                System.out.println("Waiting for FutureTask2 to complete");
                //果指定时间没有获取到结果，
                // 直接抛出超时异常，TimeoutException
                String taskName = futureTask2.get(5000L, TimeUnit.MILLISECONDS);
                if (taskName != null) {
                    System.out.println("FutureTask2 output="+taskName);
                }

            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
