package com.spring.boot.demo.algorithm.may;

/**
 * Created by weiyongjun on 2020/5/26
 * 思路：没想到使用递归的方法，所以自己的代码就没有写出来，而是直接参考的最优代码。
 * 最优方法：使用递归进行，代码很简洁。
 */
public class MergeTwoSortedLists_21 {

    /**
     * best method
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
