package com.spring.boot.demo.algorithm.may;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weiyongjun on 2020/5/19
 * 总结：这个题目的难点在于，会出现反减的情况。如IX：为9，即10-1
 * 自己的逻辑，笨在2个地方。1是没有使用str.toCharArray()来直接循环数组，2是自己挨个判断，还需要考虑数组越界的情况。效率比较低。
 * 最优方法1的思路：跟自己思路差不多，但是采用数组存放，且通过适当调整能够避免数组越界的情况。
 * 最优方法2的思路：每一个相减的场景只会使用一次，所以通过String.indexOf来判断，感觉是一个比较投巧的方法。推荐还是最优方法1的思路。
 */
public class Roman2Integer_13 {

    public int romanToInt(String s) {
        Map<Character, Integer> keys = new HashMap<>();
        keys.put('I',1);
        keys.put('V',5);
        keys.put('X',10);
        keys.put('L',50);
        keys.put('C',100);
        keys.put('D',500);
        keys.put('M',1000);

        int len = s.length();
        int result = 0;
        for(int i =0; i< len;i++) {
            if(i< len-1 && keys.get(s.charAt(i)) < keys.get(s.charAt(i+1))) {
                result = result+keys.get(s.charAt(i+1))-keys.get(s.charAt(i));
                i+=1;
            } else {
                result += keys.get(s.charAt(i));
            }
        }
        return result;
    }

    /**
     * best method
     */
    public static int romanToIntB(String str) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;
        char prev = 'A';
        int sum = 0;
        for(char s : str.toCharArray()) {
            if(a[s - 'A'] > a[prev - 'A']) {
                sum = sum - 2 * a[prev - 'A'];
            }
            sum = sum + a[s - 'A'];
            prev = s;
        }
        return sum;
    }

    /**
     * best method 2
     * @param s
     * @return
     */
    public int romanToIntB2(String s) {
        int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char c[]=s.toCharArray();
        for(int count=0;count<=s.length()-1;count++) {
            if(c[count]=='M') sum+=1000;
            if(c[count]=='D') sum+=500;
            if(c[count]=='C') sum+=100;
            if(c[count]=='L') sum+=50;
            if(c[count]=='X') sum+=10;
            if(c[count]=='V') sum+=5;
            if(c[count]=='I') sum+=1;
        }
        return sum;
    }

    public static void main(String[] a) {
        System.out.println(romanToIntB("IV"));
    }

}
