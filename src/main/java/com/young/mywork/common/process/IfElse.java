package com.young.mywork.common.process;

public class IfElse {
    //if 语句判断 num1 和 num2 的大小关系
    public static void compareInt(int a, int b) {
        if (a > b) {
            System.out.println(a + " 大于 " + b);
        }
        if (a < b) {
            System.out.println(a + " 小于 " + b);
        }
        if (a == b) {
            System.out.println(a + " 等于 " + b);
        }
    }

    public static void compareInt1(int a, int b) {
        if (a > b) {
            System.out.println(a + " 大于 " + b);
        } else if (a < b) {
            System.out.println(a + " 小于 " + b);
        } else {
            System.out.println(a + " 等于 " + b);
        }
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 15;

        compareInt(num1, num2);
        compareInt1(num1,num2);

    }
}
