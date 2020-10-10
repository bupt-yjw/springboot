package com.spring.boot.demo.algorithm.sort;

/**
 * Created by weiyongjun on 2020/7/17
 */
import java.util.Scanner;

/**
 * 给定一个字符串，求第一个不重复的字符    abbcad -> c
 */
public class Test2 {
    public static void main(String[] args) {
        String str = "abbcad";
        int[] flag = new int[256];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = -1;//数组记录每个字符出现的位置
        }
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            if (flag[index]  >= 0) {
                flag[index] = -2;//如果字符已经出现，则把位置变成-2；
            }else if(flag[index] == -1){
                flag[index] = i;//如果字符没有出现，则把该字符出现的位置赋给数组
            }
        }
        int min = 256;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] < 0) {//小于0则表示该字符出现2次以上
                continue;
            }
            if (min > flag[i]) {//找到出现位置最小的那个值，其对应的字符就是第一个出现的字符。
                min = flag[i];
            }
        }
        System.out.println(str.charAt(min));
    }
}

