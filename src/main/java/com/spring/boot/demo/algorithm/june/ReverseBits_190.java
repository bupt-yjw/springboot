package com.spring.boot.demo.algorithm.june;

/**
 * TODO
 * Created by weiyongjun on 2020/6/11
 * 自己对于位运算并不是很熟练
 * 具体可以参考leetcode-cn的讲解。https://leetcode-cn.com/problems/reverse-bits/solution/zhi-qi-ran-zhi-qi-suo-yi-ran-wei-yun-suan-jie-fa-x/
 *
 * https://leetcode.com/problems/reverse-bits/submissions/
 */
public class ReverseBits_190 {

    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++) {
            res = (res<< 1) + (n&1);
            n>>=1;
        }
        return res;
    }

}
