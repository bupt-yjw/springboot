package com.spring.boot.demo.algorithm.sort;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
 * Created by weiyongjun on 2020/8/13
 */
public class SurroundedRegions_130 {
    //使用dsf深度遍历就可以。转变下思路，理解了题意还是挺简单的。
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {return;}
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boolean isEdge = i==0|| j==0|| i==r-1|| j==c-1;
                if(isEdge && board[i][j] == 'O') {
                    dsf(board, i ,j);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                //这2个if判断的顺序不能乱
                if(board[i][j] == 'O') {
                    board[i][j]= 'X';
                }
                if(board[i][j] == '#') {
                    board[i][j]= 'O';
                }
            }
        }

    }

    private void dsf(char[][] board, int i, int j) {
        //超了边界或者是X或者已经被标记，则直接返回
        if(i<0 || j< 0 || i>=board.length || j>= board[0].length || board[i][j]== '#'|| board[i][j]== 'X') {
            return;
        }
        board[i][j] ='#';//标为#号表示并没有被围住
        dsf(board, i+1,j);
        dsf(board, i-1,j);
        dsf(board, i,j+1);
        dsf(board, i,j-1);
    }
}
