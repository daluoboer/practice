package com.radish.leetcode.array;

/**
 * @description SearchInsert
 *
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @Author Radish
 * 这个是查找哎！就这么粗暴地查找？？？可以用二分嘛！不过好久没有用过了
 * @Date 2020-07-17 18:20:24
 */

public class SearchInsert {
    public static void main(String[] args) {
        int i = searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        //粗暴法
        /*int index = 0;
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) {
                    index = i;
                    break;
                }
            }
        }
        if (target > nums[nums.length - 1]) {
            index = nums.length;
        }
        return index;*/
        //二分
        return 0;
    }

    public static int erfen(int[] nums, int start, int end, int target) {
        int index;
        if (start > end) {
            return -1;
        }

        index = start + (end - start) / 2;

        if (target == nums[index]) {
            return index;
        }

        if (target > nums[index]) {
            return erfen(nums, index + 1, end, target);
        } else {
            return erfen(nums, start, index - 1, target);
        }
    }
}
