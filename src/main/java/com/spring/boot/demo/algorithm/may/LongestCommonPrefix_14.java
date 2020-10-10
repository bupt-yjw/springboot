package com.spring.boot.demo.algorithm.may;

/**
 *
 * 总结：自己的思路就是笨办法，需要两次for循环，挨个判断，没有转变过想法，所以没有开发自己的想法，而是直接看的最优方法。
 * 最优方法：首先找最长公共前缀，那我们可以假定数组第一个字符串就是最长前缀，然后用while循环通过indexof来判断
 * 第二个字符串的开头是不是第一个字符串，如果是，就确定了前两个字符串的最大公共长度，然后那这个跟第三个继续比较。
 * 如果不是，则将最长公共长度减1 在做比较。
 *
 * Created by weiyongjun on 2020/5/19
 */
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0) {
            return "";
        }
        String commonPrefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (!strs[i].startsWith(commonPrefix)) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length()-1);
            }
            i++;
        }
        return commonPrefix;
    }

    /**
     * best method
     * @param strs
     * @return
     */
    public String longestCommonPrefixB(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        return pre;
    }
}
