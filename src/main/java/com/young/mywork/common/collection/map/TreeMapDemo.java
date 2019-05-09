package com.young.mywork.common.collection.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Author 10248
 * Date 2019/5/9 20:05
 * Description
 */
public class TreeMapDemo {
    /**
     * TreeMap具有如下特点：
     * 不允许出现重复的key；
     * 不能插入NULL键；
     * 可以对元素进行排序；
     * 无序集合（插入和遍历顺序不一致）；
     * 不是线程安全的，不是线程同步的。
     */
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("hello", 20);
        treeMap.put("a", 18);
        treeMap.put("bill", 25);

        //遍历元素：
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(" key : " + entry.getKey() + " value : " + entry.getValue());
        }


        Set<String> keySet = treeMap.keySet();
        for (String key : keySet) {
            System.out.println("key : " + key + " value " + treeMap.get(key));
        }

        Collection<Integer> values = treeMap.values();
        values.forEach(System.out::println);

        /**
         *  自定义类的集合类比较 :
         *  -- 1.自定义类实现comparable接口 ,重写compareTo()方法
         *  -- 2.自定义比较器,实现comparator接口 ,重写compare()方法
         */
        System.out.println(treeMap);
    }
}
