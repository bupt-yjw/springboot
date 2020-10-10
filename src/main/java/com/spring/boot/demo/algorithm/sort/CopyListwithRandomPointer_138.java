package com.spring.boot.demo.algorithm.sort;

/**
 * 做带有随机指针的node 深拷贝
 *
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/
 *
 * 第三种实现更简单一些。但是逻辑实现还是得好好看看
 * Created by weiyongjun on 2020/8/14
 */
public class CopyListwithRandomPointer_138 {

    //这里用第三种实现
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Node ptr = head;
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        while (ptr!= null) {
            ptr.next.random = ptr.random == null? null:ptr.random.next;
            ptr = ptr.next.next;
        }

        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node head_new = head.next;
        while (ptr_old_list!= null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = ptr_new_list.next!= null? ptr_new_list.next.next:null;

            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_new;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
