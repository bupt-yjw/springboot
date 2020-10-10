package com.spring.boot.demo.algorithm.june;

/**TODO:主要在看下定义几个ListNode
 * Created by weiyongjun on 2020/6/30
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
 * 题目有2种解法，一是使用两次循环。二是使用两个指针，一次循环即可。
 * 重点在于我们要设置一个哑节点，来应对链表只有一个节点及移除链表头部等特殊情况。
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 */
public class RemoveNthNodeFromEndList_19 {

    //使用2次循环的实现
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        int length = 0;
        ListNode first = head;
        while (first!= null) {
            length++;
            first = first.next;
        }
        length = length-n;
        first = temp;
        while (length>0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return temp.next;
    }

    //使用一次循环
    public ListNode removeNthFromEndB(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode first = temp;
        ListNode second = temp;
        for(int i=0;i<=n;i++) {//注意这里是小于等于，要走n+1步，两个指针才相差n步，具体的可以在图纸上画一下看看
            first = first.next;
        }
        while (first!=null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return temp.next;
    }

}
