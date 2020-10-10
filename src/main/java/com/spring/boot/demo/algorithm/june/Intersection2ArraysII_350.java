package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by weiyongjun on 2020/6/20
 *使用hashmap来存储，并将重复的元素放到参数里，这样就不需要弄新数组来存储结果了。
 * 方法2：先对数组排序，然后用两个指针来进行扫描。
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode/
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/
 */
public class Intersection2ArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //对较小的数组进行hash存储，节约存储空间
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num1: nums1) {
                map.put(num1,map.getOrDefault(num1,0)+1);
        }
        int k=0;
        for(int num2: nums2) {
                int cnt = map.getOrDefault(num2,0);
                if(cnt >0) {
                    nums1[k++] = num2;
                    map.put(num2, cnt-1);
                }
        }
            return Arrays.copyOf(nums1,k);
    }


}
