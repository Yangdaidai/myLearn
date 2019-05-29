package com.young.mywork.common.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author 10248
 * Date 2019/5/27 14:40
 * Description
 */
public class AtomicTest {
    public static void main(String[] args) {

        /**
         * AtomicInteger 类主要利用 CAS (compare and set) + volatile 和 native 方法来保证原子操作，
         * 从而避免 synchronized 的高开销，执行效率大为提升。
         */
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println("atomicInteger = " + atomicInteger);

        //如果输入的数值等于预期值，则以原子方式将该值设置为输入值（update）
        boolean status = atomicInteger.compareAndSet(1, 1);
        System.out.println("status = " + status);

        int i = atomicInteger.incrementAndGet();
        System.out.println("increment value = " + i);

        int old = atomicInteger.getAndSet(3);
        System.out.println("old = " + old);

        int current = atomicInteger.get();//获取当前的值
        System.out.println("current value = " + current);
    }
}
