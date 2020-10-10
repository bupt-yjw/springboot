package com.spring.boot.demo.algorithm.june;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created by weiyongjun on 2020/7/10
 * https://leetcode.com/problems/combination-sum/submissions/
 * 参考的思路：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 *
 */
public class CombinationSum_39 {


    //按照加法的思路实现的
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dsf(result, new ArrayDeque<>(), 0,0, target, candidates);
        return result;
    }

    private void dsf(List<List<Integer>> result, Deque<Integer> path, int sum, int index, int target, int[] candidates) {
        if(sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=index;i < candidates.length;i++) {
            if(sum+ candidates[i] > target) {
                break;
            }
            path.addLast(candidates[i]);
            dsf(result, path, sum+candidates[i], i, target, candidates);
            path.removeLast();
        }
    }

    //按照减法来实现
    public List<List<Integer>> combinationSumD(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        // 排序是为了提前终止搜索
        Arrays.sort(candidates);

        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs(int[] candidates,
            int len,
            int residue,
            int begin,
            Deque<Integer> path,
            List<List<Integer>> res) {
        if (residue == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {

            // 在数组有序的前提下，剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, residue - candidates[i], i, path, res);
            path.removeLast();

        }
    }

}
