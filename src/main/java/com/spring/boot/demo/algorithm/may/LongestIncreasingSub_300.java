package com.spring.boot.demo.algorithm.may;

import java.util.Arrays;

/**
 * 也是一道动态规划的题目，理解了题意还是很好做的。
 * 动态规划又叫填表法，以空间换时间
 * Created by weiyongjun on 2020/8/5
 */
public class LongestIncreasingSub_300 {

    public int lengthOfLIS(int[] nums) {
        if(nums.length< 2) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=1;i< nums.length;i++) {
            for(int j=0; j< i;j++) {//表示之前的计算的结果
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = dp[0];
        for(int a: dp) {
            max = Math.max(a, max);
        }
        return max;
    }

}
