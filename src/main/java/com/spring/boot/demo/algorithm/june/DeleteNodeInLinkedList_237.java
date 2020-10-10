package com.spring.boot.demo.algorithm.june;

/**很弱智的一道题
 * 这个题目要求删除链表里的某一个节点。但是只告诉我们要删除的节点。所以常规思路不行。
 * 具体参考：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/solution/tu-jie-shan-chu-lian-biao-zhong-de-jie-dian-python/
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Created by weiyongjun on 2020/6/19
 */
public class DeleteNodeInLinkedList_237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
