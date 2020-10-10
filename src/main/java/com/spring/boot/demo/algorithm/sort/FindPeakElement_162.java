package com.spring.boot.demo.algorithm.sort;

/** 寻找峰值，需求是在O(logN)的时间复杂度完成，那也就是通过二分查找。
 * Created by weiyongjun on 2020/8/21
 * https://leetcode.com/problems/find-peak-element
 * https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
 */
public class FindPeakElement_162 {

    public int findPeakElement(int[] nums) {
        return  search(nums, 0 , nums.length -1);
    }

    private int search(int[] nums, int l, int r) {
        if(l ==r) {
            return l;
        }
        int mid = l+(r-l)/2;
        if(nums[mid] < nums[mid+1]) {
            return search(nums, mid+1, r);
        }
        return search(nums, l, mid);
    }

}
