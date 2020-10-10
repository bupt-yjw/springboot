package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/20
 * 思路：该题一共有四种方法。我的实现是第二种。 这道题要注意的点是0-n个数的长度是n+1，而原始数组的长度是n
 * 1。排序，然后比较相邻的数字O(nlogn)的时间复杂度和O(1)的空间复杂度
 * 2。借用数组或hashset存储，O(n)和O(n)的时间和空间复杂度。
 * 3。采用位运算
 * 4。数学公式的，高斯求和公式
 * 3，4两种方式都是比较巧妙的
 * https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/
 *
 * https://leetcode.com/problems/missing-number/submissions/
 */
public class MissingNumber_268 {

    public int missingNumber(int[] nums) {
        if(nums== null || nums.length == 0) {
            return 0;
        }
        int[] count = new int[nums.length+1];
        for(int num : nums) {
            count[num] =1;
        }
        for(int i=0;i< nums.length+1;i++) {
            if(count[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}
