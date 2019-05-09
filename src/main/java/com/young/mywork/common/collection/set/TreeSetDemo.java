package com.young.mywork.common.collection.set;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Author 10248
 * Date 2019/5/8 15:36
 * Description
 */
public class TreeSetDemo {
    /**
     * TreeSet具有排序功能，分为自然排序(123456)和自定义排序两类，
     * 默认是自然排序；在程序中，我们可以按照任意顺序将元素插入到集合中，
     * 等到遍历时TreeSet会按照一定顺序输出--倒序或者升序；
     */

    /**
     * 特点:
     * 对插入的元素进行排序，是一个有序的集合（主要与HashSet的区别）;
     * 底层使用红黑树结构，而不是哈希表结构；
     * 不允许插入Null值；
     * 不允许插入重复元素；
     * 线程不安全；
     */

    //TreeSet底层是TreeMap的put方法,会调用compareTo方法，对象为null时，会报空指针错。

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();

        //元素添加：
        treeSet.add("ok");
        treeSet.add("my");
        treeSet.add("name");
        treeSet.add("young");
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("ai");
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        System.out.println("TreeSet容量大小：" + treeSet.size());
        System.out.println("TreeSet元素顺序为：" + treeSet.toString());

        String first = treeSet.first();
        System.out.println("TreeSet头节点为：" + first);

        SortedSet<String> before = treeSet.headSet("ai");
        System.out.println("ai节点之前的元素为 : " + before);

        //删除并返回第一个元素：如果set集合不存在元素，则返回null
        String pollFirst = treeSet.pollFirst();
        System.out.println("删除的第一个元素：" + pollFirst);

        treeSet.forEach(System.out::println);

        //迭代器遍历, 升序
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext())
            System.out.println("value : " + iterator.next());

        System.out.println("------");

        //迭代器遍历, 倒序
        Iterator<String> descendingIterator = treeSet.descendingIterator();
        while (descendingIterator.hasNext()) System.out.println("value : " + descendingIterator.next());


    }
}
