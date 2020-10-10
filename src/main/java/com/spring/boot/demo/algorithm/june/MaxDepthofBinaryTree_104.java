package com.spring.boot.demo.algorithm.june;


/**
 * Created by weiyongjun on 2020/6/2
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
 * 总结：自己的方法代码不够简洁，且存在重复计算
 */
public class MaxDepthofBinaryTree_104 {
    /**
     * 自己的思路也是根据上一道 SymmetricTree来的，但是效率不高，超了执行时间
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //其实自己不需要在这做return 1 操作
        if(root.left == null && root.right == null) {
            return 1;
        }
        //自己maxDepth的值应该用临时变量存下来，不然是重复计算
        return maxDepth(root.left)>maxDepth(root.right) ? maxDepth(root.left)+1:maxDepth(root.right)+1;
    }


    /**
     * 这是自己四年前的方法
     */
    public int maxDepthB(TreeNode root) {
        if(root == null) {
            return 0;
        } else{
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return l>r?l+1:r+1;
        }
    }

    /**
     *
     * 这是leetcode上的方法，更简洁
     * @param root
     * @return
     */
    public int maxDepthV(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}
