package com.spring.boot.demo.algorithm.may;

import java.util.HashMap;

/**
 * Created by weiyongjun on 2020/5/14
 * 总结：利用hashmap操作使得时间复杂度为O(n)
 */
public class TwoSum_1 {

    /**
     *
     Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     You may assume that each input would have exactly one solution, and you may not use the same element twice.
     Example:

     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int len = nums.length;
        int temp = 0;
        for(int i = 0; i< len-1; i++) {
            temp = target - nums[i];
            for(int j=i+1; j< len; j++) {
                if(temp == nums[j]) {
                    res = new int[]{i,j};
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * best method
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumB(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(tracker.containsKey(nums[i])){
                int left = tracker.get(nums[i]);
                return new int[]{left, i};
            }else{
                tracker.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

}
