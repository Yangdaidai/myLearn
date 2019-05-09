package com.young.mywork.common.collection.set.compare;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Author 10248
 * Date 2019/5/8 20:19
 * Description
 */
public class TreeSetSort {
    public static void main(String[] args) {
        // customSort();
        //Exception in thread "main" java.lang.ClassCastException: com.young.mywork.common.collection.set.compare.App
        // cannot be cast to java.lang.Comparable

        //通过查看源码发现，在TreeSet调用add方法时，会调用到底层TreeMap的put方法，
        // 在put方法中会调用到compare(key, key)方法，进行key大小的比较
        //在比较的时候，会将传入的key进行类型强转，所以当我们自定义的App类进行比较的时候，
        // 自然就会抛出异常，因为App类并没有实现Comparable接口；

        //App1实现comparable接口
        //   comparableSort();

        ////自定义比较器,实现comparator接口：升序
        comparatorSort();
    }

    //自定义排序顺序：升序
    public static void customSort() {

        //排序对象：
        App app1 = new App("hello", 10);
        App app2 = new App("world", 20);
        App app3 = new App("my", 15);
        App app4 = new App("name", 25);


        //添加到集合：
        TreeSet<App> treeSet = new TreeSet<>();
        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app4);

        System.out.println("TreeSet集合顺序为：" + treeSet);
    }

    public static void comparableSort() {

        App1 app1 = new App1("hello", 10);
        App1 app2 = new App1("world", 20);
        App1 app3 = new App1("my", 15);
        App1 app4 = new App1("name", 25);
        App1 app5 = new App1("ann", 20);
        App1 app6 = new App1("ann", 21);
        TreeSet<App1> treeSet = new TreeSet<>();

        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app4);
        treeSet.add(app5);
        treeSet.add(app6);
        System.out.println(treeSet);
    }

    private static void comparatorSort() {

        TreeSet<App2> treeSet = new TreeSet<>(new AppComparator());
        App2 app4 = new App2("name", 25);
        App2 app5 = new App2("ann", 20);
        treeSet.add(app4);
        treeSet.add(app5);
        System.out.println(treeSet);

    }
}
