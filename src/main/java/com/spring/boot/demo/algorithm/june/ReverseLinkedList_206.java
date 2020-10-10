package com.spring.boot.demo.algorithm.june;

/** TODO：关于链表的算法还是在看看吧
 * 题目要求使用迭代或递归两种方式调用
 * 可以参考这个上面的最佳题解。https://leetcode-cn.com/problems/reverse-linked-list/
 * https://leetcode.com/problems/reverse-linked-list/submissions/
 * Created by weiyongjun on 2020/6/18
 */
public class ReverseLinkedList_206 {

    /**迭代
     * 假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。
     在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
     */
    public ListNode reverseListB(ListNode head) {
       ListNode prev = null;
       ListNode cur = head;
       while (cur!=null) {
           ListNode next = cur.next;
           cur.next = prev;
           prev = cur;
           cur = next;
       }
    return prev;
    }

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }

}
