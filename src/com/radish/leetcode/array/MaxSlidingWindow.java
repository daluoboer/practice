package com.radish.leetcode.array;

import com.radish.utils.MyUtils;

import java.util.ArrayDeque;

/**
 * @Description MaxSlidingWindow
 *
 * 面试题59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小
 *
 * @Author Radish
 * @Date 2020/4/1111:36
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1, 2, 5, 7, 0, 3, 6, 10}, 16);
        MyUtils.print(ints);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);
        //可是即使用队列，还是要比较啊，啊！只需要比较取出的值和新存入的值即可，可是如果有重复的值呢?
        return null;
    }
    //啊现在这样多比较了好多次，其实每次只需要跟前面的最大值比较，不对不对，是滑动的啊，最前面和最后面的数都不同~
    //看了一下人家写的，可以用双端队列~
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length==0) {
            return new int[0];
        }
        //一个数组在每段窗口中的最大值
        //当窗口值>数组长度
        if (k >= nums.length) {
            return new int[]{getMaxOfArray(nums,0,nums.length-1)};
        }
        //窗口值<数组长度
        int i = 0;
        int[] result;
        result = new int[nums.length - k + 1];
        while (i<=nums.length-k) {
            int maxOfArray = getMaxOfArray(nums, i, i + k - 1);
            result[i++] = maxOfArray;
        }
        return result;
    }

    public static int getMaxOfArray(int[] arr, int begin, int end) {
        if (end > arr.length) end = arr.length-1;
        int max = arr[begin];
        for (int i = begin + 1; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
