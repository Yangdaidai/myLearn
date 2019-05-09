package com.young.mywork.common.operator;

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

    }


}
