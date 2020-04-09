package com.radish.leetcode.design;

import com.radish.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description practice
 *
 * Shuffle an Array
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * @Author Radish
 * @Date 2020/4/9
 */

public class ShuffleArray {
    public static void main(String[] args) {
        ShuffleArray shuffleArray = new ShuffleArray(new int[]{1, 2, 3, 4, 5});
        MyUtils.print(shuffleArray.shuffle());
        MyUtils.print(shuffleArray.shuffle());
        MyUtils.print(shuffleArray.shuffle());
        MyUtils.print(shuffleArray.shuffle());
        MyUtils.print(shuffleArray.shuffle());
        System.out.println();
        int[] reset = shuffleArray.reset();
        MyUtils.print(reset);
    }
    private Random rand = new Random();
    int[] nums;
    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = new int[nums.length];
        //随机返回
        //把下标放到set中，每次随机获取一个然后将它从set中删除
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int n = rand.nextInt(list.size());
            result[i] = nums[list.get(n)];
            list.remove(n);
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */