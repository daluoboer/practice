package com.radish.leetcode.questionBank;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
public class NumIslands {
    public static void main(String[] args) {
        int j = 0;
        j = j++;
        /*int j = 0;
        for (int i = 0; i < 10; i++) {
            j = (j++);
        }
        System.out.println(j);*/
    }
    /*找到1，1的上下左右要么没有东西，要么全为0；
    可是一片岛屿要咋算呢：从左到右、从上到下一片一片扫描式计算，额可是也不对呀，不能田字格扫描
    啊！一行一行扫描，一行的算一块，查出来一共有几块，然后看它的上下有没有相连的，如果有，数量减一！
    啊也不行耶，如果有相邻的就减一，那可以其实有两块岛屿，最后都减完了
    011000
    011101
    000010
    000100*/

    /*这个是广度优先搜索噢！先把广度优先搜索看了*/
    /*public int numIslands(char[][] grid) {
        *//*记录当前是水还是岛屿，发生变化时应当判断周围环境*//*
        int curStatus = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length-1; j++) {
                if (curStatus != grid[i][j+1]) {

                }
            }
        }
        return 0;
    }*/
}
