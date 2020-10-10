package com.spring.boot.demo.algorithm.june;

/** TODO
 * Created by weiyongjun on 2020/6/17
 *
 * 最优的方法就是使用动态规划，可以分析题目：
 第一步，我们找到此问题的递归关系，强盗有两种选择：
 a）抢劫当前的房子i
 b）不抢劫当前的房子i
 如果选择选项“a”，则意味着无法抢夺之前的i-1房屋，但可以安全地前往前一个i-2之前的房屋并获得随后的所有累积战利品。
 如果选择了一个选项“b”，强盗将从抢劫i-1和剩下所有建筑物中获得所有可能的战利品。
 因此，利益最大的结果就有两种可能：
 1）抢劫当前房屋 + 前一次房屋抢劫
 2）从之前的房屋抢劫和之前捕获的任何战利品中掠夺

 对此，可以得出以下公式：
 rob(i) = Math.max( rob(i-2) + currentHouseValue, rob(i-1) )
 *
 * 但是直接实现，存在大量重复计算，可以使用备忘录来记录临时数据，或者使用两个临时变量来记录。因为你实际每次只用到i-1和i-2的值
 https://leetcode.com/problems/house-robber/submissions/
 * 参考链接：https://www.cnblogs.com/xiaochuan94/p/10042155.html
 */
public class houseRobber_198 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }
        return prev1;
    }



}
