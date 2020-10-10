package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.List;

/** TODO：again
 * Created by weiyongjun on 2020/6/5
 * https://leetcode.com/problems/pascals-triangle/submissions/
 * 思路：杨辉三角，首先要了解ArrayList.add方法，从前往后和从后往前是一样的逻辑。
 * 解法：每一行的首个和结尾一个数字都是1，从第三行开始，中间的每个数字都是上一行的左右两个数字之和。
 * 每次在上一个的数组开头或结尾add 1(相当于保留了上一个数组的数据)，然后重新计算从第一位到倒数第二位的值。
 * leetcode上有自己四年前提交的代码，相当的笨方法
 *
 */
public class PascalTriangle_118 {

    /**
     * 从前往后计算
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            //从前往后计算，需要在数组最前面add 1进去，此时从第2到最后都是原数组，那么此时的第二位就是原数组的第一位+第二位，也就是现数组的第二位+第三位
            //通过合理的设计for的判断，可以直接把前两种情况加进去。
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            allrows.add(new ArrayList<Integer>(row));//这里需要new一个新的arraylist，因为对象在堆内是引用的
        }
        return allrows;
    }

    /**
     * 从后往前，原理是一样的，但是从后往前效率应该是跟高，因为不存在数据移位
     */
    public static List<List<Integer>> generateV(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(1);
            for (int j =row.size()-2 ; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }

    public static void main(String[] a) {
        System.out.println(generate(3));
    }

}
