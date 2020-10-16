package com.radish.leetcode.maths;

import com.radish.utils.MyUtils;

import java.util.HashMap;

/**
 * @Description TwoSum
 *
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @Author Radish
 * @Date 2020-08-20 18:54
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = twoSum2(new int[]{3,3}, 6);
        MyUtils.print(ints);
    }

    //一遍哈希，这个可以处理相同元素了耶~Good！
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if (map.containsKey(i1) && map.get(i1) != i) {
                return new int[]{i,map.get(i1)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

        //两遍哈希,没有相同的元素嘛？？？看这解法是默认没有相同元素了呀
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int ii = target - nums[i];
            if (map.containsKey(ii) && map.get(ii) != i) {
                return new int[]{i,map.get(ii)};
            }
        }
        return null;
    }
        //暴力法
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
