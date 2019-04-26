package com.young.mywork.common.process;

public class Switch {

    public static void switchMethod(int num) {
        switch (num) {
            case 1:
                System.out.println("num is 1 ");
               break;
             case 2:
                System.out.println("num is 2 ");
                break;
             default:
                 System.out.println("num is ?? ");
                 break;
        }
    }

    public static void main(String[] args) {
        //如果匹配到case语句后面没有break,一直执行到有break的语句为止
        switchMethod(3);

    }
}
