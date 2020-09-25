package com.radish.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description Permute
 *
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @Author Radish
 * @Date 2020-09-18 23:12
 */
public class Permute {
    public static void main(String[] args) {
        Permute p = new Permute();
        int[] ints = new int[]{1,2,3};
        List<List<Integer>> permute = p.permute(ints);
        System.out.println(permute);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(nums, 0,  path, used, res);
        return res;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == nums.length) {
            res.add(new ArrayList<Integer>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
