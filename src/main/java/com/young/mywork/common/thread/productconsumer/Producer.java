package com.young.mywork.common.thread.productconsumer;

/**
 * @ClassName Producer
 * @Description 生产者
 * @Author young
 * @Date 2019/6/27 19:16
 * @Version 1.0
 **/
public class Producer extends Thread {
    //生产货物数量
    private int num;
    private Storehouse store;


   public Producer(int num,Storehouse store){
       super();
       this.num=num;
       this.store=store;
   }

    @Override
    public void run() {
        store.product(num);
    }
}
