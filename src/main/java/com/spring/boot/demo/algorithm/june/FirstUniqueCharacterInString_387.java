package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/20
 * 自己的思路就是最优解，这题比较简单，没啥多说的
 * https://leetcode.com/problems/first-unique-character-in-a-string/discuss/86348/Java-7-lines-solution-29ms
 */
public class FirstUniqueCharacterInString_387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i=0;i< s.length();i++) {
            char c = s.charAt(i);
            count[c-'a']++;
        }

        for(int i=0;i< s.length();i++) {
            char c = s.charAt(i);
            if(count[c-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
