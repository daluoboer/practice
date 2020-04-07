package com.example.examine;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/3
 */

public class InsertNum {
    public static void main(String[] args) {
        int[] ints = insertNum(new int[]{1, 2, 3, 4, 5, 6}, 6);
        for (int i : ints) {
            System.out.print(i + ", ");
        }
    }
    public static int[] insertNum(int[] nums, int n) {
        //数组插入一个新的数
        int[] result = new int[nums.length + 1];
        int index = getIndex(nums, 0, nums.length - 1, n);
        int i = 0;
        for (; i < index; i++) {
            result[i] = nums[i];
        }
        result[i++] = n;
        for (; i <= nums.length; i++) {
            result[i] = nums[i-1];
        }
        return result;
    }


    public static int getIndex(int[] nums, int l, int r,int n) {
        if (l >= nums.length || r < 0) {
            return 0;
        }
        if (l == r) {
            return l;
        }
        int midIndex = (l+r)/2;
        int mid = nums[midIndex];
        //n在该值左侧
        if (mid> n) {
            return getIndex(nums,l,midIndex-1,n);
        }
        if (mid < n) {
            //n在该值右侧
            return getIndex(nums,midIndex+1,r,n);
        }
        return midIndex;
    }
}
