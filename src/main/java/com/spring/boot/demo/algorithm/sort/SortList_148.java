package com.spring.boot.demo.algorithm.sort;

import java.util.LinkedList;

/** 排序列表
 * 采用归并的方法来实现
 * Created by weiyongjun on 2020/8/20
 * https://leetcode.com/problems/sort-list/submissions/
 *
 * https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
 */
public class SortList_148 {


    //涉及到Node，主要的难点就在于怎么去变化next 的值
    //递归的实现,还有非递归的实现，
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if(left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = left != null? left: right;
        return res.next;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
