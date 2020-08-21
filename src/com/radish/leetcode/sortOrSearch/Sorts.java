package com.radish.leetcode.sortOrSearch;

/**
 * @Description Sorts 排序算法
 * @Author Radish
 * @Date 2020-08-21 09:40
 */
public class Sorts {
    public static void main(String[] args) {
        int[] ints = {5, 3, 10, 1};
//        sort3(ints);
        /*quickSort(ints,0,3);
        MyUtils.print(ints);*/
        int i = erFen(ints, 11, 0, ints.length);
        System.out.println(i);
    }
    //冒泡：最小的冒头
    //选择排序：找到最小值放到第一个
    //插入排序：从第一个元素开始，认为已经排序，将后面的元素插入到已有的有序数组中
    public static void sort3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int preIndex = i-1;
            int cur = nums[i];
            while (preIndex >= 0 && nums[preIndex] > cur) {
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = cur;
        }
    }
    //快排：（挖坑填数）
    public static void quickSort(int[] nums, int l, int r) {
        int i = l, j = r;
        if (i>=j) return;
        //基准数
        int cur = nums[l];
        while (i < j) {
            //从后往前找一个小于基准的数
            while (i<j && nums[j] > cur) {
                j--;
            }
            if (i>=j) continue;
            nums[i++] = nums[j];
            //从前往后找一个大于基准的数
            while (i<j && nums[i] <= cur) {
                i++;
            }
            if (i>=j) continue;
            nums[j--] = nums[i];
        }
        nums[i] = cur;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }

    //二分查找
    public static int erFen(int[] nums, int target, int l, int r) {
        if (l>r) return -1;
        int mid = l + (r-l)/2;
        if (nums[mid] < target) return erFen(nums,target,l, mid - 1);
        if (nums[mid] > target) return erFen(nums,target, mid + 1, r);
        return mid;
    }
}
