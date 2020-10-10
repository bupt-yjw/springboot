package com.spring.boot.demo.algorithm.june;

/**
 * 思路：一开始没看懂题目的意思，后来参考中文发现，数据末尾加1，然后输出数据，但是需要考虑进位的情况。
 * 另外不可以转成int或long来相加，因为数组超长会超限制。
 * Created by weiyongjun on 2020/6/2
 */
public class PlusOne_66 {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }


}
