package com.radish.leetcode.array;

/**
 * @description MaximalSquare
 *
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * @Author Radish
 * @Date 2020-05-08 17:12:43
 */

public class MaximalSquare {
    /*
    怎样找到正方形呢？
    1.记录最大的正方形起点和边长，当有1存在时，边长为1，继续遍历
    2.以某数为起点，查看它的横向竖向是否都是1，如果都是还要判断该正方形中是否都是1
     */

    public static int maximalSquare(char[][] matrix) {

        //最大正方形的起始点
        int curMaxStartX = 0;
        int curMaxStartY = 0;
        //最大正方形的边长
        int curMaxLength = 0;
        //当前正方形的起始点
        int curStartX = 0;
        int curStartY = 0;
        //当前正方形的边长
        int curLength = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    //如果这个点为1，要以它为起点拓展一个正方形

                }
            }
        }
        return 1;
    }

    public static int getLength(int startX, int startY, char[][] matrix) {
        int curX = startX;
        int curY = startY;
        while (matrix[curX][curY] == 1) {

        }
        return 1;
    }

}
