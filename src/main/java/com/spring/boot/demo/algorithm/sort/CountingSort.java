package com.spring.boot.demo.algorithm.sort;

/** 计数排序
 * 适合量大但是范围小， 时间和空间复杂度 O(n+k) 稳定排序，非比较排序
 * 计数排序很好的一个参考链接：https://mp.weixin.qq.com/s/Tq-hUeNv-wrF-hjKoA4nfw
 * Created by weiyongjun on 2020/7/17
 */
public class CountingSort {
    public static void main(String[] a) {
        int[] ar = new int[]{5, 2, 1, 3,0};
        countingSort(ar);
        System.out.println(1);
    }

    public static void countingSort(int[] array) {
        int max = array[0];
        int min = array[0];
        //先找数组中的最大值和最小值
        for(int i=1;i< array.length;i++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
        }

        //统计个数
        int[] count = new int[max-min+1];
        for(int i=0;i< array.length;i++) {
            count[array[i]-min]++;
        }
        //变形，通过变形可以变成稳定排序
        for(int i=1;i< count.length;i++) {
            count[i] = count[i] + count[i-1];
        }
        int[] result = new int[array.length];
        for(int i= array.length-1;i>=0;i--) {
            result[count[array[i]-min]-1] = array[i];
            count[array[i]-min]--;
        }
        System.arraycopy(result,0,array,0, array.length);
    }
}
