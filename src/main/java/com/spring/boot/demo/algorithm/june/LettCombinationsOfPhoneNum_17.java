package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by weiyongjun on 2020/6/29
 *     自己实现的，用了个笨办法,全部穷举。同时需要使用两个list来存储当前计算的结果和上一个的结果。且每次都要把上上次的结果清空
        最佳算法代码比我的简洁，同时不需要用2个数据。采用FIFO，使用LinkedList来存储，peek是查看头数据，add是加在尾部。
 *
 */
public class LettCombinationsOfPhoneNum_17 {
     Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


     //自己实现的，用了个笨办法,全部穷举。同时需要使用两个list来存储当前计算的结果和上一个的结果。且每次都要把上上次的结果清空,但是还挺快的
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) {
            return new ArrayList<>();
        }
        List<String> res1 = new ArrayList<>(digits.length()*3);
        List<String> res2 = new ArrayList<>(digits.length()*3);
        String temp = phone.get(digits.substring(0,1));
        for(int i=0;i< temp.length();i++) {
            res1.add(temp.substring(i,i+1));
        }
        for(int i=1;i< digits.length();i++) {
            String s = digits.substring(i,i+1);
            temp = phone.get(s);
            if(i%2 ==0) {
                res1 = new ArrayList<>();
                for(int i1=0;i1< temp.length();i1++) {
                    for(String ss:res2) {
                        res1.add(ss+temp.substring(i1,i1+1));
                    }
                }
            } else {
                res2 = new ArrayList<>();
                for(int i1=0;i1< temp.length();i1++) {
                    for(String ss:res1) {
                        res2.add(ss+temp.substring(i1,i1+1));
                    }
                }


            }

        }
        return digits.length() %2 == 0 ?res2:res1;
    }

    //最优方法，十分简洁
    public List<String> letterCombinationsB(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits.isEmpty()) {
            return res;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        while (res.peek().length()!= digits.length()) {//不相等说明还没添加完
            String remove = res.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()) {
                res.add(remove +c);
            }
        }
        return res;
    }

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;


    // 这个是leedcode中文版的解法，采用递归调用，也挺简洁的。跟for循环的思路其实都差不多
    public List<String> letterCombinationsLD(String digits) {
        res = new ArrayList<String>();
        if(digits.equals("")) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s){
        if(index == digits.length()){
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombination(digits, index+1, s + letters.charAt(i));
        }

        return;
    }

}
