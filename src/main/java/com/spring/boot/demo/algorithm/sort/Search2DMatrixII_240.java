package com.spring.boot.demo.algorithm.sort;

/**
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
 * https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
 * 解法比较多，把握一种比较优的方法就可以了。
 * Created by weiyongjun on 2020/8/29
 */
public class Search2DMatrixII_240 {

    //从左下角开始，小于目标值，右移，大于目标值 上移
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if(matrix[row][col] == target) {
                return true;
            }
            if(matrix[row][col] > target) {
                row--;
            } else {
                col ++;
            }
        }
        return false;
    }



}
