package com.spring.boot.demo.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 最大数 自己想的办法比较笨，想着挨个比较，其实可以把两个字符串拼接以后比较。需要自定义一个比较器 https://leetcode-cn.com/problems/largest-number/solution/zui-da-shu-by-leetcode/
 * Created by weiyongjun on 2020/8/21
 */
public class LargestNum_179 {

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumberB(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }
        // Build largest number from sorted array.
        String largestNumberStr = "";
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }
        return largestNumberStr;
    }


    //最骚的写法，使用lambda表达式
    public String largestNumberS(int[] nums) {
        String result = IntStream
                .of(nums).mapToObj(String::valueOf)
                .sorted(((o1, o2) -> (o2 + o1).compareTo(o1 + o2))).collect(
                        Collectors.joining());
        return result.startsWith("0") ? "0" : result;
    }

}
