package com.young.mywork.common.sort;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        double[] scores={78,99,97,86};
        Arrays.sort(scores);

        for (double score : scores) {
            System.out.println("score = " + score);
        }

        Arrays.sort(scores);

        System.out.println("============");

        for (double score : scores) {
            System.out.println("score = " + score);

        }
    }
}
