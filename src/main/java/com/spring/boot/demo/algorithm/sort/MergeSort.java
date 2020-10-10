package com.spring.boot.demo.algorithm.sort;

/**
 * 归并排序 归并排序是稳定的排序方法。 　　
 * 归并排序的时间复杂度为O(nlogn)。空间复杂度O(n) 　　
 * 速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
 * Created by weiyongjun on 2020/7/16
 */
public class MergeSort {

    public static void main(String[] a) {
        int[] ar = new int[]{5, 2, 1, 3};
        mergeSort(ar);
        System.out.println(1);
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;//防止越界
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid + 1, right);
        }
    }

    //归并排序，需要一个辅助数组，最后将辅助数组赋值回去
    private static void merge(int[] array, int leftP, int rightP, int rightB) {
        int[] temp = new int[rightB - leftP + 1];
        int mid = rightP - 1;
        int i = leftP;
        int j = rightP;
        int k = 0;
        while (i <= mid && j <= rightB) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= rightB) {
            temp[k++] = array[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            array[leftP + m] = temp[m];
        }
    }


}
