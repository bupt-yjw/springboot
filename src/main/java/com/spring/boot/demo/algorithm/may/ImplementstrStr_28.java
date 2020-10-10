package com.spring.boot.demo.algorithm.may;

/**
 * Created by weiyongjun on 2020/5/26
 * 思路：自己想着使用快慢指针来实现，但是在遇到这种case时，"mississippi" ,"issip" 由于快指针已经走过去，无法回退再去比对，所以功能上有问题
 * 最优方法B：仔细看他的逻辑，也是使用了快慢指针，但是不一样的地方在于，我是使用两个独立指针，各走各的，遇到上面那种情况，无法回退。而他的方法：
 * 使用的是i+j(i为haystack的游标，j为needle的游标)来模拟快指针，同时在遇到不匹配情况时，i只进一位。这样就不会出现我的那个问题。也就相当于，我是每匹配一个字符就
 * 进位一次，而他的方法是，每次匹配不成功才进位。
 * 最优思路C：该方法比较取巧，计算两个字符串差值，利用substring和equals方法来进行比对。
 */
public class ImplementstrStr_28 {


    /**
     * 自己使用快慢指针，有问题，"mississippi" ,"issip"这种case
     * 无法实现，所以代码是错的
     * 代码是错的，没有什么参考价值了，改的也是稀巴烂
     */
    public static int strStr(String haystack, String needle) {
        int index = 0;
        if(needle == null || needle.length() ==0) {
            return index;
        }
        int hsize = haystack.length();
        int nsize = needle.length();
        int h= 0; int n=0;
        while (h < hsize && n< nsize) {
            if(haystack.charAt(h+n) == needle.charAt(n)) {
                n++;
            } else {
                n=0;
                h++;
            }

        }
        return n< nsize? -1: h;
    }

    /**
     * best method
     */
    public int strStrB(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }

    public int strStrC(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] a) {

        System.out.println(strStr("mississippi" ,"issip"));
    }

}
