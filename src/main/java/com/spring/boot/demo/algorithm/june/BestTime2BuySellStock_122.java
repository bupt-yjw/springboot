package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/5
 * 思路：自己的想法总是跟着特定case去考虑，导致实现的代码，只有部分case可以跑通，应该从case中找到规律，而不是为了实现特定的case。
 * 最佳思路：对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
 * 而 d - a = (d - c) + (c - b) + (b - a) ，因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，
 * 那么就把 prices[i] - prices[i-1] 添加到收益中，从而在局部最优的情况下也保证全局最优。
 */
public class BestTime2BuySellStock_122 {


    //自己把代码想复杂了，导致写起来总有case考虑不到。代码是错的，没有参考价值
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0) {
            return profit;
        }
        int bought = prices[0];
        for (int i=1;i< prices.length;i++) {
            if(bought < prices[i]) {
                if(i == prices.length-1 || prices[i]> prices[i+1]) {
                    profit += prices[i]-bought;
                }

                bought = prices[i+1];
            } else {
                bought= prices[i];
            }
        }
        return 0;
    }

    /**
     * best method
     */
    public int maxProfitB(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

}
