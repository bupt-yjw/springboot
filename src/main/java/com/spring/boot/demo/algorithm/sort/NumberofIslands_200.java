package com.spring.boot.demo.algorithm.sort;

/** 岛屿数量
 *
 * 我们可以将二维网格看成一个无向图，竖直或水平相邻的1之间有边相连。
 为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为1，则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，每个搜索到的1 都会被重新标记为0
 最终岛屿的数量就是我们进行深度优先搜索的次数。

 https://leetcode.com/problems/number-of-islands/submissions/

 https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/

 */
public class NumberofIslands_200 {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int cl = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cl; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    //深度优先遍历将1变成0
                    numIslands(grid, i, j, row, cl);
                }
            }
        }
        return count;
    }

    private void numIslands(char[][] grid, int i, int j, int row, int cl) {
        if(i<0 || j< 0 || i>= row || j>= cl || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        numIslands(grid, i-1, j ,row, cl);
        numIslands(grid, i+1, j ,row, cl);
        numIslands(grid, i, j-1 ,row, cl);
        numIslands(grid, i, j+1 ,row, cl);
    }
}
