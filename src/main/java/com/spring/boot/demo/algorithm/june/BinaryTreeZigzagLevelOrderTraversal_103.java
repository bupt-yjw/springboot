package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/er-cha-shu-de-ju-chi-xing-ceng-ci-bian-li-by-leetc/
 * 题目要求实现锯齿形遍历。用linkedList更好实现，👎另一个变量标注奇偶。
 * Created by weiyongjun on 2020/8/10
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        int level =0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0; i< size;i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                if((level & 1)== 0) {
                    list.add(node.val);
                } else {
                    list.push(node.val);
                }
            }
            result.add(list);
            level++;

        }
        return result;

    }

}
