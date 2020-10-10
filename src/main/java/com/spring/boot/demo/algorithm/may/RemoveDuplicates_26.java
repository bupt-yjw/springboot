package com.spring.boot.demo.algorithm.may;

/**
 * Created by weiyongjun on 2020/5/26
 * 总结：我的方法只是能返回要的结果，但是不符合题目要求。题目希望数组对应的前几位也是去重后的数据，比如[1,1,2] 经过处理后，
 *同时返回2，且数据的前两位是[1,2]，所以可以使用快慢指针，快的每次都向前进一位，慢的只有不相等时进位，同时把快的值覆盖到慢指针的位置
 */
public class RemoveDuplicates_26 {

    //自己的方法，是一个错误的实现
    public static int removeDuplicates(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                result++;
            }
        }
        return result + 1;
    }

    /**
     * best method
     */
    public int removeDuplicatesA(int[] nums) {
        int i = 0;
        for (int n : nums) {
            //考虑首次的情况，-1会出现数组越界
            if (i == 0 || n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    /**
     * 只是上面那个方法的变形，本质都是一样的
     */
    public int removeDuplicatesB(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums) {
            if (n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] a) {
        int[] nums = new int[]{0, 1};
        System.out.println(removeDuplicates(nums));
    }

}
