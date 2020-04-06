package com.radish.leetcode.questionBank;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,3,4};
        System.out.println(missingNumber(nums));
    }

    /**
     * 查找缺失
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int shouldSum = (nums.length+1)*(nums.length)/2;
        int sum = 0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
        }
        return shouldSum - sum;
    }
}
