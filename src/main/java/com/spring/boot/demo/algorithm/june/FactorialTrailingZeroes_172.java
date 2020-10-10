package com.spring.boot.demo.algorithm.june;

/**
 *
 * Created by weiyongjun on 2020/6/10
 * 参考链接：https://www.cnblogs.com/xiaochuan94/p/10018410.html
 * 题目求的是n！尾部包含多少个5。通过找规律可以实现
 *
 */
public class FactorialTrailingZeroes_172 {

    //这是最简洁的方法
    public int trailingZeroes(int n) {
        return n == 0? 0: n/5+ trailingZeroes(n/5);
    }

    //使用循环也可以实现
    public int trailingZeroes3(int n) {
        int result = 0;
        while (n>0) {
            result += n/5;
            n /= 5;
        }
        return result;
    }

}
