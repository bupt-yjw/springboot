package com.spring.boot.demo.algorithm.may;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 思路：首先看到题目，一下子想到使用堆栈来处理，是开始标识符就放入堆栈，不是则从堆栈取出元素进行比对。但是没有考虑到当stack为空的时候，即")"这种场景，pop时会
 * 抛异常，所以自己使用了一个临时变量，入栈+1，出栈-1。pop前先判断变量是否小于1，如果是，说明栈内没有元素，直接返回false。自己为了维护这个关系，使用了map，空间上
 * 上浪费较大。
 * 最优方法：思路上差不多，但是代码上更简洁，同时没有使用map来存关系，而是判断是开始标识符，就把结束标识符压进去。if else相对更多一点。
 * 最后：后来在对比提交代码时发现，我自己定义 map 其实不会占用多少存储空间，不过最优方法确实简洁很多。
 * Created by weiyongjun on 2020/5/19
 */
public class ValidParentheses_20 {

    public static boolean isValid(String s) {
        Map<Character, Character> endMap = new HashMap<>();
        endMap.put('{', '}');
        endMap.put('[', ']');
        endMap.put('(', ')');
        if(s== null || s.length() == 0) {
            return true;
        }
        int i = 0;
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()) {
            if(endMap.containsKey(c)) {
                stack.push(c);
                i++;
            } else {
                if( i<=0 || c != endMap.get(stack.pop())) {
                    return false;
                }
                i--;
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * best method
     * @param s
     * @return
     */
    public boolean isValidB(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] a) {
        System.out.println(isValid("[])"));

    }

}
