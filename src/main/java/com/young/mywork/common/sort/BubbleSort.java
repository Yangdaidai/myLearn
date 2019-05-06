package com.young.mywork.common.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        double[] scores = {88.5, 99, 45, 90, 23.5, 10, 100, 78};

        //冒泡排序
        //最好情况下 时间复杂度 o(n)
        //最坏情况下 时间复杂度 O(n²)
        bubbleSort(scores);

        for (double score : scores) {
            System.out.println("score = " + score);
        }
    }

    private static void bubbleSort(double[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {//外层控制循环趟数 n个数需要n-1趟
            for (int j = 0; j < array.length - 1 - i; j++) {//内层控制循环每一趟的次数
                if (array[j] > array[j + 1]) {
                    double temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }

        }
    }
}
