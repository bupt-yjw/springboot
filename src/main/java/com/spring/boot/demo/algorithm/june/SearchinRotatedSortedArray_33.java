package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/7/1
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/
 * 这个题有个很简洁的实现，需要通过图纸来寻找规律。找到公式后利用异或来完成。我的三个异或跟上面链接的不一样，我的更直观。
 *     nums[0] <= target <= nums[i]
                target <= nums[i] < nums[0]˜
                          nums[i] < nums[0] <= target
 https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
 */
public class SearchinRotatedSortedArray_33 {

    //极简的方法，十分巧妙
    public int searchV(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = (left+right)/2;
            if(target<= nums[mid] ^ nums[mid]< nums[0] ^ nums[0]<= target) {
                left = mid+1;
            } else {
                right = mid;//注意这里left 是mid+1，而right 是mid
            }
        }
        return left==right&& nums[left]==target? left:-1;
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = (left+right)/2;
            if(target<= nums[mid]&& nums[mid]< nums[0]) {
                right = mid;
            } else if(nums[mid] < nums[0] && nums[0]<= target) {
                right = mid;
            } else if(nums[mid] >= target && nums[0]<= target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return  left== right && nums[left] == target? left: -1;

    }
}
