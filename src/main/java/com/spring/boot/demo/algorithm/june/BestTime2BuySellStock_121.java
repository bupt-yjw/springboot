package com.spring.boot.demo.algorithm.june;


/**
 * TODO：again
 * Created by weiyongjun on 2020/6/5
 * 思路：自己想的是双向指针，从左到右找最小，从右往左找最大。这样的思路是不对的。因为不能同时进位。比如从左到右找最小，可能会跳过最大值。
 * 最优方法：从左往右循环，第一个点是买入点，依次往后比较，比他大，则记一个挣得钱数，比他小，则认为该点买入更合适。同时我们挣得钱数先不变，只有遇到比他挣得更多的才做变更。
 */
public class BestTime2BuySellStock_121 {


    //自己的方法是跑不通的
    public static int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int start = 0;int end = prices.length-1;
        while (start <= end) {
            if(prices[start] < min) {
                min = prices[start];
            }
            if(prices[end] > max) {
                max = prices[end];
            }
            start++; end --;
        }
        return max> min? max-min: 0;
    }

    /**
     * best method,这个方法在leedcode上的执行速度并不快
     */
    public int maxProfitB(int[] prices) {
        int profit = 0;
        if(prices.length==0) {
            return profit;
        }
        int bought = prices[0];
        for(int i=1;i< prices.length;i++) {
            if(bought < prices[i]) {
                if(profit <  prices[i]-bought) {
                    profit = prices[i]-bought;
                }
            } else {
                bought = prices[i];
            }
        }
        return profit;
    }
    //是maxProfitB 方法的变形，思路是一样的，代码更加简洁
    //min记录访问到当前的所有元素中的最小值，max记录卖出时的最大收益
    public static int maxProfitV(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] a) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

}
