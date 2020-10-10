package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/20
 * 这个题比较简单，没什么好说的
 * https://leetcode.com/problems/reverse-string/submissions/
 */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        int start = 0, end = s.length;
        char temp ;
        while (start<end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++; end --;
        }
    }

}
