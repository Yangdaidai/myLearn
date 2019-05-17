package com.young.mywork.common.thread.thread;

import java.util.ArrayList;

/**
 * Author 10248
 * Date 2019/5/14 19:57
 * Description
 */
public class ThreadTest5 implements Runnable {
    @Override
    public void run() {
        System.out.println("新启线程：" + Thread.currentThread().toString());
    }

    public static void main(String[] args) {

        System.out.println("main开始做事，main线程为：" + Thread.currentThread().toString());

        ArrayList<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadTest5());
            list.add(thread);
            thread.start();
        }
        //不要在循环中使用try…catch…，应该把其放在最外层
        try {
            for (Thread thread : list) {
                //父线程等待子线程结束之后再运行--join()
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //，main线程要等到每一个thread线程运行结束后，才会输出“main继续做事 ...”。
        // 如果不加thread.join(),main线程和thread线程是并行的。
        // 而加上thread.join(),程序就变成是顺序执行了。
        System.out.println("main继续做事，main线程为：" + Thread.currentThread().toString());

        //join内部其实是由于wait()方法实现。当我们调用无参数的join()方法时，
        // 线程会一直执行while循环，
        // 探测实现是否还存活，存活就wait(0)，就这样一直在while循环中做判断，
        // 当线程执行结束后，isAlive()返回false，while循环结束。
    }
}
