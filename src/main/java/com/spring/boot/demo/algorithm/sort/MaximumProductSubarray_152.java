package com.spring.boot.demo.algorithm.sort;

/**
 * 乘积最大子数组
 https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/  这个算法实现很简单，但是一般不容易想到
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/solution/dong-tai-gui-hua-li-jie-wu-hou-xiao-xing-by-liweiw/  这个是动态规划的具体解法，也是挺不容易想到状态转移方程的
 *
 *
 */
public class MaximumProductSubarray_152 {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE ;
        int cmax = 1;
        int cmin = 1;
        for(int num: nums) {
            if(num < 0) {
                int temp = cmax;
                cmax = cmin;
                cmin = temp;
            }
            cmax = Math.max(cmax * num, num);
            cmin = Math.min(cmin* num, num);
            max = Math.max(cmax, max);
        }
        return max;
    }

}
