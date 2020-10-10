package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/18
 * 和190：ReverseBit的思路类似，甚至比190题更简单
 * https://leetcode.com/problems/number-of-1-bits/submissions/
 */
public class NumberOf1Bits_191 {

    public static int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }

    public static int hammingWeightV(int n) {
        int res = 0;
        for(int i=0;i<32;i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }
    public static void main(String[] a) {
        System.out.println(hammingWeightV(5));
        System.out.println(hammingWeight(5));
    }




}
