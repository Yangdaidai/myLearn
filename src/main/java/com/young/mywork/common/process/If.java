package com.young.mywork.common.process;

import java.util.Scanner;

public class If {
    public static void main(String[] args) {

        System.out.println("请输入一个整数:");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if (num > 100)
            System.out.println("num =" + num + ",大于100");
        if (num < 100)
            System.out.println("num =" + num + ",小于100");
        if (num == 100)
            System.out.println("num =" + num + ",等于100");

    }
}
