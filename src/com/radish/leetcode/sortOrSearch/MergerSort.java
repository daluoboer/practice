package com.radish.leetcode.sortOrSearch;

import com.radish.utils.MyUtils;

/**
 * @description MergerSort
 *
 * 归并排序！
 *
 * @Author Radish
 * @Date 2020-04-24 16:32:10
 */

public class MergerSort {
    public static void main(String[] args) {
        int[] ints = {};
        mergeSort(ints);
        MyUtils.print(ints);
    }

    //给数组排序
    public static void mergeSort(int[] nums) {
        if (nums.length == 0) return;
        //归并排序，将数组分成两个两个，进行排序，然后再将两个有序数组进行合并
        int[] tempArr = new int[nums.length];
        mergeSortArr(0,nums.length-1,nums,tempArr);
    }

    public static void mergeSortArr(int left, int right, int[] nums, int[] tempArr) {
        //当只有两个的时候，直接排序呗
        if (right == left) {
            return;
        }
        if (right - left == 1) {
            //交换呐
            if (nums[left] > nums[right]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            return;
        }

        //分成两半
        int mid = left + (right - left) / 2;
        //前半段
        mergeSortArr(left,mid,nums,tempArr);
        //后半段
        mergeSortArr(mid+1,right,nums,tempArr);

        //将这两段有序数组进行排序~
        mergeTwoArr(left,mid,right,nums,tempArr);
    }

    public static void mergeTwoArr(int left, int mid, int right, int[] nums, int[] tempArr) {
        //i,j为俩有序数组上的下标
        int i = left;
        int j = mid + 1;
        //k
        int k = left;
        while (k <= right) {
            if (j > right) {
               tempArr[k++] = nums[i++];
            } else if (i > mid) {
                tempArr[k++] = nums[j++];
            } else if (nums[i] <= nums[j]) {
                tempArr[k++] = nums[i++];
            } else {
                tempArr[k++] = nums[j++];
            }
        }
        for (int n = left; n <= right; n++) {
            nums[n] = tempArr[n];
        }
    }

}
