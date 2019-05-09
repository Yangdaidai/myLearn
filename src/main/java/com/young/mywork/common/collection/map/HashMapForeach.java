package com.young.mywork.common.collection.map;

import com.young.mywork.common.collection.set.compare.App;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapForeach {
    public static void main(String[] args) {

        //         HashMap基于哈希表，底层结构由数组来实现，添加到集合中的元素以“key-value”形式保存到数组中，
        //         在数组中key--value被包装成一个实体来处理---也就是上面Map接口中的Entry。

        //        在HashMap中，Entry[]保存了集合中所有的键值对，当我们需要快速存储、获取、删除集合中的元素时，
        //        HashMap会根据hash算法来获得“键值对”在数组中存在的位置，以来实现对应的操作方法。

        //        哈希碰撞:
        //        hash值重复的情况，我们称之为哈希碰撞（又或者哈希冲突）。在HashMap中，是通过链表的形式来解决的，
        //        在hash值重复的数组角标下，通过链表将新插入的元素依次排列，当然如果插入的key相同，
        //        那么我们会将新插入的value覆盖掉原有的value；

        //        hashMap ---> 数组 + 链表


        //     hashMap  它具有如下特点：

        //允许存入null键，null值（null值只有一个，并存于数组第一个位置）
        //无序集合，而且顺序会随着元素的添加而随时改变（添加顺序，迭代顺序不一致）
        //随着元素的增加而动态扩容（与ArrayList原理一致）
        //不存在重复元素（得益于hashCode算法和equals方法）
        //线程不安全


        //  为什么扩容的大小一定要是2的整数次幂，也就是2的N次方.

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("yang chang", 20);
        hashMap.put("王小二", 18);
        hashMap.put("王小二", 20);
        hashMap.put(null, null);
        hashMap.put(null, 17);
        hashMap.put("ai", 19);


        //遍历1：获取key的Set集合
        //  Set<String> keySet = hashMap.keySet();
        for (String key : hashMap.keySet()) {
            System.out.println(" keySet --  key " + key + " value " + hashMap.get(key));
        }

        //遍历2:得到entrySet集合迭代器
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(" iterator --  key " + entry.getKey() + " value " + entry.getValue());
        }

        //遍历3:转换成Set集合，增强for循环
        //  Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(" 增强for -- name : " + entry.getKey() + " age : " + entry.getValue());
        }

        //jdk 1.8 forEach
        hashMap.forEach((name, age) -> System.out.println(" jdk 1.8 forEach -- name is : " + name + " age is : " + age));

        System.out.println("-----------");

        hashMap.put("yang", 35);
        hashMap.put("yang", 36);
        App app = new App("yang", 35);
        App app1 = new App("yang", 35);
        boolean equals = app.equals(app1);
        System.out.println(equals);  //equals 结果是  true 因为比较是对象里的内容,两个对象里面的内容是一样的
        System.out.println(app == app1);// == 结果是 false 因为 比较对象的在堆内存中的地址值,是两个对象,所以地址值不同

        System.out.println("------");
        App app2 = app;
        boolean equals1 = app.equals(app2);
        //指向同一个对象,所以结果都是相等;
        System.out.println(equals1);
        System.out.println(app == app2);

        //基本数据类型比较大小用==

        //hashMap新增:
        //在进行key一致性判断时，首先通过hash值判断，再通过equals()或者==进行判断
        // if ( e.hash == hash  &&  ((k = e.key) == key || key.equals(k))  )
    }
}
