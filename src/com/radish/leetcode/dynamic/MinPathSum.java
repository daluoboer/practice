package com.radish.leetcode.dynamic;

import com.radish.utils.MyUtils;

/**
 * @Description MinPathSum
 *
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 从[0,0]到[i,j]的和为：f([i-1,j]) + num[i,j] 或者 f([i,j-1]) + num[i,j]，也就是min(f([i-1,j]),f([i,j-1])) + num[i,j]
 *
 * f(0,0) = num[0,0];
 *
 * f([0,j]) = f([0,j-1]) + num[0,j]
 *
 * f([i,0]) = f([i-1,0]) + num[i,0]
 *
 * @Author Radish
 * @Date 2020-07-23 22:26
 */
public class MinPathSum {
    public static void main(String[] args) {
        int i = minPathSum2(new int[][]{{1, 2, 5},{3,2,1}});
        System.out.println(i);
    }
    //这个比较占内存，但是实际上不需要存储那么多数据，因为每一行的数只跟本行和上一行 的值有关，所以存储两行就够了
    public static int minPathSum(int[][] grid) {
        int[][] f = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    f[0][0] = grid[0][0];
                } else if (i == 0) {
                    f[0][j] = f[0][j-1] + grid[0][j];
                } else if (j == 0) {
                    f[i][0] = f[i-1][0] + grid[i][0];
                } else {
                    f[i][j] = Math.min(f[i-1][j],f[i][j-1]) + grid[i][j];
                }
            }
        }
        MyUtils.print(f);
        return f[f.length-1][f[0].length-1];
    }

    //咦？咋回事儿？这咋比上面慢还比上面占内存呢？不应当啊
    public static int minPathSum2(int[][] grid) {
        int[][] f = new int[2][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    f[0][0] = grid[0][0];
                } else if (i == 0) {
                    f[0][j] = f[0][j-1] + grid[0][j];
                } else if (j == 0) {
                    f[i%2][0] = f[(i-1)%2][0] + grid[i][0];
                } else {
                    f[i%2][j] = Math.min(f[(i-1)%2][j],f[i%2][j-1]) + grid[i][j];
                }
            }
        }
        MyUtils.print(f);
        return f[(grid.length-1)%2][f[0].length-1];
    }
}
