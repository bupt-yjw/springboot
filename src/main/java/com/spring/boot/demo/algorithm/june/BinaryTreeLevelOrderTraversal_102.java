package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 * Created by weiyongjun on 2020/8/8
 */
public class BinaryTreeLevelOrderTraversal_102 {

    /**
     * 首先根元素入队
     当队列不为空的时候
     求当前队列的长度 len
     依次从队列中取len个元素进行拓展，然后进入下一次迭代
     */
    //这个代码是理解了思路以后自己实现的。 也可以使用Queue来代替LinkedList
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len >0) {
                TreeNode node = queue.remove(0);
                list.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                len --;
            }
            result.add(list);
        }
        return result;
    }


}
