package com.spring.boot.demo.algorithm.sort;

/**
 * 选择排序
 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * 平均时间复杂度：O(n^2)  空间复杂度O(1)  不稳定
 * Created by weiyongjun on 2020/7/15
 */
public class SelectSort {

    public static void main(String[] a) {
        int[] ar = new int[]{5, 2, 1, 3};
        selectSort(ar);
        System.out.println(1);
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                minPos = array[minPos] > array[j] ? j : minPos;
            }
            swap(array, i, minPos);
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}



