package com.spring.boot.demo.algorithm.june;

/**
 * TODO：还是没想到最简洁的这两个方法。挨个判断每个数是否是素数，效率太差。通过设置数组，然后循环设置数组的状态来实现
 * Created by weiyongjun on 2020/6/18
 * 思路：主要采用了排除法：
 1、比2大的偶数肯定不是质数，排除。
 2、质数的倍数一定不是质数，排除。
 3、所以我们把【比2大的偶数】和【质数的奇数倍数】排除掉，剩下的就是质数。

 步骤：
 1、首先去掉一半的偶数，有人会问了“2也是偶数呀，是不是多排除了一个”？其实1已经代替了2被排除了。
 2、第一轮循环从3开始，依次把3x3,3x5,3x7,3x9......等3的奇数倍数排除。
 3、第二轮循环,依次把5x5,5x7,5x11,5x13......等5的奇数倍数排除，你会发现这里怎么少了一个5x9？其实5x9=3x15已经在上一轮循环被排除。
 4、最后循环到sqrt(n)就能排除掉所有的非质数。
 */
public class CountPrimes_204 {


    //自己的方法效率太多，运行会超时。其实对于这个题目，是不需要计算每一个数是否是素数。
    public int countPrimes(int n) {
        int res = 0;
        if(n<=1) {
            return res;
        }
        while (n>1) {
            if(isPrime(n)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        if(n<=3) {
            return true;
        }
        if(n%6!=1 && n%6 != 5) {
            return false;
        }
        int sqrt = (int)Math.sqrt(n);
        for(int i=2;i<=sqrt;i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }

    //最优方法，减少了大量的重复计算
    public int countPrimesB(int n) {
        if(n <=2) {//要统计的是小于n的素数个数，所以n=2时，返回0
            return 0;
        }
        int count = n/2;
        boolean[] isPrimes = new boolean[n];
        for(int i=3;i*i<n;i+=2) {
            if(isPrimes[i]) {
                continue;
            }
            for(int j =i*i;j<n;j+=2*i) {
                if(!isPrimes[j]) {
                    isPrimes[j]=true;
                    count--;
                }
            }
        }
        return count;
    }

    //次优方法，存在大量重复计算，但是代码更简洁
    public int countPrimesV(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }


}
