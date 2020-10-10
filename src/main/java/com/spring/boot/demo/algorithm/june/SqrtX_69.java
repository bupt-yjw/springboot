package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/2
 * 总结：两种方法。首先自己想到使用二分查找，觉得性能会差，所以没有实现。
 * 牛顿迭代法，涉及到公式变形，代码会简洁很多，但是公式不容易想到
 * 可参考链接：https://www.cnblogs.com/grandyang/p/4346413.html
 */
public class SqrtX_69 {

    /**
     * 二分查找法
     * 核心在于，x>mid平方且x< (mid+1)平方，则说明要返回的值是mid
     * 其他情况下，left和right向两头进位
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    /**
     * 牛顿迭代法
     */
    public int mySqrtB(int x) {
        long res = x;//防止越界，res要声明成long型
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int)res;
    }



}
