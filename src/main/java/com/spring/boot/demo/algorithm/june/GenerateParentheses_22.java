package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** TODO:直接看深度优先遍历的思路就可以了
 * Created by weiyongjun on 2020/6/30
 * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * 本题一共三种解法，深度优先、广度优先、动态规划
 *
 *
 */
public class GenerateParentheses_22 {

    List<String> list = new ArrayList<>();
    //深度优先的实现方式
    public  List<String> generateParenthesis(int n) {
        if (n == 0) {
            return list;
        }
        generateParenthesis("", n, n);
        return list;
    }

    private  void generateParenthesis(String s, int left, int right) {
        if(left==0&& right==0) {
            list.add(s);
            return;
        }
        if(left> right) {//遍历过程中，部分树枝要裁剪掉，因为不能出现右括号多余左括号的情况
            return;
        }
        if(left>0) {
            generateParenthesis(s+"(", left-1, right);
        }
        if(right>0) {
            generateParenthesis(s+")", left,right-1);
        }
    }


    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    //广度优先的实现方式
    public List<String> generateParenthesisD(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }


}
