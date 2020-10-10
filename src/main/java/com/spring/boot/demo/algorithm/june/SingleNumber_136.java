package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/10
 * 思路：题目要求线性时间内完成，且不能使用额外的空间，所以没有想到合适的方法。
 * 后来参考答案，发现使用异或运算就可以。
 * 两个相同的数异或的结果为 0，对所有数进行异或操作，最后的结果就是单独出现的那个数。
 * 异或：如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。

 */
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i:nums) {
            res = res^ i;
        }
        return res;
    }

    /**
     * 这是自己四年前写的方法
     */
    public int singleNumberB(int[] nums){
        int num=0;
        for(int i=0;i<nums.length;i++){
            num^=nums[i];
        }
        return num;
    }
}
