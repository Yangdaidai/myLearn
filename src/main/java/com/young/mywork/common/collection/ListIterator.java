package com.young.mywork.common.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(6)){
                iterator.remove();
            }
        }

        //jdk 1.8 方法
        list.removeIf(integer -> integer.equals(3));

        list.forEach(System.out::println);
    }
}
