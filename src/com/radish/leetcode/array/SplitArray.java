package com.radish.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description SplitArray
 *
 *  分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * @Author Radish
 * @Date 2020-07-27 14:01:29
 */

public class SplitArray {
    public int splitArray(int[] nums, int m) {
        //最好的情况就是m个数组和相等，那最大值肯定最小了啊~就是让每一个数组之和最接近平均数嘛~
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        double average = sum / m;

        List<List<Integer>> resultSubs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> list = new ArrayList<>(nums.length/m);

        }

        return 0;
    }

    public int splitT(int[] nums, int startIndex, double average, ArrayList<Integer> list) {
        int sum = 0;
        for (int i = startIndex; i < nums.length && sum < average; i++) {
            sum += nums[i];
            list.add(nums[i]);
        }
        //比较一下当前数组最接近平均值的总和，可是可能会影响下一个数组的和啊
        //哦你错啦！应该用用动态规划啊！
        return 0;
    }

}
