package com.spring.boot.demo.algorithm.sort;

/**
 * Created by weiyongjun on 2020/7/23
 * 原理分析可以看这个。https://www.cnblogs.com/chengxiao/p/6129630.html
 * 代码实现看自己的就可以了
 * 理解了题意以后，只需要稍微改变几个判断就可以完成从最大堆到最小堆
 */
import java.util.Arrays;

//堆的一个规律就是i节点的父节点下标是(i-1)/2,他的左右子节点下表分别是2*i+1和2*i+2；
public class DumpSort {
    public static void main(String[] args) {
       // int[] a={49,38,65,97,76,13,27,49,78,34,12,64};
        int[] a={4,6,8,5,9};
        int arrayLength=a.length;
        //循环建堆
        for(int i=0;i<arrayLength-1;i++) {
            //建堆
            buildMaxHeap(a,arrayLength-1-i);
            //交换堆顶和最后一个元素
            swap(a,0,arrayLength-1-i);
            System.out.println(Arrays.toString(a));
        }
    }
    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){//在它之前的肯定都是父节点，之后的肯定都只是子节点
            //k保存正在判断的节点 ,即正在判断的这个父节点
            int k=i;//采用临时变量来记录i的值
            //如果当前k节点的子节点存在，有可能只存在左节点，所以用k*2+1来比较
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex(最后一个节点)，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){//说明有右节点
                    //如果右子节点的值较大
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if(data[k]<data[biggerIndex]){//将最大的值放到父节点，他也是下次某个循环的子节点值，也就是每次从一个小三角找到最大值，存在父节点，
                    //交换他们
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;//用来跳出循环 ,如果没有这句话的话，会再执行一遍从else那跳出去
                }else{
                    break;
                }
            }
        }
    }
    //交换
    private static void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
}
