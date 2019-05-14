package com.young.mywork.common.collection.list;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Author 10248
 * Date 2019/5/14 16:33
 * Description
 */
public class ListDemo {
    public static void main(String[] args) {
        for1(); //for1 耗时 : 10 毫秒
        for3(); //for3 耗时 : 95 毫秒
//        for1（）是循环外new对象 for3（）是循环内new对象。
        /**
         * 避免在循环体中创建对象,即使该对象占用内存空间不大.
         */

    }

    public static List<Demo> for1() {
        long before = System.currentTimeMillis();
        Demo demo;
        ArrayList<Demo> demos = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            demo = new Demo();
            demo.setId(i);
            demos.add(demo);
        }
        long after = System.currentTimeMillis();
        System.out.println("for1 耗时 : " + (after - before) + " 毫秒");
        return demos;
    }

    public static List<Demo> for3() {
        long before = System.currentTimeMillis();

        List<Demo> demos = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            Demo demo = new Demo();
            demo.setId(i);
            demos.add(demo);
        }
        long after = System.currentTimeMillis();
        System.out.println("for3 耗时 : " + (after - before) + " 毫秒");
        return demos;
    }
}

@Data
class Demo {
    private int id;
}
