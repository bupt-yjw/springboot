package com.spring.boot.demo.algorithm.june;

/**
 * https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
 * Created by weiyongjun on 2020/8/7
 */
public class UniquePaths_62 {

    //居然和自己四年前写的代码一模一样，😢
    public int uniquePaths(int m, int n) {

        int[][] res = new int[m][n];
        for(int i=0;i< m;i++) {
            res[i][0]=1;
        }
        for(int i=0;i< n;i++) {
            res[0][i]=1;
        }
        for(int i=1;i< n ;i++) {
            for(int j=1;j< m;j++) {
                res[j][i] = res[j-1][i]+res[j][i-1];
            }
        }
        return res[m-1][n-1];
    }
}
