package com.radish.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description Subsets
 *
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @Author Radish
 * @Date 2020-09-20 20:43
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] ints = new int[]{1,2,3};
        List<List<Integer>> subsets = s.subsetsN(ints);
        System.out.println(subsets);
    }
    public List<List<Integer>> subsetsWrong(int[] nums) {
        //嗨呀，看来是力扣都要让我搞明白动态规划、深度优先遍历和回溯了，这几天全是全排列这种啊，嗷不对，这个是子集，不需要排序呀，这是排列组合啊
        //昨天做了一个子序列的问题，但是子序列是有序的，只需要截断，这个是要排列组合哎
        //咋去重啊....
        //你这个样子写是不对滴，哎...瞅瞅人家咋写的吧
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<Integer>();

        for (int i = 0; i <= nums.length; i++) {//i为子数组长度
            dfsW(0, i, nums, lists, path, used);
        }
        return lists;
    }

    //获取nums的元素个数为count的子集们
    private void dfsW(int depth, int count, int[] nums, List<List<Integer>> lists, Deque<Integer> path, boolean[] used) {
        if (depth == count) {
            lists.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfsW(depth + 1, count, nums,lists, path,used);
            path.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, path, res);
        return res;
    }

    //噢......所以不能用获取有序的再排除，应该直接在刚开始就换一种不同的计算方式~厉害厉害
    //哦哦这个不是回溯？是递归？嗯.....
    private void dfs(int cur, int[] nums, Deque<Integer> path, List<List<Integer>> res) {
        if (cur == nums.length) {//为啥直接用数组长度比较？子集的元素个数不一定等于length啊？
            res.add(new ArrayList<>(path));
            return;
        }
        path.addLast(nums[cur]);
        dfs(cur + 1, nums, path,res);
        path.removeLast();
        dfs(cur + 1, nums, path, res);
    }

    //卧槽!这也太神奇了吧！
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> plusNumbers = new ArrayList<>();
            for (List<Integer> result : results) {
                List<Integer> newNumber = new ArrayList<>(result);
                newNumber.add(nums[i]);
                plusNumbers.add(newNumber);
            }
            results.addAll(plusNumbers);
        }
        return results;
    }

    //神奇的位运算又来了
    public List<List<Integer>> subsetsBit(int[] nums) {
        return null;
    }

    //这个是回溯,不是很懂哎？
    public List<List<Integer>> subsetsN(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfsN(nums, 0, path, res);
        return res;
    }

    //e...很神奇的样子...但是这个逻辑不是很明白....
    private void dfsN(int[] nums, int start, Deque<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfsN(nums,i + 1,path,res);
            path.removeLast();
        }
    }



}
