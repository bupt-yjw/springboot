package com.spring.boot.demo.algorithm.june;

import java.util.Arrays;

/**
 * Created by weiyongjun on 2020/6/20
 * 思路：自己的思路基本是最优的，但是还有几个地方可以优化。首先不能使用s.toCharArray()，
 * 因为在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费O(n)额外的空间
 * 同时应该先进行长度判断，在走后续流程，另外通过一次for循环就可以完成对两个字符串的加减。
 * 另外也可以使用排序，然后比较两个字符串是否相等。时间复杂度为：：O(nlogn)
 *
 * https://leetcode.com/problems/valid-anagram/submissions/
 * 参考文档：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
 */
public class ValidAnagram_242 {


    //自己的实现，代码有些不完美
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()) {
            arr[c-'a'] = arr[c-'a']+1;
        }
        for(char c: t.toCharArray()) {
            arr[c-'a'] = arr[c-'a']-1;
        }
        for(int i : arr) {
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    //最优实现，和自己思路是一样的，不过代码更简洁、严谨
    public boolean isAnagramB(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    //通过排序来实现
    public boolean isAnagramC(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


}
