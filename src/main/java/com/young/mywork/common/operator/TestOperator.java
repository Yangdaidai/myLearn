package com.young.mywork.common.operator;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class TestOperator {
    public static void main(String[] args) {

        int a = 5;
        int b;

        b = a++; //b=5  将 a 的值先使用再加 1 赋值给 a 变量本身

        //  b=++a; //b=6  将 a 的值先加 1 赋值给变量 a 本身后再使用

        //  a++;
        //  ++a;

        // System.out.println("a = " + a);
        System.out.println("b=a++ 的结果是 " + b);
        //  System.out.println("b=++a 的结果是 " + b);

        List<String> allTypeList = new ArrayList<>(7);

        for (int i = 1; i <= 3; i++) {
            allTypeList.add(Integer.toString(i));
        }


        List<String> typeList = new ArrayList<>(3);
            allTypeList.add(Integer.toString(1));
            allTypeList.add(Integer.toString(3));
            allTypeList.add(Integer.toString(2));

        boolean b1 = CollectionUtils.containsAll(allTypeList, typeList);
        boolean equalCollection = CollectionUtils.isEqualCollection(allTypeList, typeList);
        System.out.println(b1);
        System.out.println(equalCollection);
    }


}
