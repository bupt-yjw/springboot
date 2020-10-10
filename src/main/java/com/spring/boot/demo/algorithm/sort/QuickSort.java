package com.spring.boot.demo.algorithm.sort;

/**
 * �������� ʱ�临�Ӷ�ΪO(nlogn)�� ���ȶ�
 * ��n�ϴ�ʱʹ�ÿ��űȽϺã������л�������ʱ�ÿ��ŷ������á�
 * ����˼·��ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС��
 * Ȼ���ٰ��˷����������������ݷֱ���п�����������������̿��Եݹ���У��Դ˴ﵽ�������ݱ���������С�
 *
 * Created by weiyongjun on 2020/7/16
 */
public class QuickSort {

    public static void main(String[] a) {
        int[] ar = new int[]{5, 2, 1, 3, 0};
        quickSort(ar);
        System.out.println(1);
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = getPosition(array, left, right);
        quickSort(array, left, pos - 1);
        quickSort(array, pos + 1, right);
    }

    //�Ż����ʵ�֣�����Ҫswap����
    private static int getPosition(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            if (left < right) {
                array[left++] = array[right];
            }
            while (left < right && array[left] <= temp) {
                left++;
            }
            if (left < right) {
                array[right--] = array[left];
            }
        }
        array[left] = temp;
        return left;
    }


}
