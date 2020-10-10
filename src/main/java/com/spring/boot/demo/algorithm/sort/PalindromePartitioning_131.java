package com.spring.boot.demo.algorithm.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
 * 需要用到回溯
 * Created by weiyongjun on 2020/8/13
 */
public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if(s== null){
            return res;
        }
        Deque<String> path = new ArrayDeque();
        backtracking(s, 0, len, path, res);
        return res;
    }

    private void backtracking(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if(start == len) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < len; i++) {
            if(!isPalindrome(s, start, i)) {
                continue;
            }
            path.addLast(s.substring(start, i+1));
            backtracking(s, i+1, len, path, res);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
        return true;

    }

}
