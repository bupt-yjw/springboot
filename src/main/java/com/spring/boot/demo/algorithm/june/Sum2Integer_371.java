package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/20
 * 题目要求不能使用+操作，那么就是典型的使用位运算。
 * 关于位运算的分析可以参考文档的前两个解释。https://leetcode-cn.com/problems/sum-of-two-integers/solution/0msfu-xian-ji-suan-ji-zui-ji-ben-de-jia-fa-cao-zuo/
 * https://leetcode.com/problems/sum-of-two-integers/submissions/
 *
 */
public class Sum2Integer_371 {

    public int getSum(int a, int b) {
        if(a==0) {
            return b;
        }
        if(b==0) {
            return a;
        }
        int lower=0;
        int carrier = 0;
        while (true) {
            lower = a^b;//计算低位
            carrier = a&b;//计算进位
            if(carrier == 0) {//进位为0 结束循环
                break;
            }
            a = lower;
            b = carrier<<1;
        }
        return lower;
    }

}
