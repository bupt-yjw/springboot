package com.spring.boot.demo.algorithm.sort;

/**
 * 冒泡排序
 * Created by weiyongjun on 2020/7/15
 * 是一种稳定的排序算法，平均时间复杂度O(n^2),最好时间复杂度O(n)
 * 基本思想就是：从无序序列头部开始，进行两两比较，根据大小交换位置，直到最后将最大（小）的数据元素交换到了无序队列的队尾，从而成为有序序列的一部分；下一次继续这个过程，直到所有数据元素都排好序。
 */
public class BubbleSort {
    public static void main(String[] a) {
        int[] ar = new int[]{5, 2, 1, 3};
        bubbleSort(ar);
        System.out.println(1);
    }

    //这个代码，无论什么情况下，时间复杂度都是O(n^2)。下面有优化后的代码，时间复杂度为O(n)
    public static void bubbleSort(int[] array) {
        for(int i=array.length-1 ;i>0;i--) {
            for(int j=0;j<i;j++) {
                swap(array, j, j+1);
            }
        }
    }

    private static void swap(int[] array, int i,int j) {
        if(array[j] <array[i]) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    //优化后的代码，能够实现在最好时间复杂度为O(n)
    public void bubbleSortB(int[] arr) {
        boolean didSwap;
        for(int i = 0, len = arr.length; i < len - 1; i++) {
            didSwap = false;
            for(int j = 0; j < len - i - 1; j++) {
                if(arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                    didSwap = true;
                }
            }
            if(didSwap == false) {
                return;
            }
        }
    }

}
