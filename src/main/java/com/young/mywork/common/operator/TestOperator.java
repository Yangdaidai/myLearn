package com.young.mywork.common.operator;

public class TestOperator {
    public static void main(String[] args) {


        int a = 5;
        int b;
        b = a++; //b=5 ; a=6 ; 将 a 的值先使用再加 1 赋值给 a 变量本身
        System.out.println("a后自增一时,b= " + b + ", a= " + a); //b= 5, a= 6

        int a1 = 5;
        int b1;

        b1 = ++a1; //b=6 ; a1=6 ; 将 a1 的值先加 1 赋值给变量 a 本身后再使用
        System.out.println("a1前自增一时,b1= " + b1 + ", a1= " + a1); //b1= 6, a1= 6

        int c=0;
        c=c++;
        System.out.println("c后自增一时,c="+c); //c=0

        int c1=0;
        ++c1;
        System.out.println("c1前自增一时,c1="+c1); //c1=1




    }


}
