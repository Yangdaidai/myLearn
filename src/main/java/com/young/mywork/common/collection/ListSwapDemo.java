package com.young.mywork.common.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSwapDemo {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("202900000001"); //公寓
        list.add("202900000002"); //叠拼
        list.add("202900000003"); //联排
        list.add("202900000004"); //独栋
        list.add("202900000005"); //双拼
        list.add("-1");

        swap(list);


    }

    private static void swap(List<String> list) {
        if (list.size() > 0 && !list.isEmpty()) {

            int i = Collections.binarySearch(list, "202900000002");
            int j = Collections.binarySearch(list, "202900000004");

            if (i >= 0 && j >= 0) {
                Collections.swap(list, i, j);
            }

            System.out.println("i " + i);
            System.out.println("j " + j);

            int n = Collections.binarySearch(list, "202900000005");

            if (j >= 0 && n >= 0) {
                Collections.swap(list, j, n);
            }

            list.forEach(System.out::println);

        }
    }
}
