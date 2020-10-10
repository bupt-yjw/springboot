package com.spring.boot.demo.algorithm.june;

import java.util.Arrays;

/**https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
 * 思路是对数组先排序。则分为2种情况。如果当前数组的左值大于结果集的右值，则加入结果集。否则取两个数组的右值的最大值
 * Created by weiyongjun on 2020/8/7
 */
public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        Arrays.sort(intervals, (v1,v2) -> v1[0] - v2[0]);
        int index = -1;
        for(int i=0;i< intervals.length;i++) {
            if(index==-1 || result[index][1] < intervals[i][0]) {
                result[++index] = intervals[i];
            } else {
                result[index][1] = Math.max(result[index][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(result, index+1);
    }

}
