package com.radish.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description Pernute
 *
 * 全排列
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
 *
 * @Author Radish
 * @Date 2020-04-25 10:42
 */
public class Pernute {
    public static void main(String[] args) {
        Pernute p = new Pernute();
        int[] ints = {1,2,3};
        List<List<Integer>> permute = p.permute(ints);
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        // nums.length个位置，第一个位置可以放0-n-1的数，第二个位置可以放剩下的数....
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path, used, nums, res);
        return res;
    }

    private void dfs(int depth, Deque<Integer> path, boolean[] used, int[] nums, List<List<Integer>> res) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.addLast(nums[i]);
            dfs(depth+1, path, used, nums, res);
            path.removeLast();
            used[i] = false;
        }
    }

//    public List<List<Integer>> permute()permute
}
