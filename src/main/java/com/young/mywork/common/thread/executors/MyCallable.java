package com.young.mywork.common.thread.executors;

import java.util.concurrent.Callable;

/**
 * Author 10248
 * Date 2019/5/15 15:51
 * Description
 */
public class MyCallable implements Callable<String> {
    private long waitTime;

    public MyCallable(int timeInMillis) {
        this.waitTime = timeInMillis;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }
}
