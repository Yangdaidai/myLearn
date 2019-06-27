package com.young.mywork.common.thread.productconsumer;

/**
 * @ClassName ProduceConsumer
 * @Description 生产者消费者
 * @Author young
 * @Date 2019/6/27 19:42
 * @Version 1.0
 **/
public class ProduceConsumer {

    /**
     * 生产者消费者问题
     * 生产者不断的往仓库中生产货物，货物装满时等消费者消费再生产，消费者不断的从仓库中消费货物，仓库为空时等生产者生产后再消费
     * 仓库类，存放货物的载体，仓库有最大容量。
     * 生产的货物数量+原有的数量 超过容量 就必须停止生产进入等待  让消费者消费消费后唤醒生产者。
     * 消费的货物数量 超过现有货物 就必须停止消费进入等待 让生产者生产货物后唤醒消费者。
     * 生产者类，负责生产
     * 消费者类，负责消费
     * wait() / notify() 使用这个实现
     */

    public static void main(String[] args) {

        //生产者、消费者公用仓库资源
        Storehouse store = new Storehouse();

        Producer producer1 = new Producer(10, store);
        Producer producer2 = new Producer(20, store);
        Producer producer3 = new Producer(30, store);
        Producer producer4 = new Producer(40, store);
        Producer producer5 = new Producer(50, store);

        Consumer c1 = new Consumer(20, store);
        Consumer c2 = new Consumer(10, store);

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();

        c1.start();
        c2.start();

    }
}
