package com.young.mywork.common.process;

import java.util.ArrayList;
import java.util.List;

public class For {

    public static void main(String[] args) {
       // forMethod(6);
       forMethod1();
        List<String> list=new ArrayList<>();
        list.add("wo");
        list.add("hi");
     //   forEachMethod(list);

    }

    public static void forMethod(int num) {
        int result = 1;

        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        System.out.println(num + "的阶乘是 : " + result);
    }

    //99乘法表
    public static void forMethod1() {
        System.out.println("乘法口诀表：");
        for (int i = 1; i <= 9; i++) {
           for (int j=1; j<=i;j++){
               System.out.print(j+"*"+i+"="+j*i+"\t");
           }
            System.out.println();
        }
    }

    public static void forEachMethod(List<String> list) {
        if (!list.isEmpty() && list != null) {

            for (String s : list) {
                System.out.println("s : " + s);
            }
        }
    }
}
