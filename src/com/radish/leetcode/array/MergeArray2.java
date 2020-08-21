package com.radish.leetcode.array;

import com.radish.utils.MyUtils;

/**
 * @Description MergeArray2
 *
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @Author Radish
 * @Date 2020-08-20 23:09
 */
public class MergeArray2 {
    public static void main(String[] args) {
        int[] ints = {0};
        int[] ints1 = {1};
        merge(ints,0,ints1, 1);
        MyUtils.print(ints);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //先找大的比较好操作
        int i = m - 1, j = n - 1, curIndex = m + n - 1;
        while (j >= 0) {
            int curN;
            if (i >= 0) {
                curN = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            } else {
                curN = nums2[j--];
            }
            nums1[curIndex--] = curN;
        }
    }
}
