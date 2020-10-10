package com.spring.boot.demo.algorithm.sort;

/** 除以自身以外的数组乘积
 * 题目要求不能使用除法。使用使用除法不能处理数组里包含0的情况
 * 思路是搞两个数组，分别记录i位置左右两边的数组乘积。同时可以优化成只需要O(1)的空间复杂度来完成
 *
 * https://leetcode-cn.com/problems/product-of-array-except-self/solution/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/
 *
 * https://leetcode.com/problems/product-of-array-except-self/submissions/
 * Created by weiyongjun on 2020/8/29
 */
public class ProductofArrayExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[len];
        int[] R = new int[len];
        int[] result = new int[len];
        L[0] =1; R[len-1] = 1;
        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        for(int i=1;i < len;i++) {
            L[i] = L[i-1] * nums[i-1];
        }
        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        for(int i=len-2; i>=0;i--) {
            R[i] = R[i+1]* nums[i+1];
        }
        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < len ; i++) {
            result[i] = L[i] * R[i];
        }
        return result;
    }

    //空间复杂度为O(1)的实现
    public int[] productExceptSelfN(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }


}
