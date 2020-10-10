package com.spring.boot.demo.algorithm.june;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/** TODO: 没想到可以用快慢指针，而且自己第二次的方法不够简洁
 * Created by weiyongjun on 2020/6/18
 * //果然自己写的方法超时了。而且自己用long没有必要，因为happy以后的数，不会超过int范围。且不应该用map来存
 * https://leetcode.com/problems/happy-number/submissions/
 *参考链接：https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
 *
 * 同时注意：这个题也可以转换成快慢指针，判断链表是否有环上。
 */
public class HappyNumber_202 {


    public static boolean isHappy(int n) {
        Map<Long, Integer> exist = new HashMap<>();
        Long count = Long.valueOf(n);
        exist.put(count,1);
        while (count %10!=0) {
            count = getHappyNum(count);
            if(exist.containsKey(n)) {
                break;
            }
            exist.put(count,1);
        }
        return count%10==0;
    }

    private static Long getHappyNum(Long count) {
        long res = 0;
        while (count!=0) {
            res+= Math.pow(count%10,2);
            count/=10;
        }
        return res;
    }

    public static void main(String[] a) {
        System.out.println(isHappy(998));
    }

    //best method 方法1： 该方法。时间和空间复杂度都是O(logn)。具体时间和空间复杂度的计算方式，可以参考leedcode-cn
    public boolean isHappyB(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n!=1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n==1;
    }

    private int getNext(int n) {
        int res = 0;
        while (n>0) {
            res+= (n%10) * (n%10);
            n/=10;
        }
        return res;
    }

    //best method方法2：快慢指针，判断链表是否有环 时间复杂度：O(logn) 空间复杂度：O(1)
    public boolean isHappyC(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

}
