package com.young.mywork.common.collection.list;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ListIterator;
import java.util.*;

/**
 * Author 10248
 * Date 2019/5/8 9:45
 * Description
 */
public class ArrayListDemo {

    //一个集合是一个对象，但它表示一组对象，Java 集合中实际存放的是对象的引用值，不能存放基本数据类型值。

    //1. 集合存储对象
    //Java集合中实际存放的只是对象的引用，每个集合元素都是一个引用变量，实际内容都放在堆内存或者方法区里面，
    // 但是基本数据类型是在栈内存上分配空间的，栈上的数据随时就会被收回的。

    //2. 基本类型数据如何解决呢？
    //可以通过包装类把基本类型转为对象类型，存放引用就可以解决这个问题。更方便的，由于有了自动拆箱和装箱功能，
    // 基本数据类型和其对应对象（包装类）之间的转换变得很方便，想把基本数据类型存入集合中，直接存就可以了，
    // 系统会自动将其装箱成包装类，然后加入到集合当中。


    /**
     *  自定义类的集合类比较 :
     *  -- 1.自定义类实现comparable接口 ,重写compareTo()方法
     *  -- 2.自定义比较器,实现comparator接口 ,重写compare()方法
     */

    /**
     * List都可以添加null元素
     * HashMap可以有1个key为null的元素，TreeMap不能有key为null的元素,有序(自然排序,自定义排序)
     * Set底层是Map
     * 所以HashSet可以有1个null的元素，TreeSet不能有key为null的元素,有序(自然排序,自定义排序)。
     */

    public static void main(String[] args) {

        //ArrayList 类提供了快速的基于索引的成员访问方式，对尾部成员的增加和删除支持较好。
        // 使用 ArrayList 创建的集合，允许对集合中的元素进行快速的随机访问，不过，
        // 向 ArrayList 中插入与删除元素的速度相对较慢

        /**
         * 1. 不是线程安全的，不是线程同步的。
         * 2.ArrayList是通过可变大小的数组实现的，允许null在内的所有元素。
         * 3.ArrayList中存放顺序和添加顺序是一致的。并且可重复元素。
         */

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
        list.add(5);
        list.add(6);

        Collections.shuffle(list);
        System.out.println("shuffle list : " + list);


        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) System.out.println("value   = " + iterator.next());

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) System.out.println("value = " + listIterator.next());

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(10);

        //iterator删除元素
        Iterator<Integer> iterator1 = integers.iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            if (null != next && next.equals(5)) {
                iterator1.remove();
            }
            System.out.println("integers : " + integers);
        }


        list.removeAll(list1); //从list集合中删除所有在list1集合中出现的元素 list : [1, null]; list1 : [2, 3, 4]
        //  list.retainAll(list1); //从list集合中保留所有在list1集合中出现的元素list: [2, 3] ; list1: [2, 3, 4]
        System.out.println("list :" + list.toString());
        System.out.println("list1 :" + list1.toString());

        System.out.println("list中 2第一次出现的位置是 : " + list.indexOf(2));
        System.out.println("list中 2最后一次出现的位置是 : " + list.lastIndexOf(4));


        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);

        List<Integer> list4 = new ArrayList<>();
        list4.add(3);
        list4.add(4);
        list4.add(5);
        list4.add(6);

        //差集
        //  Collection<Integer> disjunction = CollectionUtils.disjunction(list3, list4);
        //   System.out.println("disjunction = " + disjunction);


        //交集
        Collection<Integer> retainAll = CollectionUtils.retainAll(list3, list4);
        System.out.println("retainAll = " + retainAll);
        System.out.println("----------------");
        list3.removeAll(retainAll);
        list4.removeAll(retainAll);
        System.out.println("list3 = " +list3 );
        System.out.println("----------------");
        System.out.println("list4 = " +list4 );
    }
}
