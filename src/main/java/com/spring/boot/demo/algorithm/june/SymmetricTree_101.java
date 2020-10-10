package com.spring.boot.demo.algorithm.june;

import java.util.LinkedList;
import java.util.Queue;

/** TODO:again
 * Created by weiyongjun on 2020/6/2
 * https://leetcode.com/problems/symmetric-tree/submissions/
 * 参考文档：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
 * 思路：题目的意思是判断树是否为其镜像。也就是比较他的左右节点是否相等。对于第二层则是比较左的右节点和右的左节点是否相等。
 */
public class SymmetricTree_101 {

    //递归的实现方式
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        //先判断节点值是否一样，然后递归判断，一直到叶子节点
        if(left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left
                .right, right.left);
    }


    //迭代的方式
    public boolean isSymmetricD(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


}
