package com.spring.boot.demo.algorithm.june;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 有递归和迭代2种实现方式，我们就用递归实现就可以了。
 * Created by weiyongjun on 2020/8/10
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
    Map<Integer, Integer> indexMap;


    public static void main(String[] a) {
     ConstructBinaryTreefromPreorderandInorderTraversal_105 s= new ConstructBinaryTreefromPreorderandInorderTraversal_105();
     s.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
    public  TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0,n-1, 0, n-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if(preorderLeft > preorderRight) {
            return null;
        }
        int rootVal = preorder[preorderLeft];
        int inorderoot = indexMap.get(rootVal);
        int len = inorderoot - inorderLeft;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, inorder, preorderLeft+1, preorderLeft+len, inorderLeft, inorderoot-1);
        root.right = buildTree(preorder, inorder, preorderLeft+len+1, preorderRight, inorderoot+1, inorderRight);
        return root;
    }

    //跟上面代码逻辑是一样的，这个就是注释多一点
    public TreeNode myBuildTreeB(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTreeB(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTreeB(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }


}
