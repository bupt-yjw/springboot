package com.spring.boot.demo.algorithm.june;


import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
 * 递归和中序遍历2种方式。
 * Created by weiyongjun on 2020/8/8
 */
public class ValidateBinarySearchTree_98 {

    //递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null,null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root==null){
            return true;
        }
        int val = root.val;
        if(min!= null && val <= min) {
            return false;
        }
        if(max!= null && val >= max) {
            return false;
        }
        if(!isValidBST(root.right, val, max)) {
            return false;
        }
        if(!isValidBST(root.left, min, val)) {
            return false;
        }
        return true;
    }

    //中序
    public boolean isValidBSTZ(TreeNode root) {
        double lastVal = - Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!= null || !stack.isEmpty()) {
            while (curr!= null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            if(node.val <= lastVal) {
                return false;
            }
            lastVal = node.val;
            curr = node.right;
        }
        return true;
    }

}
