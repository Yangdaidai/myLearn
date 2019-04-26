package com.young.mywork.common.process;

public class While {

    public static void main(String[] args) {
//        whileMethod();
        doWhileMethod(5);
    }

    public static void whileMethod() {
        int n = 1;
        int i = 1;
        while (i <= 10) {
            n = n * i;
            i++;
        }
        System.out.println("10的阶乘结果为：" + n);
    }

    //do…while 循环语句的特点是先执行循环体，然后判断循环条件是否成立。
    //至少执行一次
    public static void doWhileMethod(int a) {
        int number = 1, result = 1;
        do {
            result *= number;
            number++;
        } while (number <= a);
        System.out.println(a + "的阶乘结果是：" + result);
    }


}
