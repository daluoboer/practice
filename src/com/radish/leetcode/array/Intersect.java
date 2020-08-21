package com.radish.leetcode.array;

import com.radish.utils.MyUtils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description Intersect
 *
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 *
 * @Author Radish
 * @Date 2020-08-20 16:33
 */
public class Intersect {
    public static void main(String[] args) {
        int[] intersect = intersect1(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        MyUtils.print(intersect);
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
        int[] ints = new int[nums2.length];
        int curIndex = 0;
        //hash
        HashMap<Integer,Integer> ns1 = new HashMap<>();
        for (int i : nums1) {
            Integer count = ns1.get(i);
            if (count == null) {
                ns1.put(i,1);
            } else {
                ns1.put(i,count+1);
            }

        }

        for (int i = 0; i < nums2.length; i++) {
            Integer count = ns1.get(nums2[i]);
            if (count != null && count > 0) {
                ns1.put(nums2[i],count-1);
                ints[curIndex++] = nums2[i];
            }
        }

        return Arrays.copyOfRange(ints,0,curIndex);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //e...暴力遍历
        //但是直接遍历的话有可能有重复的数儿，但是不知道它出现了几次啊，那就先排序再遍历好了
        //啊，其实是可以优化的，就是双指针，谁的数儿小了就向后移，直到一个数组结束。
        sort(nums1);
        sort(nums2);
        int j = 0;
        int[] yours = new int[nums1.length>nums2.length?nums2.length:nums1.length];
        int yourIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (j < nums2.length) {
                if (nums2[j] == nums1[i]) {
                    yours[yourIndex++] = nums2[j++];
                    break;
                }
                if (nums2[j] > nums1[i]) {
                    break;
                }
                if (nums2[j] < nums1[i]) {
                    j++;
                }
            }
            if (j >= nums2.length) break;
        }
        return Arrays.copyOfRange(yours,0,yourIndex);
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
