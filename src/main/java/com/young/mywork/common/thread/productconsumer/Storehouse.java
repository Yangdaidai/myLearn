package com.young.mywork.common.thread.productconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * 仓库类
 */
public class Storehouse {
    //仓库储存最大数量
    private static final int maxNum = 100;
    //货物载体
    private List<Object> goods = new ArrayList<>(16);

    /**
     * @return void
     * @Author young
     * @Description 生产num个货物
     * @Date 18:36 2019/6/27
     * @Param [num]
     **/
    public void product(int num) {
        synchronized (goods) {
            System.out.println("开始生产......");
            /*
             * 生产的数量超过仓库容量，一定要用while，因为不符合条件时进入线程等待(此时等待消费者消费)，
             * 消费者消费后，唤醒生产者，生产者 还要继续判断是否可以生产，不能生产还得进入线程等待
             */
            while (goods.size() + num > maxNum) {
                System.out.println("仓库现有：" + goods.size() + ",生产：" + num + ",超过最大容量" + maxNum + ",无法进行生产");
                try {
                    goods.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                goods.add(new Object());
            }
            System.out.println("生产：" + num + ",现有货物：" + goods.size());
            goods.notifyAll();
        }
    }

    /**
     * @return void
     * @Author young
     * @Description 消费num个货物
     * @Date 19:06 2019/6/27
     * @Param [num]
     **/
    public void consumer(int num) {
        synchronized (goods){
            System.out.println("开始消费......");
            //消费的数量超过仓库容量
            while (num>goods.size()){
                try {
                    goods.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                goods.remove(goods.size()-1);
            }
            System.out.println("消费:"+num+",现有货物: "+goods.size());
            goods.notifyAll();
        }
    }
}
