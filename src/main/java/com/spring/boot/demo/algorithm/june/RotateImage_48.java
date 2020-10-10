package com.spring.boot.demo.algorithm.june;

/**
 * https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode/
 * https://leetcode.com/problems/rotate-image/
 * 其他的方法都是扯淡了。先转置矩阵，然后翻转每一行。也可以找到规律以后实现，代码过于复杂，就不写了。
 * Created by weiyongjun on 2020/8/6
 */
public class RotateImage_48 {
    public static void main(String[] a) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(1);
    }

    //先转置矩阵，然后翻转每一行
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n<=1) {
            return;
        }
        //转置
        for(int i=0;i< n;i++) {
            for(int j=i+1;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //翻转每一行
       for(int i=0; i< n;i++) {
           for(int j=0;j< n/2;j++) {
               int temp = matrix[i][j];
               matrix[i][j] = matrix[i][n-j-1];
               matrix[i][n-j-1] = temp;
           }
       }
    }

}
