package com.radish.leetcode.array;

/**
 * @Description IslandPerimeter
 *
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 * @Author Radish
 * @Date 2020-10-30 08:57
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] ints = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
//        int[][] ints = {
//                {1}
//        };
        int i = islandPerimeter.islandPerimeter(ints);
        System.out.println(i);
    }
    public int islandPerimeter(int[][] grid) {
        //因为只有一个陆地，所以找到陆地之后去找它周围相连的陆地即可
        //找到某一个单位陆地的边长，统计它的周长即可
        boolean[][] caled = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return getPerimeter(grid, i,j, caled);
                }
            }
        }
        return 0;
    }

    private int getPerimeter(int[][] grid, int i, int j, boolean[][] caled) {
        int perimeter = 0;
        if (grid[i][j] == 1) {
            caled[i][j] = true;
            //上
            if (i > 0){
                //如果这个格子为1，并且没有被加过
                if (grid[i-1][j] == 1) {
                    if (!caled[i-1][j]) perimeter += getPerimeter(grid, i - 1, j, caled);
                } else {
                    perimeter++;
                }
            } else perimeter++;
            //下
            if (i < grid.length - 1) {
                if (grid[i+1][j] == 1) {
                    if ( !caled[i+1][j]) perimeter += getPerimeter(grid, i+1, j, caled);
                } else {
                    perimeter++;
                }
            } else perimeter++;
            //左
            if (j > 0) {
                if (grid[i][j-1] == 1) {
                    if ( !caled[i][j-1])perimeter += getPerimeter(grid, i, j-1, caled);
                }else {
                    perimeter++;
                }
            } else perimeter++;
            //右
            if (j < grid[0].length - 1) {
                if (grid[i][j + 1] == 1) {
                    if ( !caled[i][j+1]) perimeter += getPerimeter(grid, i, j+1, caled);
                }else {
                    perimeter++;
                }
            } else perimeter++;
        }
        return perimeter;
    }
}
