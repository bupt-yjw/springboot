package com.spring.boot.demo.algorithm.sort;

/**
 * 希尔排序 不常用，仅作为记录. 不稳定排序 时间复杂度：O(n^1.3)
 * Created by weiyongjun on 2020/7/15
 */
public class ShellSort {

    public static void main(String[] a) {
        int[] ar = new int[]{5, 2, 1, 3};
        shellSort(ar);
        System.out.println(1);
    }

    public static void shellSort(int[] array) {
        int h = 1;
        //这个间隔的计算是有专门的算法来验证的
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (array[j] < array[j - gap]) {
                        swap(array, j, j - gap);
                    }
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
