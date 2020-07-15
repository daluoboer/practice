package com.radish.leetcode.dynamic;

import java.util.List;

/**
 * @description MinimumTotal
 *
 * 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @Author Radish
 * @Date 2020-07-14 10:24:28
 */

public class MinimumTotal {
    /**
     * 这...不是得比较嘛，看看第一个和每次改变一下的总和，求最小的，不过每次选完之后下一行只有俩选择，没想法......
     * 哇~这是1994年的国际竞赛题哎！现在成了学习动态规划的入门题？？？啧啧啧啧啧啧......太难了
     * 抄完答案之后的感想：
     * 就把公式写出来就好啦？就是一层一层算出来嘛~这还算动态规划嘛？动态规划不是边算边那啥吗？这是全都算出来比较大小哦~原来是这样的？？？
     * 所以...动态规划是推导过程，目的还是要求出非动态的实际数据，然后进行比较这样？好像也没那么难嘛！
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][0] = f[i-1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
        }
        int minTotal = f[n-1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal,f[n-1][i]);
        }
        return minTotal;
    }

    /**
     * 因为f[i][j]只与f[i-1]...有关，与f[i-2]...无关，所以只需要存储上一行数据即可~Word天！可太厉害了吧！牛掰~
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[2][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 0; i < n; ++i) {
            int curr = i % 2;
            int prev = 1 - curr;
            f[curr][0] = f[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < n; ++j) {
                f[curr][j] = Math.min(f[prev][j-1],f[prev][j]) + triangle.get(i).get(j);
            }
            f[curr][i] = f[prev][i] + triangle.get(i).get(i);
        }
        int minTotal = f[(n - 1) % 2][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal,f[(n - 1) % 2][i]);
        }
        return minTotal;
    }
}
