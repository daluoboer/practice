package com.radish.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description PermuteUnique
 *
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * @Author Radish
 * @Date 2020-09-18 22:39
 */
public class PermuteUnique {
    //先排序再遍历，可否？先将相同的数字放一块，然后第一轮循环的时候相同数字只遍历一次，但是你咋知道有几个相同的数字，要遍历几次呢？
    //换个思路，如果没有重复数字，其实不就是将下标进行全排列嘛，那么怎么将0-10进行全排列呢？应该用迭代，拎出来一个数，然后看剩下的数的排列方法，然后再将这个数插进去，嗯对的
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) return lists;

        //used
        //path

        Arrays.sort(nums);

        return null;
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] a,b;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                a = Arrays.copyOfRange(nums, 0, i);
                b = Arrays.copyOfRange(nums,i,nums.length);
                List<List<Integer>> lists1 = permuteUnique1(concat(a, b));
            }
        }
        return lists;
    }

    public int[] concat(int[] a, int[] b) {
        int l = a.length + b.length;
        int[] c = new int[l];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = a.length; i < l; i++) {
            c[i] = b[i];
        }
        return c;
    }
}
