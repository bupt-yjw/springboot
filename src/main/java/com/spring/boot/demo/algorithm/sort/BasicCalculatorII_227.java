package com.spring.boot.demo.algorithm.sort;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 计算器II Created by weiyongjun on 2020/8/29
 */
public class BasicCalculatorII_227 {

    public static void main(String[] a) {
        BasicCalculatorII_227 n = new BasicCalculatorII_227();
        System.out.println(n.calculate("3+2 * 2"));
    }


    // 换一个思路，放入队列时，全部转成加法处理
    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
               // 这里不能continue，否则i== len-1的情况就走不到了
            }

            //当不是数字时，s.charAt(i) 是下一个数字的符号。
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }


    //带括号的算法实现，可以先忽略
    public int calculateK(String s) {
        /*
            将 减法、乘法、除法 转换为 加法
            某个数 num, 如果前面的对应的运算符是 -，那么 将 -num 压入栈中
            这样，我们只需在最后将栈的元素全部弹出，完成加法操作，即可得到最终结果

            对于括号，它存在递归性质
            即
            3 * (2 + 4 * 3) + 2
          = 3 * calculate(2 + 4 * 3) + 2
          = 3 * 24 + 2
          即我们可以将括号内的字符串当作一个运算式，再递归调用本函数，最终返回一个数值
        */
        int count = 0;
        return dfs(s, count);
    }

    private int dfs(String s, int i) {
        Deque<Integer> stack = new LinkedList<>();

        //记录某个连续的数，比如 "42"，那么我们首先 num = 4，然后遇到 2 ,num = num * 10 + 2 = 42
        int num = 0;
        char op = '+';
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);

            //遇到左括号，递归运算内部子式
            if (ch == '(') {
                ++i;
                num = dfs(s, i);
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                continue;
            }
            //不是数字，不是空格（运算符 或 '(' 或 ')' ） 或者 到了最后一个字符，那么根据前面记录的 op 操作符 将数字压栈，然后将新的运算符 ch 赋值给 op
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                num = 0;
                op = ch;
            }
            /*
            遇到右括号，退出循环，然后计算结果， 返回上一层 dfs
            这一步写在最后是因为，当 ch 为 右括号 时，那么我们需要先将前面已经得到的 num 压入栈中，再退出循环
            */
            if (ch == ')') {
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    //这是自己的实现，问题很多，就不改了，运行不会成功的
    public int calculateX(String s) {
        int result = 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> cal = new Stack<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (isNum(c)) {
                nums.add(c - '0');
            } else if (c == '+' || c == '-') {
                cal.add(c);
            } else if (c == '*') {
                nums.add(nums.pop() * Integer.valueOf(s.charAt(++i)));
            } else if (c == '/') {
                nums.add(nums.pop() / Integer.valueOf(s.charAt(++i)));
            }
        }
        while (!cal.isEmpty()) {
            char calInfo = cal.pop();
            int a1 = nums.pop();
            int a2 = nums.pop();
            if (calInfo == '+') {
                result += (a1 + a2);
            } else {
                result += (a2 - a1);
            }
        }
        return result;
    }

    private boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

}
