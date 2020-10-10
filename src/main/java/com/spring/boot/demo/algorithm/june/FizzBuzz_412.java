package com.spring.boot.demo.algorithm.june;

import java.util.ArrayList;
import java.util.List;

/**
 * 十分傻逼的一道题，哈哈
 *
 * Created by weiyongjun on 2020/6/20
 */
public class FizzBuzz_412 {



    //自己的实现
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>(n);
        int i = 1;
        while (i <= n) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
            i++;

        }
        return list;
    }

    //更加优雅的一种实现吧
    public List<String> fizzBuzzB(int n) {
        // ans list
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {

            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);

            String numAnsStr = "";

            if (divisibleBy3) {
                // Divides by 3, add Fizz
                numAnsStr += "Fizz";
            }

            if (divisibleBy5) {
                // Divides by 5, add Buzz
                numAnsStr += "Buzz";
            }

            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr);
        }

        return ans;
    }

}
