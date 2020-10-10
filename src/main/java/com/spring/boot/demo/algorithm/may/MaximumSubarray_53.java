package com.spring.boot.demo.algorithm.may;


/**
 * Created by weiyongjun on 2020/5/26
 * 总结：
 * 参考这个文档，有四种解法。分别是暴力法，分治法，Kadane算法，和动态规划 https://www.cnblogs.com/jclian91/p/9151120.html
 */
public class MaximumSubarray_53 {

    public static void main(String[] a) {

        int[] aar = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArrayD(aar);
    }

    /**
     * 动态规划,实际就是记录一个已发现的最大值和当前最大值，一直循环遍历，即当curMaxSum变小时，不修改maxSum的值。
     * 变大时，才做替换
     */
    public static int maxSubArrayD(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curMaxSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            curMaxSum = Math.max(curMaxSum + nums[i], nums[i]);
            maxSum = Math.max(curMaxSum, maxSum);
        }
        return maxSum;
    }
    /**
     * 分治法
     * 分治法的具体逻辑可以参考上方总结里的链接
     */
    public int maxSubArrayB(int[] nums) {
        return Subarray(nums, 0, nums.length - 1);
    }

    public int Subarray(int[] A, int left, int right) {
        if (left == right) {
            return A[left];
        }
        int mid = left + (right - left) / 2;
        int leftSum = Subarray(A, left, mid);// left part
        int rightSum = Subarray(A, mid + 1, right);//right part
        int crossSum = crossSubarray(A, left, right);// cross part
        if (leftSum >= rightSum && leftSum >= crossSum) {// left part is max
            return leftSum;
        }
        if (rightSum >= leftSum && rightSum >= crossSum) {// right part is max
            return rightSum;
        }
        return crossSum; // cross part is max
    }

    public int crossSubarray(int[] A, int left, int right) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        for (int i = mid; i >= left; i--) {
            sum = sum + A[i];
            if (leftSum < sum) {
                leftSum = sum;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= right; j++) {
            sum = sum + A[j];
            if (rightSum < sum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
}
