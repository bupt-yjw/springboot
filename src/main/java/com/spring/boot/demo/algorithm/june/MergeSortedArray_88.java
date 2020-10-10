package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/2 https://leetcode.com/problems/merge-sorted-array/submissions/
 * 思路：自己想的是用两个指针，从后往前依次判断，但是没考虑到num1走完而num2没走完的场景，这种场景下应该要把num2全部赋值到num1
 */
public class MergeSortedArray_88 {

    //自己的方法是错的，这里就不修改代码，只是指出来那些的地方是错的。
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //nums1Len，nums2Len的定义可以直接使用m和n
        int index = m + n - 1;
        int nums1Len = m - 1;
        int nums2Len = n - 1;
        if (nums1Len <= -1) {
            nums1[0] = nums2[0];
            return;
        }
        if (nums2Len <= -1) {
            return;
        }
        while (nums1Len >= 0 && nums2Len >= 0) {//没有考虑到一个先走完时，另外一个赋值过去的情况

            //if else 包括--操作可以放在三目运算里
            if (nums2[nums2Len] >= nums1[nums1Len]) {
                nums1[index] = nums2[nums2Len];
                nums2Len--;
            } else {
                nums1[index] = nums1[nums1Len];
                nums1Len--;
            }
            index--;
        }

    }

    /**
     * 这是自己4年前写的方法
     */
    public void mergeB(int[] nums1, int m, int[] nums2, int n) {
        m = m-1;
        n = n-1;
        int i = n+m+1;
        while(m>=0 || n>=0){
            if(m<0){
                nums1[i--] = nums2[n--];
            }else if(n<0){
                nums1[i--] = nums1[m--];//这一步操作不能省略，虽然此时i和m是相等的，主要目的是做--操作，否则会死循环
            }else{
                nums1[i--] = nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
            }
        }
    }




}
