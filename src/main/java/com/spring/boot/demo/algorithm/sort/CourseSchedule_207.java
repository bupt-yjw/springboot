package com.spring.boot.demo.algorithm.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表
 * 可以只关注广度优先遍历的方法，涉及到入度、出度的概念。理解了思路实现还是可以的。主要就是判断有向图是否有环
 * https://leetcode-cn.com/problems/course-schedule/solution/ke-cheng-biao-by-leetcode-solution/
 * 可以直接参考视频题解
 * Created by weiyongjun on 2020/8/28
 */
public class CourseSchedule_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null) {
            return true;
        }
        //用来存储入度数为0的课程。入度数为0的课程说明可以学习，对其他课程没有依赖
        Queue<Integer> queue = new LinkedList<>();

        //存储每个课程的入度数，即学习这个课程需要先学习的课程数
        int[] indegrees = new int[numCourses];
        //记录每个课程的出度课，即完成该课程以后，对indegrees这个数组的入度数减1
        List<List<Integer>> list = new ArrayList<>();
        //初始化
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] a : prerequisites) {
            indegrees[a[0]] ++;
            list.get(a[1]).add(a[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses --;
            for(int cur: list.get(pre)) {
                if(--indegrees[cur] == 0) {
                    queue.offer(cur);
                }
            }
        }
        return numCourses == 0;
    }
}
