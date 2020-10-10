package com.spring.boot.demo.algorithm.sort;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation
 *
 * Created by weiyongjun on 2020/8/21
 */
public class EvaluateReversePolishNotation_150 {
    public static void main(String[] a) {
        EvaluateReversePolishNotation_150 s = new EvaluateReversePolishNotation_150();
       int re= s.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(re);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int res =0;
        if(tokens == null || tokens.length == 0) {
            return res;
        }
        for(String s : tokens) {
            if(isNum(s)) {
                stack.push(Integer.valueOf(s));
                continue;
            } else {
                res = cal(stack.pop(), stack.pop(), s);
                stack.push(res);
            }
        }
        if(!stack.isEmpty()) {
            return stack.pop();
        }
        return res;
    }

    private int cal(Integer num1, Integer num2, String flag) {
        if("+".equals(flag)) {
            return num1 + num2;
        }
        if("-".equals(flag)) {
            return num2 - num1;
        }
        if("*".equals(flag)) {
            return num2 * num1;
        }
        if("/".equals(flag)) {
            return num2/num1;
        }
        return -1;
    }

    private boolean isNum(String s) {
       if("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
           return false;
       }
       return true;
    }


}
