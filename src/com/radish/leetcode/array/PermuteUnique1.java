package com.radish.leetcode.array;

import java.util.*;

/**
 * @Description PermuteUnique1
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
 * @Date 2020-10-28 10:49
 */
public class PermuteUnique1 {
    public static void main(String[] args) {
        PermuteUnique1 p = new PermuteUnique1();
        int[] ints = {1,1,2};
        List<List<Integer>> lists = p.permuteUnique(ints);
        System.out.println(lists);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 先找到所有的排列，再筛除重复的？
        // 处理的时候就排除这种情况
        // 先排序，然后再排列
        Arrays.sort(nums);
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
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //哎，这咋记录在当前这次循环中这个数有没有被用过呢
            if (used[i]) continue;
            if (!set.add(nums[i])) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(depth+1,path, used, nums, res);
            used[i] = false;
            path.removeLast();
        }
    }
}
