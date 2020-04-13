package com.young.mywork.common.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Copyright © 2020 YOUNG. All rights reserved.
 *
 * @Package com.young.mywork.common.collection.list
 * @ClassName ArrayListTest
 * @Description
 * @Author young
 * @Modify young
 * @Date 2020/4/13 12:05
 * @Version 1.0.0
 **/
public class ArrayListTest {

    private static final List<Integer> LIST = new ArrayList<>(10);

    private static final List<Integer> LIST1 = Collections.synchronizedList(LIST);
    private static final  Vector<Integer> VECTOR = new Vector<>(10);

    private static final CopyOnWriteArrayList<Integer> LIST2= new CopyOnWriteArrayList<>();

    private static final  CopyOnWriteArraySet<Integer> LIST3= new CopyOnWriteArraySet<>();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            processList();
        }
    }


    //多线程并发操作共享数据,引发线程安全问题 ArrayList线程不安全
    public static void processList() {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                //ArrayList 线程不安全
                //LIST.add(i);

                // synchronizedList 线程安全
                //  list.add(i);

                // vector 线程安全
                //vector.add(i);

                // CopyOnWriteArrayList  CopyOnWriteArraySet 线程安全
               // LIST2.add(i);
                LIST3.add(i);

                System.out.println("i = " + i);

            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread.start();
        thread1.start();
        thread2.start();

        try {
            thread.join();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("vector size = " + LIST3.size());
    }


}
