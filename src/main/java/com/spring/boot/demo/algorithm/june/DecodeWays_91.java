package com.spring.boot.demo.algorithm.june;

/**
 * https://leetcode-cn.com/problems/decode-ways/solution/dong-tai-gui-hua-java-python-by-liweiwei1419/
 * 动态规划，重点是要能列出状态转移方程
 * Created by weiyongjun on 2020/8/8
 */
public class DecodeWays_91 {
    public int numDecodings(String s) {
        int len = s.length();
        if(len ==0 ){
            return 0;
        }

        // dp[i] 以 s[i] 结尾的前缀˜子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if s[i] != '0'  不等于0 主要是考虑到，如 5107 这种情况，10是不能分开的。
        // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
        int[] dp = new int[len];
        char[] chars = s.toCharArray();
        if(chars[0] =='0') {
            return 0;
        }
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if(chars[i] !='0') {
                dp[i] = dp[i-1];
            }
            int num = 10 * (chars[i-1]-'0') + (chars[i] -'0');

            if(num >=10 && num <=26) {
                if(i==1) {
                    dp[i]++;
                } else {
                    dp[i] +=dp[i-2];
                }

            }
        }
        return dp[len-1];
    }

}
