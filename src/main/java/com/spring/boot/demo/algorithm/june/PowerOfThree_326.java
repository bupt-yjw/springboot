package com.spring.boot.demo.algorithm.june;


/**
 * Created by weiyongjun on 2020/6/20
 * 该题可以使用循环或递归，如果不使用两种方式，则需要较强的数学知识点。
 * 可参考如下链接：https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode/
 * https://leetcode.com/problems/power-of-three/submissions/
 */
public class PowerOfThree_326 {


    //对应链接的方法1
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //对应链接的方法4
    public boolean isPowerOfThreeC(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}

