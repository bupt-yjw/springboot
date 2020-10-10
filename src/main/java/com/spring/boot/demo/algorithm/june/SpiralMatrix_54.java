package com.spring.boot.demo.algorithm.june;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/solution/cxiang-xi-ti-jie-by-youlookdeliciousc-3/
 * Created by weiyongjun on 2020/8/7
 */
public class SpiralMatrix_54 {

    /**
     * 这里的方法不需要记录已经走过的路径，所以执行用时和内存消耗都相对较小
     首先设定上下左右边界
     其次向右移动到最右，此时第一行因为已经使用过了，可以将其从图中删去，体现在代码中就是重新定义上边界
     判断若重新定义后，上下边界交错，表明螺旋矩阵遍历结束，跳出循环，返回答案
     若上下边界不交错，则遍历还未结束，接着向下向左向上移动，操作过程与第一，二步同理
     不断循环以上步骤，直到某两条边界交错，跳出循环，返回答案
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if(matrix.length == 0) {
            return result;
        }
        int left = 0; int up = 0; int right = matrix[0].length-1; int down = matrix.length-1;
        while (true) {
            for(int i=left; i<= right;i++) {
                result.add(matrix[up][i]);
            }
            if(++ up > down) {
                break;
            }
            for(int j=up;j<= down;j++) {
                result.add(matrix[j][right]);
            }
            if(--right < left){
                break;
            }
            for(int k=right;k>= left;k--) {
                result.add(matrix[down][k]);
            }
            if(--down < up) {
                break;
            }
            for(int l = down;l >= up;l--) {
                result.add(matrix[l][left]);
            }
            if(++left > right){
                break;
            }

        }
        return result;
    }

}
