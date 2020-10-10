package com.spring.boot.demo.algorithm.june;

import java.util.Arrays;

/**
 * Created by weiyongjun on 2020/6/10
 * 思路：2种方法。首先可以对数据排序，然后去中间的数字，就是我们要的返回值。
 * 其次的描述在方法上，优先推荐这个方法
 * 另外一个参考文档：https://www.cnblogs.com/xiaochuan94/p/10011046.html
 */
public class MajorityElement_169 {

    /**
     * 可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
     * 可以这么理解该算法：使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素不相等时，令 cnt--。
     * 如果前面查找了 i 个元素，且 cnt == 0，说明前 i 个元素没有 majority，或者有 majority，
     * 但是出现的次数少于 i / 2，
     * 因为如果多于 i / 2 的话 cnt 就一定不会为 0。此时剩下的 n - i 个元素中，
     * majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
     */
    //这个代码还是要好好揣摩的
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int cnt =0;//cnt的值不会出现负数
        for(int num: nums) {
            majority = (cnt==0)? num: majority;
            cnt = (majority == num)? cnt+1:cnt-1;
        }
        return majority;
    }

    /**
     * 对数组排序，取中间数字
     */
    public int majorityElementV(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
