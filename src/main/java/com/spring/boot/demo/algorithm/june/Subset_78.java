package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多吊炸天的方法，这里就先不学习了。只列举循环和递归2种解法
 * Created by weiyongjun on 2020/8/8
 */
public class Subset_78 {

    //循环
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num: nums) {
            int len = res.size();//需要把res的size先存下来，不然后续循环往res 添加数据的时候会报错。
            for (int i = 0; i < len; i++) {
                List<Integer> newSub = new ArrayList<>(res.get(i));
                newSub.add(num);
                res.add(newSub);
            }
        }
        return res;
    }

    //递归
    public List<List<Integer>> subsetsB(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        subsetsB(nums, 0, res);

        return res;
    }

    private void subsetsB(int[] nums, int n, List<List<Integer>> res) {
        if(n >= nums.length) {
            return;
        }
        int size =res.size();
        for (int i = 0; i < size; i++) {
            List<Integer> newSub = new ArrayList<>(res.get(i));
            newSub.add(nums[n]);
            res.add(newSub);
        }
        subsetsB(nums,n+1, res);
    }

}
