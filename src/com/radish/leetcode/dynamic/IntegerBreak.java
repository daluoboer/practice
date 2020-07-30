package com.radish.leetcode.dynamic;

/**
 * @description IntegerBreak
 *
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * @Author Radish
 * @Date 2020-07-30 14:06:46
 */

public class IntegerBreak {
    public int integerBreak(int n) {
        //不会做哎~
        /*如果是给你个数让你手算呢
        假如给个数，比方5，那肯定是拆分成大于1的数乘积才会大，
        拆成2和3，再往外拆就有1了
        那如果是8呢
        2 2 2 2；4 4；3 3 2；3 5； 2 6；  好难啊 有啥规律吗
        * */
        //哦哦哦所以要用动态规划嘛！你不知道是因为要动态地去看啊！哎呀傻！
        //哇好简单啊 不过看不懂....
        /*n的最大乘积：k为分出的第一个整数，那么剩下的数的和是n-k，
        最大乘积为：Math.max(k*(n-k),k*dp[n-k])
        但是为啥还要比较本身和上面的值呢
         */
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax,Math.max(j * (i-j),j * dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
