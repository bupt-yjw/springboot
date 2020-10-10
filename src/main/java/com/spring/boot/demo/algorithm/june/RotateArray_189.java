package com.spring.boot.demo.algorithm.june;

/** TODO
 * Created by weiyongjun on 2020/6/11
 * 三种方法。1。使用两层循环，外层控制旋转次数，内层控制元素交换位置。此解法时间复杂度为O(n*k)，空间复杂度为O(1)。
 *          2。新建一个大小和nums一样的数组，然后将旋转后的元素放入新的数组中。此解法的时间复杂度是O(n)，空间复杂度是O(n)
 *          3。通过三次反转数组实现。此解法的时间复杂度是O(n)，空间复杂度是O(1)。
 *          参考链接：https://www.cnblogs.com/xiaochuan94/p/10024317.html
 */
public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        k = k% nums.length;
        if(k==0) {
            return;
        }
        reverse(nums,0, nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums,k, nums.length-1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;end--;
        }
    }

}
