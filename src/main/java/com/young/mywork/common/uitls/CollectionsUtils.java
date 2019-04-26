package com.young.mywork.common.uitls;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsUtils {

    //态方法有一种情况需要注意一下，那就是在类中的静态方法使用泛型：静态方法无法访问类上定义的泛型；
    // 如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。
    //即：如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法 。

    //  输入两个元素类型相同的List，删除两个集合中相同的元素后返回
    public static <T> void deleteEqualList(List<T> oldList, List<T> newList,String fieldName) {
        if ((null==oldList||oldList.isEmpty())||(null==newList||newList.isEmpty())){
            return;
        }
        Iterator<T> iterator = newList.iterator();
        while (iterator.hasNext()){
            T nt = iterator.next();
            for (T ot : oldList) {
                try {
                    Field oldField = ot.getClass().getDeclaredField(fieldName);
                    Field newField = nt.getClass().getDeclaredField(fieldName);
                    oldField.setAccessible(true);
                    newField.setAccessible(true);
                    if (oldField.get(ot).equals(newField.get(nt))){
                        oldList.remove(ot);
                        iterator.remove();
                        break;
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }


            }
        }

    }

    public static void main(String[] args) {

        List<String> olds= new ArrayList<>();
        olds.add("1");
        olds.add("2");
        olds.add("4");
        List<String> news = new ArrayList<>();
        news.add("1");
        news.add("2");
        news.add("3");

        deleteEqualList(olds,news,"value");

        olds.forEach(System.out::println);
        System.out.println("---");
        news.forEach(System.out::println);
    }
}
