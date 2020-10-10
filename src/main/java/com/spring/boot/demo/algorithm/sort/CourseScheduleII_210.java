package com.spring.boot.demo.algorithm.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 课程表，跟207题思路一样，就是实现上稍微有点差距
 * https://leetcode.com/problems/course-schedule-ii/submissions/
 *
 * https://leetcode-cn.com/problems/course-schedule-ii/solution/tuo-bu-pai-xu-shen-du-you-xian-bian-li-python-dai-/
 *
 *
 * Created by weiyongjun on 2020/8/29
 */
public class CourseScheduleII_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int finish = 0;
        //入度数为0的队列
        Queue<Integer> queue = new LinkedList<>();
        //每个课程的入度数
        int[] count = new int[numCourses];
        //每个课程的出度数，即记录完成该课程，就可以将对应其他课程的入度数减 1
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for(int[] a : prerequisites) {
            count[a[0]] ++;
            lists.get(a[1]).add(a[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(count[i] == 0) {
                queue.add(i);
            }
        }
        while (! queue.isEmpty()) {
            int pre = queue.poll();
            result[finish] = pre;
            finish ++;
            for(int num : lists.get(pre)) {
                if(--count[num] == 0) {
                    queue.add(num);
                }
            }
        }
        if(numCourses == finish) {
            return result;
        }
         return new int[0];



    }

}
