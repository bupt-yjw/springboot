package com.spring.boot.demo.algorithm.june;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**TODO 想到了第一种方法，但是没具体实现，还是需要重新看看。
 * Created by weiyongjun on 2020/6/22
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 * 可以参考中文版的前两种解释。
 *
 * 使用map或者set都可以实现
 *
 *
 *
 */
public class LongestSubstringWithoutRepeatingChar_3 {


    //自己的思路是，找最长字串，每次都往后添加一个字符，判断当前的最长字串，同时记录最大长度。跟滑动窗口的思路是差不多的。但是滑动窗口是使用一个hashset来存储的，
    //不想我的方法，每次都要使用contains和substring 方法。效率会高很多。因为最长字串无所谓顺序，所以用Hashset代替contains方法，效率会高很多哦。
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        String subStr="";
        for(int i =0;i < s.length();i++) {
            subStr = longestSubstring(subStr,s.charAt(i));
            maxLen = maxLen> subStr.length()? maxLen:subStr.length();
        }
        return maxLen;
    }

    private static String longestSubstring(String s, Character c) {
        if(s.contains(c.toString())) {
            return s.substring(s.indexOf(c.toString())+1)+ c;
        }
        return s+c;
    }

    //使用set的最优实现 set 这个方法就不用看了。掌握2个方法就够了。
    public int lengthOfLongestSubstringS(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    //使用Map的最优实现
    public static int lengthOfLongestSubstringVa(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;//需要left 去记录最大字串的左开头，右结尾是记录在map中的
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String[] a) {
    String ds = "abba";
        System.out.println(lengthOfLongestSubstringVa(ds));
    }



}
