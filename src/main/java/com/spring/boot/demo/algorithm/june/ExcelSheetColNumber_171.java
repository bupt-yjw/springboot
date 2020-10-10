package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/10
 * 思路：这个题就是找到数学规律，然后按照规律开发即可，现在的代码实现和四年前的差不多。
 * 这个文档上介绍了另外一个思路。https://www.cnblogs.com/xiaochuan94/p/10014632.html
 *
 */
public class
ExcelSheetColNumber_171 {


    public static int titleToNumber(String s) {
        if(s==null || s.length() ==0){
            return 0;
        }
        int res= 0;
        int len = s.length();
        for(int i=0;i< len;i++) {
            res += (s.charAt(i)-'A'+1)* Math.pow(26,len-i-1);
        }
        return res;
    }

    /**
     * 这个方法比上面那个方法代码更加优雅一点，思路是完全一样的
     */
    public int titleToNumber2(String s) {
        int res = 0;
        if (s.isEmpty() || s.trim().length() == 0) {
            return 0;
        }
        int col = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            res += (s.charAt(i) - 64) * Math.pow(26, col--);
        }
        return res;
    }


    /**
     * 此处是另外一个思路
     *"AA"表示数字28，可以看做26x1+1
     "AAA"表示数字703，可以看做26x(26+1)+1
     "AAAA"表示数字18279，可以看做 26x(26x(26+1)+1)+1
     每次循环时，新的sum等于上一次循环的sum乘以26加上当前循环字符所表示的数字。
     */
    public static int titleToNumberC(String s) {
        int sum = 0;
        if (s.isEmpty() || s.trim().length() == 0) {
            return 0;
        }
        int len = s.length()-1;
        for (int i=0; i<=len; i++) {
            sum = (s.charAt(i)-'A' + 1) + sum*26;
        }
        return sum;
    }

    public static void main(String[] a) {
        System.out.println(titleToNumberC("AB"));
    }

}
