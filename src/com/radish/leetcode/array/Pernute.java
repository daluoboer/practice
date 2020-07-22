package com.radish.leetcode.array;

import java.util.ArrayList;
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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) return lists;
        //循环放？怎样获取全排列呢？把每个数在不同的位置进行组合，噢！第一个数可以放在哪几个位置上，然后后面的数可以放在哪几个位置上
        //应该用递归吧？或者迭代？迭代跟递归有啥区别？就是先求出两个的组合，再求出两个+一个的组合，逐步增加
        //
        return null;
    }

//    public List<List<Integer>> permute()permute
}
