package com.spring.boot.demo.algorithm.sort;

import java.util.ArrayList;

/**
 * 基数排序  有序排序 时间复杂度：O(n * k)
 * 多关键字排序 用于大量数，很长的数进行排序时。
 * 将所有的数的个位数取出，按照个位数进行排序，构成一个序列。 将新构成的所有的数的十位数取出，按照十位数进行排序，构成一个序列。
 * Created by weiyongjun on 2020/7/17
 */
public class RadixSort {

    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        //定义0-9的一个数组，分别存储对应位的值。比如151 刚开始个位为1，则放到第二个list里面
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                //先计算个位的值，放入对应数组
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                //把list的值取出来，复制给array，则第一遍以后，array
                //里面的值都是按照个位排好序的
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }

}
