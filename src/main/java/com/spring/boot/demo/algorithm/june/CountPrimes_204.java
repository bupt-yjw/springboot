package com.spring.boot.demo.algorithm.june;

/**
 * TODO������û�뵽����������������������ж�ÿ�����Ƿ���������Ч��̫�ͨ���������飬Ȼ��ѭ�����������״̬��ʵ��
 * Created by weiyongjun on 2020/6/18
 * ˼·����Ҫ�������ų�����
 1����2���ż���϶������������ų���
 2�������ı���һ�������������ų���
 3���������ǰѡ���2���ż�����͡������������������ų�����ʣ�µľ���������

 ���裺
 1������ȥ��һ���ż�������˻����ˡ�2Ҳ��ż��ѽ���ǲ��Ƕ��ų���һ��������ʵ1�Ѿ�������2���ų��ˡ�
 2����һ��ѭ����3��ʼ�����ΰ�3x3,3x5,3x7,3x9......��3�����������ų���
 3���ڶ���ѭ��,���ΰ�5x5,5x7,5x11,5x13......��5�����������ų�����ᷢ��������ô����һ��5x9����ʵ5x9=3x15�Ѿ�����һ��ѭ�����ų���
 4�����ѭ����sqrt(n)�����ų������еķ�������
 */
public class CountPrimes_204 {


    //�Լ��ķ���Ч��̫�࣬���лᳬʱ����ʵ���������Ŀ���ǲ���Ҫ����ÿһ�����Ƿ���������
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

    //���ŷ����������˴������ظ�����
    public int countPrimesB(int n) {
        if(n <=2) {//Ҫͳ�Ƶ���С��n����������������n=2ʱ������0
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

    //���ŷ��������ڴ����ظ����㣬���Ǵ�������
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
