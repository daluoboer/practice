package com.radish.leetcode.dynamic;

/**
 * 使用最小花费爬楼梯
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]
 */
public class MinCostClimbStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1,2,3,4,5}));
    }
    public static int minCostClimbingStairs(int[] cost) {
        //？可以从索引1开始？啥意思捏？哦就是从楼梯下面上到第一阶或者第二阶楼梯上！
        //动态规划 f(cost[n]) = f(cost[n-1]) + f(cost[n-2])

        //e....但是应该怎么做呢？
        //啊~挨着的两阶肯定是需要走一阶的，那就选择小的那一阶啊,
        /*int minCost = 0;
        for (int i = 1; i < cost.length; ) {
            if (cost[i-1]<cost[i]) {
                minCost += cost[i-1];
                i = i - 1 + 2;
            } else {
                minCost += cost[i];
                i = i + 2;
            }
        }
        return minCost;*/
        //e不对不对，上面的公式不应该是这样用的啊
        //mincost(n) = cost(n) + mincost(cost[n+1],cost[n+2])嗯？为啥是+呢
        int minCost = 0;

        return 0;
        //累了，不想做了....换一个~
    }

}
