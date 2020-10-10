package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/5
 * 思路：没看清题目说的是含有字母和数字。自己最开始的方法没有考虑数字
 * 同时下面还列了一个比较偷巧的方法，可以参考下
 */
public class ValidPalindrome_125 {

    public  boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isStr(s.charAt(start))) {
                start++;
                continue;
            } else if (!isStr(s.charAt(end))) {
                end--;
                continue;
            } else {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;

    }

    private static boolean isStr(char c) {
        if (c <= 'z' && c >= 'a') {
            return true;

        } else if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    /**
     * leetcode上看到的一个比较投巧的方法，把所有非数字和字母的都替换成空，然后反转字符串，进行equals比较
     */
    public boolean isPalindromeV(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

}
