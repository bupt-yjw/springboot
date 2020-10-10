package com.spring.boot.demo.algorithm.sort;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组中第K大个元素 最简单的方法是使用自带的优先级队列，实现可参考： https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 *
 * Created by weiyongjun on 2020/8/29
 */
public class KthLargestElementinArray_215 {


    // 使用java自带的优先级队列，最好的方案是自己实现堆的代码
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] a) {
        KthLargestElementinArray_215 k = new KthLargestElementinArray_215();
        k.findKthLargestB(new int[]{3,2,1,5,6,4},2);
    }

    public int findKthLargestB(int[] nums, int k) {

        int arrayLength = nums.length;
        for (int i = 0; i < k; i++) {
            //建堆
            buildMaxHeap(nums, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(nums, 0, arrayLength - 1 - i);
        }
        return nums[arrayLength - k];
    }

    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {//在它之前的肯定都是父节点，之后的肯定都只是子节点
            //k保存正在判断的节点 ,即正在判断的这个父节点
            int k = i;//采用临时变量来记录i的值
            //如果当前k节点的子节点存在，有可能只存在左节点，所以用k*2+1来比较
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex(最后一个节点)，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {//说明有右节点
                    //如果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (data[k]
                        < data[biggerIndex]) {//将最大的值放到父节点，他也是下次某个循环的子节点值，也就是每次从一个小三角找到最大值，存在父节点，
                    //交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;//用来跳出循环 ,如果没有这句话的话，会再执行一遍从else那跳出去
                } else {
                    break;
                }
            }
        }
    }

    //交换
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
