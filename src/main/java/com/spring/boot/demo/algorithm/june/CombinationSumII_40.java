package com.spring.boot.demo.algorithm.june;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created by weiyongjun on 2020/7/10
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 * 这个题和39题差不多，因为不允许重复使用，需要做小枝剪。具体分析可以看上面的链接
 * https://leetcode.com/problems/combination-sum-ii/submission˜s/
 */
public class CombinationSumII_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dsf(result, new ArrayDeque<>(), target, 0, candidates);
        return result;
    }

    private void dsf(List<List<Integer>> result, Deque<Integer> path, Integer residue, Integer index, int[] candidates) {
        if(residue == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i< candidates.length;i++) {
            if(residue - candidates[i] <0) {
                break;
            }
            if(i> index && candidates[i]== candidates[i-1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dsf(result, path, residue- candidates[i],i+1, candidates);
            path.removeLast();
        }

    }

}
