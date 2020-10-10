package com.spring.boot.demo.algorithm.june;


/**
 * Created by weiyongjun on 2020/6/10
 * 思路：使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 思路想到了，但是没做代码实现
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if(head==null) {
            return false;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2!=null && l2.next!=null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if(l1==l2) {
                return true;
            }
        }
        return false;
    }

}
