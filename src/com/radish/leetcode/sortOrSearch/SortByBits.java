package com.radish.leetcode.sortOrSearch;

import com.radish.utils.MyUtils;

/**
 * @Description SortByBits
 *
 * 1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 *
 * @Author Radish
 * @Date 2020-11-08 20:45
 */
public class SortByBits {
    public static void main(String[] args) {
        SortByBits s = new SortByBits();
//        int[] ints = {0,1,2,3,4,5,6,7,8};
//        int[] ints = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] ints = {10000,10000};
//        int[] ints = {2,3,5,7,11,13,17,19};
//        int[] ints = {10,100,1000,10000};
        int[] ints1 = s.sortByBits(ints);
        MyUtils.print(ints1);
    }
    public int[] sortByBits1(int[] arr) {
        //先获取二进制的个数，如果个数相同的再按照数值大小排序
        //冒泡吧...不想冒泡，效率太低了，堆排序？咋排来着？那快排？罢了，还是冒吧
        //e....冒超时了，还是快排吧
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                //
                //咋求1的个数呢？跟全是1的数与？那有啥意义呢
                int count = get1Count(arr[i]);
                int count1 = get1Count(arr[j]);
                if (count > count1 || (count == count1 && arr[i] > arr[j])) {
                    swap(arr, i,j);
                }
            }
        }
        return arr;
    }

    //快排
    public int[] sortByBits(int[] arr) {
        quickByBits(arr, 0, arr.length-1);
        return arr;
    }

    private void quickByBits(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        //在i上挖坑填数
        int cur = arr[i];
        int count = Integer.bitCount(cur);
        while (i < j) {
            while (i < j && (Integer.bitCount(arr[j]) > count || (Integer.bitCount(arr[j]) == count && arr[j] >= cur))) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && (Integer.bitCount(arr[i]) < count || (Integer.bitCount(arr[i]) == count && arr[i] <= cur))) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = cur;
        quickByBits(arr, l,i-1);
        quickByBits(arr,i+1,r);
    }

    private void quickByBits2(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        //在i上挖坑填数
        int cur = arr[i];
        int count = get1Count(cur);
        while (i < j) {
            while (i < j && (get1Count(arr[j]) > count || (get1Count(arr[j]) == count && arr[j] >= cur))) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && (get1Count(arr[i]) < count || (get1Count(arr[i]) == count && arr[i] <= cur))) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = cur;
        quickByBits(arr, l,i-1);
        quickByBits(arr,i+1,r);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int get1Count(int i) {
        String s = Integer.toBinaryString(i);
        String s1 = s.replaceAll("1", "");
        return s.length() - s1.length();
    }
}
