package com.spring.boot.demo.algorithm.june;

/** TODO
 * 链表相关的题目还是需要好好理解理解的
 * 题目要求判断链表是否是回文。且 O(n) 时间复杂度和 O(1) 空间复杂度
 * 首先不考虑空间复杂度，可以使用数组存储，然后双指针比较。或者使用栈存储，在进行比较。
 * 考虑到空间复杂度，我们可以使用快慢指针，同时反转链表前半部分，然后和后半部分进行比较。(这个方法需要好好理解思路)
 *https://leetcode.com/problems/palindrome-linked-list/
 * 参考链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/wo-de-kuai-man-zhi-zhen-du-cong-tou-kai-shi-gan-ju/
 * 标题：我的快慢指针都从头开始，感觉更好理解 采用的是反转前半部分。  官方题解第三种方法：反转的是后半部分，之后还恢复了链表。
 * Created by weiyongjun on 2020/6/19
 */
public class PalindromeLinkedList_234 {


    //反转了前半部分
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast!= null && fast.next!= null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;//反转链表
            prepre = pre;
        }
        if(fast!=null) {
            slow = slow.next;//当链表个数为奇数时，slow需要在走一位
        }
        while (pre!= null && slow!= null) {
            if(pre.val!= slow.val) {
                return false;
            }
            pre= pre.next;
            slow = slow.next;
        }
        return true;
    }

}
