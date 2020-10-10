package com.spring.boot.demo.algorithm.sort;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * 自己实现的方法，也是调试了很多次才通，很多细节需要注意的。而且效率不高。
 * 最优代码是自己实现一个node来存储相关信息。这样再移除节点的时候，不需要像我这样，遍历寻找再移除。
 * https://leetcode.com/problems/lru-cache
 *
 * Created by weiyongjun on 2020/8/14
 */
public class LRUCache_146 {

    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> queue = new LinkedList<>();
    private int size =0;


    public static void main(String[] a) {
    LRUCache_146 lruCache_146 = new LRUCache_146(2);
        lruCache_146.put(1,1);
        lruCache_146.put(2,2);
        lruCache_146.get(1);
        lruCache_146.put(3,3);
        lruCache_146.get(2);
        lruCache_146.put(4,4);
        lruCache_146.get(1);
        lruCache_146.get(3);
        lruCache_146.get(4);
    }

    public LRUCache_146(int capacity) {
        this.size = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            queue.remove(key);
            queue.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            queue.remove(key);
        } else if(queue.size() == size) {
            int temp = queue.removeLast();
            map.remove(temp);
        }
        map.put(key, value);
        queue.push(key);
    }


    //最优解法
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache_146(int capacity, int noused) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int getB(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void putB(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
