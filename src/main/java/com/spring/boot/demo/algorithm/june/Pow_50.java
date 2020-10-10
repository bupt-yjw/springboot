package com.spring.boot.demo.algorithm.june;

/**
 * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 * 迭代的方式这里就不学习了
 * Created by weiyongjun on 2020/8/6
 */
public class Pow_50 {

    //才有快速幂+递归实现，减少计算次数。
    public double myPow(double x, int n) {
        long N =n;
        return N>= 0? quickMul(x, N): 1.0/quickMul(x,-N);
    }

    public double quickMul(double x, long N) {
        if(N==0) {
            return 1.0;
        }
        double res = quickMul(x, N/2);
       return N % 2 == 1? res*res*x: res*res;
    }
}
