package com.spring.boot.demo.algorithm.june;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/
 * https://leetcode.com/problems/group-anagrams/
 * 两种方法，方法1： 使用Map<key,list>来存储。其中key是排好序的字符串。
 * 方法2：key进行排序，当字符串长度太大时，效率会差。可以使用int[26]的数组来记录key中每个字符出现的次数，然后转成string来当key存储。
 * * Created by weiyongjun on 2020/8/6
 */
public class GroupAnagrams_49 {
    public static void main(String[] a) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> re= groupAnagrams(strings);
        System.out.println(1);
    }


    //方法1
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null ||strs.length ==0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)) {
                map.put(key,new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    //方法2
    public List<List<String>> groupAnagramsB(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
