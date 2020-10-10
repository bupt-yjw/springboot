package com.spring.boot.demo.algorithm.june;


/** TODO：again
 * Created by weiyongjun on 2020/6/10
 * 自己一开始没想到这么写。直接看了参考答案
 * 要求：时间复杂度为 O(N)，空间复杂度为 O(1)
 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 */
public class Intersectionof2LinkedLists_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1!= l2) {//这里不会出现死循环，当2个ListNode相交时，会走到交点，当不相交时，会同时走到null
            l1 = (l1 ==null)? headB: l1.next;
            l2 = (l2 ==null)? headA : l2.next;
        }
        return l1;
    }

}
