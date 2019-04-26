package com.young.mywork.common.collection;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        int [] score;
            score=new int[10];
            score[0]=10;

        for (int i = 0; i < score.length; i++) {
            System.out.println("score = " + score[i]);
        }

        Arrays.stream(score).forEach(System.out::println);

        int [] arr={1,2,3,4,5};

        for (int i : arr) {
            System.out.println("i = " + i);
        }

        double[] score1={99.5,100,98,97.5,100,95,85.5,100};

        Arrays.sort(score1);

        int i = Arrays.binarySearch(score1, 98);
        //否则返回 -1 或 “-插入点”
        System.out.println("查找到99的位置 :  "+i);
    }
}
