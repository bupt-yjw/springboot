package com.spring.boot.demo.algorithm.june;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by weiyongjun on 2020/8/10
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-j-3/
 * 有只用O(1)就能实现的复杂度，具体实现参考链接就可以了。
 */
//相当于每一层的最后一个节点next指向null，采用层序遍历就可以实现。
public class PopulatingNextRightPointersinEachNode_116 {

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
               Node node=  queue.poll();
                if(i < size-1) {//非最后一个节点，将next指向下一个queue的值。
                    node.next= queue.peek();
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }

            }
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
