package com.young.mywork.common.collection.set;

import java.util.HashSet;

/**
 * Author 10248
 * Date 2019/5/8 14:53
 * Description
 */
public class HashSetDemo {

    /**
     *      1. HashSet存储不能够存储相同的元素，元素是否相同的判断：重写元素的equals方法。
     * equals方法和hashCode方法必须兼容，如：equals方法判断的是用户的名字name，
     *那么hashCode的返回的hashCode必须是name.hashcode（）；
     *
     *      2. HashSet存储是无序的，保存的顺序与添加的顺序是不一致的，它不是线性结构，而是散列结构，
     * （通过散列表：散列单元指向链表）。因此，HashSet的查询效率相对比较高。
     *
     *      3. HashSet不是线程安全的，不是线程同步的。这需要自己实现线程同步：Collections.synchronizedCollection()，方法实现。
     *
     *      4.集合中不能包含重复的对象，并且最多只允许包含一个 null 元素。
     */

    //当你把对象加入HashSet时，HashSet(底层是hashMap)会先计算对象的hashcode值来判断对象加入的位置，同时也会与其他加入的对象的hashcode值作比较，
    // 如果没有相符的hashcode，HashSet会假设对象没有重复出现。但是如果发现有相同hashcode值的对象，
    // 这时会调用equals（）方法来检查hashcode相等的对象是否真的相同。如果两者相同，HashSet就不会让加入操作成功。
    //hashCode-->判断元素加入的位置 equals-->如果元素的hashCode相同,调用equals（）判断元素是否相同

    /**
     * ==与equals的区别
     * <p>
     * ==是判断两个变量或实例是不是指向同一个内存空间(判断地址值) equals是判断两个变量或实例所指向的内存空间的值是不是相同
     * ==是指对内存地址进行比较 equals()是对字符串的内容进行比较
     * ==指引用是否相同 equals()指的是值是否相同
     */

    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(6);
        hashSet.add(5);
        hashSet.add(2);

        //如果向 Set 集合中添加两个相同的元素，则后添加的会覆盖前面添加的元素，
        // 即在 Set 集合中不会出现相同的元素。
        hashSet.add(1);
        hashSet.add(1);

        //不能添加重复元素,并且最多只允许包含一个 null 元素。

        hashSet.add(null);
        hashSet.add(null);
        hashSet.forEach(o -> System.out.println("o = " + o));


        /**
         * 存储是无序的，保存的顺序与添加的顺序是不一致的
         * o = null
         * o = 1
         * o = 2
         * o = 3
         * o = 4
         * o = 5
         * o = 6
         */


        HashSet<String> strings = new HashSet<>();
        strings.add("hello");
        strings.add("ai");
        strings.add("boy");
        strings.add("!!!");

        System.out.println("------string------");
        strings.forEach(System.out::println);
    }
}
