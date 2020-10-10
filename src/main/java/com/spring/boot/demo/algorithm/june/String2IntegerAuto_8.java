package com.spring.boot.demo.algorithm.june;


/**
 * Created by weiyongjun on 2020/6/29
 * 题目不难，主要是要考虑超出Integer最大值时的处理。
 * res > (Integer.MAX_VALUE - digit) / 10 采用如下处理，因为*10 和+digit都有可能越界
 * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
 * https://leetcode.com/problems/string-to-integer-atoi/submissions/
 */

public class String2IntegerAuto_8 {
    public static int myAtoi(String str) {
        int res = 0;
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        int len = str.length();
        int index = 0;
        boolean flag = true;
        while (index < len && chars[index] == ' ') {
            index++;
        }
        if (index == len) {
            return res;
        }

        if (chars[index] == '-' || chars[index] == '+') {
            if (chars[index] == '-') {
                flag = false;
            }
            index++;
        }
        for (; index < len; index++) {
            if (Character.isDigit(chars[index])) {
                int digit = chars[index] - '0';
                if (res > (Integer.MAX_VALUE - digit) / 10) {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + digit;
            } else {
                break;
            }
        }

        return flag ? res : -res;
    }

        //最佳方法，跟我的实现思路差不多
    public int myAtoiB(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }

    public static void main(String[] a) {
        System.out.println(myAtoi("42"));
    }

}
