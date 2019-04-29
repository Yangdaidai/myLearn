package com.young.mywork.common.sort;

public class QuickSort {

    public static int getMiddle(int[] arr, int low, int high) {
        int temp = arr[low];         //temp 就是基准数

        while (low < high) {

            //先看右边，依次往左递减
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high]; //比中轴小的记录移到低端

            //再看左边，依次往右递增
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low]; //比中轴大的记录移到高端
        }
        arr[low] = temp;  //中轴记录到尾
        return low;  //返回中轴的位置
    }

    public static void unckSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);
            unckSort(list, low, middle - 1);             //递归调用左半数组

            unckSort(list, middle + 1, high);            //递归调用右半数组

        }
    }

    public static void quick(int[] arr) {
        if (arr.length > 0) {
            unckSort(arr, 0, arr.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] number = {13, 15, 24, 99, 14, 11, 2, 1, 2, 3};
        quick(number);
        for (int i : number) {
            System.out.print(i + " ");
        }
    }

}
