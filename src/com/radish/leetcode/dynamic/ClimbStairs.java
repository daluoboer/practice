package com.radish.leetcode.dynamic;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }
    public static int climbStairs(int n) {
        //嗯？这是动态规划？这不是排列组合？
        //当n=2的时候有1+1和2两种，当n=3的时候
        //这么写咋有点像斐波那契数列呢？看起来是很简单，但是不知道为啥要这么写....
        //!ao!!!因为在爬n阶，其实就是爬n-1阶再爬一阶，或者爬n-2阶再爬2阶~哇哦对的！
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static int climbStairs2(int n) {
        //记忆化递归，先不管它为啥是斐波那契数列，反正是可以优化滴
        int memo[] = new int[n+1];
        return climb_stairs2(0,n,memo);
    }

    public static int climb_stairs2(int i, int n, int memo[]) {
        //e...仍然不明白为啥要这样写，不过画出来结构确实没错....
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_stairs2(i + 1, n, memo) + climb_stairs2(i + 2, n, memo);
        return memo[i];
    }

    //接下来瞅一瞅动态规划吧！
    public static int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
