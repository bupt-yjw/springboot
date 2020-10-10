package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiyongjun on 2020/7/9
 * 这个文章从全排列来分析回溯，讲的十分透彻。值得学习。
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 * https://leetcode.com/problems/permutations/submissions/
 */
public class Permutations_46 {

    public static void main(String[] a) {
        permute(new int[]{1,2,3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(len ==0) {
            return result;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dsf(nums, path, 0,used,len, result);
        return result;
    }

    private static void dsf(int[] nums, List<Integer> path, int depth, boolean[] used, int len,
            List<List<Integer>> result) {
        if(depth == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i< len;i++) {
            if(!used[i]) {
                path.add(nums[i]);
                used[i] =true;
                dsf(nums, path, depth+1, used, len,result);
                used[i] =false;
                path.remove(path.size()-1);
            }

        }
    }

}
