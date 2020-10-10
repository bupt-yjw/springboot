package com.spring.boot.demo.algorithm.sort;

/**
 * 插入排序(对于基本有序的数组最好用)
 * 思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置，直到全部插入排序完为止。 平均时间复杂度：O(n^2) 空间复杂度O(1)
 * 稳定 Created by weiyongjun on 2020/7/15
 */
public class InsertSort {

    public static void main(String[] a) {
        int[] ar = new int[]{5, 2, 1, 3};
        //  directSort(ar);
        new BinaryInsertSort().binarySort(ar);
        System.out.println(1);
    }


    //直接插入排序
    public static void directSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    //对直接插入排序的优化，不需要进行swap交换
    public void directSortB(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];//这样就不需要每次比较的时候都移动temp值
            int j;//因为for循环外面还需要用到j的值，因此不能在for循环里面定义j
            for (j = i - 1; j >= 0; j--) {
                if (temp < array[j]) {
                    //如果后一个小于前一个，则把前一个的值赋给后一个，且前一个的值不需要变化。因为始终使用temp在做比较
                    array[j + 1] = array[j];
                    //最后将temp放置到不满足条件的那个值得后面
                } else {
                    break;
                }

            }
            array[j + 1] = temp;
        }
    }

    //二分插入排序的比较次数与待排序记录的初始状态无关，仅依赖于记录的个数。当n较大时，比直接插入排序的最大比较次数少得多。但大于直接插入排序的最小比较次数。算法的移动次数与直接插入排序算法的相同，最坏的情况为n2/2，最好的情况为n，平均移动次数为O(n2)。
    //二分插入排序
    static class BinaryInsertSort {

        public void binarySort(int[] array) {
            for (int i = 0; i < array.length; i++) {
                int temp = array[i];//每次循环就是确定temp在数组中的位置
                int left = 0;
                int mid = 0;
                int right = i - 1;
                while (left <= right) {//先找到temp在数组0-i之间的位置，后面再移动数组来插入元素。
                    //每次插入的位置为最后循环结束后left或者right+1(表示顺序没变，就在原位置也就相当于最后的left=i)的位置，
                    mid = (left + right) / 2;
                    if (array[mid] > temp) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                for (int j = i - 1; j >= left; j--) {//将left后的值全部往后移一位，然后把temp放在left的位置
                    array[j + 1] = array[j];
                }
                //表示i处的值移动了
                if (left != i) {
                    array[left] = temp;
                }
            }
        }
    }
}
