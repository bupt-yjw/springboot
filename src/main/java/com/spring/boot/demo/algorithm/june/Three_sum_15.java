package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** TODO:难点在于排序之后，如何跳过哪些重复的值，需要两个地方都做跳值的判断。
 * 本题目的是找到三数之和为0 的所有不重复结果。 可以通过排序来解决重复问题。
 * 同时把三数之和转换成求2数之和为指定值的结果。其中涉及到两次判断跳过重复值的处理， 详细的思路可以参考题解。
 * Created by weiyongjun on 2020/6/29
 * https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 * https://leetcode.com/problems/3sum/submissions/
 */

public class Three_sum_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {//因为是排序的，当前值大于0时，后续值之和肯定不会是负数
                return lists;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {//跳过重复的值，即如果前一个值已经计算过。当前值等于前一值的所有结果都已经包含了。
                continue;
            }
            twoSum(lists, nums[i], nums, i + 1, nums.length-1);
        }
        return lists;
    }

    private static void twoSum(List<List<Integer>> lists, int num, int[] nums, int start, int end) {
        while (start < end) {
            if (num + nums[start] + nums[end]==0) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                list.add(nums[start]);
                list.add(nums[end]);
                lists.add(list);
                while (start<end && nums[start] == nums[start + 1]) {//此时num值固定，另外两个值的重复值也需要跳过。
                    start++;
                }
                start++;
                while (start<end && nums[end] == nums[end - 1]) {
                    end--;
                }
                end--;
            } else if (num < nums[start] + nums[end]) {
                end--;
            } else {
                start++;
            }
        }
    }

    //这是另外一个写法，思路是完全一样的，只是代码实现不一样
    public List<List<Integer>> threeSumV(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }

    public static void main(String[] a) {
        threeSum(new int[]{-0,0,0});
    }

}
