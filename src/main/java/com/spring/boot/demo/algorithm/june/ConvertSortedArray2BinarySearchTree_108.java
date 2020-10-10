package com.spring.boot.demo.algorithm.june;

import java.util.Arrays;

/** TODO：again
 * Created by weiyongjun on 2020/6/5
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
 * 思路：题目的意思是把一个数组转换成高度平衡树，跟着示例，可以看出来，找到中间点，然后依次递归调用。直到数组处理完。
 * 可惜自己思路想出来了，但是树的代码实现没有写出来。
 */
public class ConvertSortedArray2BinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length-1);
    }

    private TreeNode toBST(int[] nums, int sIdx, int eIdx) {
        if(sIdx > eIdx) {
            return null;
        }
        int mIdx = (sIdx+eIdx)/2;
        TreeNode root = new TreeNode(nums[mIdx]);
        root.left = toBST(nums, sIdx, mIdx-1);
        root.right = toBST(nums, mIdx+1, eIdx);
        return root;
    }

    /**
     * 这是leetcode上的最优方法，比上面的简洁，但是不如上面的易读
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBSTV(int[] nums) {
        if(nums.length==0)return null;
        int ptr=nums.length/2;
        TreeNode root=new TreeNode(nums[ptr]);
        root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,ptr));
        root.right=sortedArrayToBST(Arrays.copyOfRange(nums,ptr+1,nums.length));
        return root;
    }
}
