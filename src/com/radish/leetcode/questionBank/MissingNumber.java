package com.radish.leetcode.questionBank;

/**
 *
 *   缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,7,6,8};
        System.out.println(missingNumber(nums));
    }

    /**
     * 查找缺失
     * 天呐！你居然想要通过排序找出来！这个是啥时候写的，求和！很机智了！
     * e...不对呀，这个是从0开始的？但是这个题意不是耶
     * 所以找出最大值和最小值就可以了！ok！
     * 不对耶，就是0-n！那根本就不需要求最大最小值了啊！
     * @param nums
     * @return
     */
    public static int missingNumberEasy(int[] nums) {
        int shouldSum = (nums.length+1)*(nums.length)/2;
        int sum = 0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
        }
        return shouldSum - sum;
    }


    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
            sum += nums[i];
        }
        int shouldSum = (min + max) * (nums.length + 1)/2;
        return shouldSum-sum;
    }

}
