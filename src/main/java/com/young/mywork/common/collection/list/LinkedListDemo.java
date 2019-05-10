package com.young.mywork.common.collection.list;

import java.util.LinkedList;

/**
 * Author 10248
 * Date 2019/5/8 11:56
 * Description
 */
public class LinkedListDemo {
    //LinkedList 类采用链表结构保存对象，这种结构的优点是便于向集合中插入或者删除元素。
    // 需要频繁向集合中插入和删除元素时，使用 LinkedList 类比 ArrayList 类效果高，
    // 但是 LinkedList 类随机访问元素的速度则相对较慢。
    // 这里的随机访问是指检索集合中特定索引位置的元素。

    /**
     * 1.不是线程安全的，不是线程同步的。
     * 2.LinkedList是通过双向循环链表来实现的。
     * 3.存放顺序和添加顺序是一致的。可添加重复元素。
     * 4.适合链表头尾操作和插入指定位置元素的操作。
     * ArrayList和LinkedList之间的数据传递可通过toArray（）方法。
     */


    public static void main(String[] args) {

        // Java实现多态有三个必要条件：继承、重写、向上转型。
        //    但是向上转型存在一些缺憾，那就是它必定会导致一些方法和属性的丢失，而导致我们不能够获取它们。
        //    所以父类类型的引用可以调用父类中定义的所有属性和方法，对于只存在与子类中的方法和属性它就望尘莫及了
        //    List1<String> linkedList = new LinkedList<>();

        LinkedList<String> linkedList = new LinkedList<>();
        String hello = "hello";
        String world = "world";
        String good = "good";
        linkedList.add(hello);
        linkedList.add(world);
        linkedList.add(good);
        linkedList.forEach(System.out::println);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("------");
        linkedList.forEach(System.out::println);

    }
}
