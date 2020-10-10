package com.spring.boot.demo.algorithm.may;

/**
 * Created by weiyongjun on 2020/5/26
 * 总结：一开始没看懂题要做什么，后来发现，实际就是读出来前一个数，比如第四个是1211，读出来就是1个1，1个2，2个1。即第五个数就变成了：111221
 * 最优的解法，就是2次for循环，从1开始，一直往大了读， 读到n就是我们要的数。利用String.
 */
public class CountAndSay_38 {

    /**
     * 看了最优方法以后，自己来实现的
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if(n <= 0) {
            return "1";
        }
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;

        int count;
        char say;//当前的数字
        for(int i=1;i< n;i++) {
            prev = curr;
            curr = new StringBuilder();
            count =1;
            say=prev.charAt(0);
            for(int j=1;j< prev.length();j++) {
                if(prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count=1;
                    say = prev.charAt(j);
                }else {
                    count++;
                }
            }
            curr.append(count).append(say);//循环结束后还剩最后一位没有添加进去
        }
        return curr.toString();
    }

    /**
     * best method
     */
    public String countAndSayB(int n) {
        StringBuilder curr=new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i=1;i<n;i++){
            prev=curr;
            curr=new StringBuilder();
            count=1;
            say=prev.charAt(0);

            for (int j=1,len=prev.length();j<len;j++){
                if (prev.charAt(j)!=say){
                    curr.append(count).append(say);
                    count=1;
                    say=prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();

    }

}
