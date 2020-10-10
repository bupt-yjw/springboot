package com.spring.boot.demo.algorithm.june;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by weiyongjun on 2020/8/7
 */
public class SetMatrixZeroes_73 {
    public static void main(String[] a) {
    int[][] re = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    setZeroes(re);
    }

    public static void setZeroes(int[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> clos = new HashSet<>();
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    clos.add(j);
                }
            }
        }
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                if(rows.contains(i) || clos.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

}
