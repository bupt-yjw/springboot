package com.spring.boot.demo.algorithm.may;

/**
 * Created by weiyongjun on 2020/5/18
 * 总结：利用求余和取整来实现。坑在于，题目说了是32bit int，要判断反转之后的数字是否超了限制。
 * Integer 32-bit的范围：INT_MAX (2147483647) - INT_MIN (-2147483648）
 */
public class ReverseInteger_07 {

    public static void main(String[] a) {
        ReverseInteger_07 r = new ReverseInteger_07();
        System.out.println(r.reverse(1534236469));
    }

  //跟下面方法实现是一样的
    public int reverse(int x) {
        int result = 0;
        while (x!=0) {
            int temp = x % 10;
            int newResult = result* 10 +temp;
            if((newResult-temp)/10!=result) {
                return 0;
            }
            result = newResult;
            x = x/10;
        }
        return result;
    }

    /**
     * best method
     */
    public int reverseB(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;//这一步很可能超了范围，导致反算的时候，跟result 就不相等了
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
