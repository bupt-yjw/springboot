package com.spring.boot.demo.algorithm.june;

/**TODO:在看的时候可以看下能不能想起思路。
 * Created by weiyongjun on 2020/6/29
 * https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
 * 本题的最佳解法就是使用双向指针，然后每次移动较小的值。至于为什么这么移动，可以看上面的题解
 * https://leetcode.com/problems/container-with-most-water/submissions/
 *
 */
public class ContainerWithMostWater_11 {

    public int maxArea(int[] height) {
        int left = 0;int right = height.length-1;
        int res = 0;
        while (left< right) {
            int area = Math.min(height[left], height[right])* (right-left);
            res = res > area? res:area;
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    //这个代码更精简，通过一次对比，直接完成计算和++ 操作
    public int maxAreaB(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

}
