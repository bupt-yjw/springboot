package com.spring.boot.demo.algorithm.june;

/**
 * https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 * 这个题别想太多，挨个跳每个位置，看能到达的位置是否超过数组长度。
 * Created by weiyongjun on 2020/8/7
 */
public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        int maxLen = nums[0];
        for(int i=0;i< nums.length;i++) {
            if(maxLen >= nums.length-1) {
                return true;
            }
            if(i> maxLen) {
                return false;
            }
            maxLen = nums[i]+i > maxLen? nums[i]+i: maxLen;
        }
        return false;
    }

    //方法思路跟上面是一样的，只是代码更简洁一点
    public boolean canJumpB(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
