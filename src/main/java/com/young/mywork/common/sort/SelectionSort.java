package com.young.mywork.common.sort;

import java.util.Arrays;

/**
 * Author 10248
 * Date 2019/5/6 15:44
 * Description 选择排序
 */
public class SelectionSort {
    // 原理：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
    // 也就是：每一趟在n-i+1(i=1，2，…n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。
    // 基于此思想的算法主要有简单选择排序、树型选择排序和堆排序。（这里只介绍常用的简单选择排序）

    private static void selectionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int k = i;
            //找出最小值的下标
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            // 将最小值放到未排序记录的第一个位置
            if (k>i){
              int tmp=array[i];
              array[i]=array[k];
              array[k]=tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 76,50, 13, 27, 50 };

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
