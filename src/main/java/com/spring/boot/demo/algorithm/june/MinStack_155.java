package com.spring.boot.demo.algorithm.june;

import java.util.Stack;

/**
 * Created by weiyongjun on 2020/6/10
 * 思路：实现最小堆，可以使用两个栈，一个是基本的栈，另外一个是用来记录当前栈的最小值。通过设置一个min参数，当push时，
 * 和min进行比较，则知道当前栈的最小值，压入记录最小值的栈。
 * 在leetcode上发现有只使用一个栈来完成的。可以参考文档里的第四种解法：https://www.cnblogs.com/xiaochuan94/p/9986908.html
 *
 * 使用一个堆栈的思路：需要自己的揣摩代码，不然容易写错了。
 * 较之使用两个堆栈的方法，此解法只使用了一个栈来完成入栈、出栈、获取栈顶和最小值的全部操作。
 入栈时，如果新入栈的元素比最小值小，那么要将旧的最小值入栈，并且新的最小值是此时新入栈的元素，最后再将新元素入栈。
 出栈时，如果要移除的元素正好是当前最小值，那么就需要再出栈一次，并且最小值等于第二次出栈要移除的值，因为入栈时是会将旧的最小值添加进去的，所以出栈时要做此判断。
 */
public class MinStack_155 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack_155() {
        stack = new Stack();
        minStack = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min,x);
        minStack.push(min);
    }

    //每次pop元素出去，min值都是要变的
    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.isEmpty()?Integer.MAX_VALUE:minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}
