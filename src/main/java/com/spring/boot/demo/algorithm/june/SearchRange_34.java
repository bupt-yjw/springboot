package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/7/2
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
 * 这篇文章关于二分查找的分析写的很透彻
 * leedcode上还有一次提交是把两个方法整合起来
 */
public class SearchRange_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0;int right = nums.length-1;
        while (left<= right) {
            int mid = left+ (right-left)/2;
            if(nums[mid] == target) {
                right = mid-1;
            } else if(nums[mid]< target) {
                left = mid+1;
            } else if(nums[mid]> target) {
                right = mid-1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;

    }

    private int findLast(int[] nums, int target) {
        int left = 0;int right = nums.length-1;
        while (left<= right) {
            int mid = left+ (right-left)/2;
            if(nums[mid] == target) {
                left = mid+1;
            } else if(nums[mid] < target) {
                left = mid+1;
            } else if(nums[mid]> target) {
                right = mid-1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return left-1;
    }
}
