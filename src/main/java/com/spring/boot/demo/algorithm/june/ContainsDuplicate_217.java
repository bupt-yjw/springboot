package com.spring.boot.demo.algorithm.june;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 该题要求判断数组里是否有重复的元素，一共三种方法。没有什么取巧的地方。
 * 1。暴力法，两次循环O(n^2)复杂度。
 * 2。排序，然后判断相邻元素。使用堆排。O(nlog(n))
 * 3.利用HashSet，O(n)时间复杂度，空间复杂度也是O(n)
 * Created by weiyongjun on 2020/6/19
 */
public class ContainsDuplicate_217 {
    //排序法
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i =0;i< nums.length-1;i++) {
            if(nums[i]== nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    //HashSet方法
    public boolean containsDuplicateH(int[] nums) {
        HashSet set = new HashSet();
        for(int num: nums) {
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }


}
