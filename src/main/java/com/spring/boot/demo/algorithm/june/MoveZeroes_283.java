package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/20
 * https://leetcode.com/problems/move-zeroes/submissions/
 * 没有什么特别优化的思路
 *
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        if(nums == null|| nums.length == 0) {
            return;
        }
        int nonzeroIndex =0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                continue;
            }
            if(nonzeroIndex != i) {//只有当两个指针不一样时才进行交换。否则后面的设置为0会出错。
                nums[nonzeroIndex] = nums[i];
                nums[i]=0;
            }
            nonzeroIndex ++;
        }
    }

    //另外一种实现，思路其实都差不多，这个代码更简单一些
        public void moveZeroesB(int[] nums) {
            int index = 0;
            for(int num:nums){
                if(num!=0){
                    nums[index++]=num;
                }
            }
            while(index<nums.length){
                nums[index++] = 0;
            }
        }


}
