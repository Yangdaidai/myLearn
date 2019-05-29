package com.young.mywork.common.array;

import java.util.Arrays;
import java.util.Random;

public class Array {

    public static void main(String[] args) {
        int[] score;
        score = new int[10];
        score[0] = 10;

        //数组是length属性
        //String是length()方法
        String str = "hello";
        int length = str.length();
        System.out.println(length);

        for (int i = 0; i < score.length; i++) {
            System.out.println("score = " + score[i]);
        }

        Arrays.stream(score).forEach(System.out::println);

        int[] arr = {1, 2, 3, 4, 5};

        for (int i : arr) {
            System.out.println("i = " + i);
        }

        double[] score1 = {99.5, 100, 98, 97.5, 100, 95, 85.5, 100};

        Arrays.sort(score1);

        int i = Arrays.binarySearch(score1, 98);
        //否则返回 -1 或 “-插入点”
        System.out.println("查找到99的位置 :  " + i);

        //随机数
        double random = Math.random();
        System.out.println("random = " +(int) (random*10));

        //种子数只是随机算法的起源数字，和生成的随机数的区间没有任何关系。
        // 在没带参数构造函数生成的Random对象的种子缺省是当前系统时间的毫秒数。
        Random random1 = new Random();

        int anInt = random1.nextInt(100);// nextInt()中的100是随机数的上限,产生的随机数为0-100的整数,不包括100。
        System.out.println("anInt = " + anInt);

    }
}
