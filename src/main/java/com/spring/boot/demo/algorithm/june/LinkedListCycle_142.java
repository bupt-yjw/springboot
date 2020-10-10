package com.spring.boot.demo.algorithm.june;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO:again
 * 参考：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
 *
 * Created by weiyongjun on 2020/8/1
 */
public class LinkedListCycle_142 {


    //没有借助辅助空间
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode meetNode = getMeetNode(head);
        if (meetNode == null) {
            return null;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = meetNode;

        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    private ListNode getMeetNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }

    //借助辅助空间
    public ListNode detectCycleB(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;
    }


}
