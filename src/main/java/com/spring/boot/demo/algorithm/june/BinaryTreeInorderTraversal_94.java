package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
 * Created by weiyongjun on 2020/8/8
 */
public class BinaryTreeInorderTraversal_94 {

    List<Integer> list = new ArrayList<>();

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left);
            }
            list.add(root.val);

            if (root.right != null) {
                inorderTraversal(root.right);
            }
        }
        return list;
    }

    //迭代
    public List<Integer> inorderTraversalB(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;

        }
        return result;
    }
}
