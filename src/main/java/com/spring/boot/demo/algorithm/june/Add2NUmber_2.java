package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/22
 * https://leetcode.com/problems/add-two-numbers/submissions/
 * 需要考虑到进位的情况
 */
public class Add2NUmber_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = head;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int count = x + y + carry;
            carry = count / 10;
            curr.next = new ListNode(count % 10);
            curr = curr.next;
            if(p1!= null) {
                p1 = p1.next;
            }
            if(p2!=null) {
                p2 = p2.next;
            }
        }
        if(carry == 1){//要考虑到只进位的情况
            curr.next = new ListNode(1);
        }
        return head.next;
    }

    //代码更简洁，没有使用进位的变量
    public ListNode addTwoNumbersV(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1) {
            d.next = new ListNode(1);
        }
        return sentinel.next;
    }

}
