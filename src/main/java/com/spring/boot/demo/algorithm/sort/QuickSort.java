package com.spring.boot.demo.algorithm.sort;

/**
 * 快速排序 时间复杂度为O(nlogn)， 不稳定
 * 当n较大时使用快排比较好，当序列基本有序时用快排反而不好。
 * 基本思路：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * Created by weiyongjun on 2020/7/16
 */
public class QuickSort {

    public static void main(String[] a) {
        int[] ar = new int[]{5, 2, 1, 3, 0};
        quickSort(ar);
        System.out.println(1);
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = getPosition(array, left, right);
        quickSort(array, left, pos - 1);
        quickSort(array, pos + 1, right);
    }

    //优化后的实现，不需要swap交换
    private static int getPosition(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            if (left < right) {
                array[left++] = array[right];
            }
            while (left < right && array[left] <= temp) {
                left++;
            }
            if (left < right) {
                array[right--] = array[left];
            }
        }
        array[left] = temp;
        return left;
    }


}
