package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/2
 * 总结：自己想着使用斐波那契，但是存在重复计算的情况，当n特别大时，会超出范围。
 * 所以想着使用一个数组来存储每个值的数据。但是存在空间的浪费。可以参考自己4年前写的方法，
 * 没有空间上的浪费。同时通过设置好初始化的值， 就不需要判断边界情况。
 */
public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[2] = 2;
        arr[1] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 这是自己四年前写的方法，没有使用数据，而且类似采用两个指针，分别往前进位。没有空间的浪费
     */
    public int climbStairsB(int n) {
        int a = 0;
        int b = 1;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num = a + b;
            a = b;
            b = num;
        }
        return num;
    }

    /**
     * 这是leetcode上的最佳方法，主要参考人家的方法命名，更容易理解一些
     */
    public int climbStairsV(int n) {
        // base cases
        if (n <= 2) {
            return n;
        }

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
