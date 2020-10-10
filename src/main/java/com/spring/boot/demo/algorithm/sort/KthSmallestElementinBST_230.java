package com.spring.boot.demo.algorithm.sort;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 可以使用BST 的中序遍历是升序序列。 二叉树中搜索第K小个元素
 */
public class KthSmallestElementinBST_230 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //使用非递归的方式
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }


    private int count;
    private int result;
    //递归
    public int kthSmallestD(TreeNode root, int k) {
        count = 0;
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        inOrder(root.left, k);
        count ++;
        if(k == count) {
            result = root.val;
        } else {
            inOrder(root.right, k);
        }
    }
}

