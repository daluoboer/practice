package com.radish.leetcode.array;
/**
 * @Description ErFen
 * @Author Radish
 * @Date 2020-11-03 11:35
 */
public class ErFen {
    public static void main(String[] args) {
        ErFen e = new ErFen();
        int[] ints = {1,2,3,4,10};
        int a = e.findB(ints, 5);
        System.out.println(a);
    }
    public int findB(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = -1;
        while (l <= r) {
            mid = l + (r-l)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public int findA(int[] nums, int tartget) {
        return findA(nums, 0, nums.length - 1, tartget);
    }
    public int findA(int[] nums, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l + (r - l)/2;
        if (nums[mid] == target) return mid;
        //左半段
        if (target > mid) {
            return findA(nums, mid + 1, r, target);
        } else {
            return findA(nums, l, mid - 1, target);
        }
        //右半段
    }
}
