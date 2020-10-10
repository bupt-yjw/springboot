package com.spring.boot.demo.algorithm.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 两种写法。递归的方法太复杂，这里就不看了。 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
 *
 * 采用一个map来记录每个节点的父节点，然后从p节点往上找到所有父节点，记录在set里面。
 * 之后访问q节点的所有父节点。存在记录里面的就是最近的父节点。
 *
 *
 * Created by weiyongjun on 2020/8/29
 */
public class LowestCommonAncestorofBinaryTree_236 {

    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dsf(root);
        while (p != null) {
            visited.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    private void dsf(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left.val, root);
            dsf(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dsf(root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
