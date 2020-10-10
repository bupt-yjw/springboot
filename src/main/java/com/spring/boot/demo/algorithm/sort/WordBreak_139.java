package com.spring.boot.demo.algorithm.sort;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
 * 用动态规划，重点还是写出状态转移方程
 * Created by weiyongjun on 2020/8/14
 */
public class WordBreak_139 {

    //dp[i]=dp[j] && check(s[j..i−1])
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s== null) {
            return true;
        }
        Set<String> set = new HashSet<>();
        for(String word: wordDict) {
            set.add(word);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i =1; i<= s.length();i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
