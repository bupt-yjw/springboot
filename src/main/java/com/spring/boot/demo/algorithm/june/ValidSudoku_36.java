package com.spring.boot.demo.algorithm.june;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by weiyongjun on 2020/7/7
 * https://leetcode-cn.com/problems/valid-sudoku/solution/you-xiao-de-shu-du-by-leetcode/
 * leedcode中文的解法，丑的一逼，按行列块定义了27个hashmap，遍历二维数组往map中放值，每放一个数就校验一个数的value是否大于1。
 * 同时要理解计算单独小块的方法
 *
 * leedcode 上的最佳解法，利用set，对行、列、块添加字符标示。放入的时候，根据add的返回值就可以实现判断，代码很简洁易懂
 *
 */
public class ValidSudoku_36 {

    //leedcode上的方法,不过执行速度较慢
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudo = new HashSet<>();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                char num = board[i][j];
                if(num!= '.') {
                    if(!sudo.add( num + "in row " + i) ||
                            !sudo.add(num+ "in col " + j) ||
                            !sudo.add(num+ "in block " + i/3+"-"+j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuC(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
