package com.young.mywork.common.thread.productconsumer;

/**
 * @ClassName Consumer
 * @Description 消费者
 * @Author young
 * @Date 2019/6/27 19:22
 * @Version 1.0
 **/
public class Consumer extends Thread {
    //消费货物数量
    private int num;
    private Storehouse store;

    public Consumer(int num, Storehouse store) {
        super();
        this.num = num;
        this.store = store;
    }

    @Override
    public void run() {
        store.consumer(num);
    }
}
