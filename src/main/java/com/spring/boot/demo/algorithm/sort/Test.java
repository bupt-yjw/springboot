package com.spring.boot.demo.algorithm.sort;

import java.util.Arrays;

/**
 * Created by weiyongjun on 2020/7/24
 */
public class Test {

    public static void main(String[] a) {
        int[] ar={49,38,65,97,76,13,27,49,78,34,12,64};
        for(int i=0;i< ar.length-1;i++) {
            buildMaxHeap(ar,ar.length-1-i);
            swap(ar,0,ar.length-1-i);
            System.out.println(Arrays.toString(ar));
        }
    }

    private static void buildMaxHeap(int[] ar, int lastIndex) {
        for(int i= (lastIndex-1)/2;i >=0;i--) {

            int k = i;
            while (k*2+1 <= lastIndex) {
                int bigIndex = k*2+1;
                if(bigIndex < lastIndex) {
                    if(ar[bigIndex] > ar[bigIndex+1]) {
                        bigIndex++;
                    }
                }

                if(ar[bigIndex] < ar[k]) {
                    swap(ar, k, bigIndex);
                    k=bigIndex;
                }else {
                    break;
                }
            }

        }
    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

}
