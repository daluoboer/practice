package com.radish.leetcode.maths;

import com.radish.utils.MyUtils;

/**
 * @description UpdateMatrix
 *
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * @Author Radish
 * @Date 2020-04-15 13:40:49
 */

public class UpdateMatrix {

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,1},{1,0}};
//        int[][] ints = new int[][]{{0,0,0,1},{0,1,0,1},{1,1,1,0},{1,1,1,1}};
        /*int[][] ints = new int[][]{
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}
        };*/
        int[][] ints1 = updateMatrix(ints);
        MyUtils.print(ints1);
    }


    public static int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i < matrix.length; j++) {
                fillData(matrix,result,i,j);
            }
        }
        return result;
    }

    //当有值被填充时，去查看前面的值是否可以进行填充
    public static void setBeforeData(int[][] matrix, int[][] result, int i, int j) {
        for (int m = i,n = j-1; m >= 0; m--,n = matrix.length-1) {
            for (; n >= 0; n--) {
                fillData(matrix,result,m,n);
            }
        }
    }

    public static void fillData(int[][] matrix, int[][] result, int i, int j) {
        //应该求出一个值就去判断它前面应该走过的值有没有走过，如果没有走过就进行填充啊！
        //当前值为0，直接填充
        if (matrix[i][j] == 0) {
            result[i][j] = 0;
            //填充前面的值
            setBeforeData(matrix,result,i,j);
            return;
        }

        //-1表示边缘，无需管这个值，-2表示该值未取到，需要往后遍历查找0
        int top = i > 0 ? (matrix[i-1][j] == 0 ? 0 : (result[i-1][j] > 0 ? result[i-1][j] : -2)) : -1;
        int left = j > 0 ? (matrix[i][j-1] == 0 ? 0 : (result[i][j-1] > 0 ? result[i][j-1] : -2)) : -1;
        int down = i < matrix.length-1 ? (matrix[i+1][j] == 0 ? 0 : -2) : -1;
        int right = j < matrix.length-1 ? (matrix[i][j+1] == 0 ? 0 : -2) : -1;

        //如果边上有0，直接填充
        if (top == 0 || left == 0 || down == 0 || right == 0) {
            result[i][j] = 1;
            //填充前面的值
            setBeforeData(matrix,result,i,j);
            return;
        }

        //上下左右的值都可以确定的话，当前值可以直接进行填充
        if (top > -2 && left > -2 && down > -2 && right > -2) {
            //按说不能全是-1
            int minW = getMinW(getMinW(top, left), getMinW(down, right));
            result[i][j] = minW + 1;
            //填充前面的值
            setBeforeData(matrix,result,i,j);
        }
    }




    //这种做法不太对哦，要从0扫，向外扩展
    public static int[][] updateMatrixW(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return matrix;
        int[][] result = new int[matrix.length][matrix[0].length];
        //遍历每一个数的上下左右？可以上下左右都没有怎么办呢？上面的上面，上面的左边，上面的右边，这些要怎样查找呢？先找到一个0的坐标，根据坐标遍历求得x和y的差值？上下左右，上下左右的上下左右
        //肯定不能一个一个遍历的，应该根据上下左右的值来计算，啊！迭代吗？迭代和递归是啥意思呢？总之就是先把能求出来的求出来，不能求出来的先把旁边的求出来它自然也就出来啦
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    continue;
                }

                if (result[i][j] > 0) {
                    continue;
                }

                //如果还没有填过这个值，填值
                setADataW(matrix, result, i, j);

            }
        }
        return result;
    }

    //返回一个距离
    public static int setADataW(int[][] matrix, int[][] result, int i, int j) {
        if (matrix[i][j] == 0) {
            result[i][j] = 0;
            return 0;
        }
        //比较上下左右与0的距离

        //如果上面和左边都已经得到结果了，要么该位是0，要么结果>0
        int top = -1;
        int left = -1;

        //这里不对啊，如果是从上面递归找下来的....就错了
        //如果上面的数据还没有填充，说明是从上面找下来的啊，
        //啊还是不对啊！如果是从上面找下来的你给人家一个-1，那不就错啦，人家可是有值的，只是暂时没有计算出来而已
        //(⊙o⊙)…所以从头遍历是不对哒！应该像扫雷那样才行啊！从0展开，可是应该怎么展开呢？想一哈~还得把这个位置先记着，然后算完它周围的再去计算它
        if (i > 0) {
            if (matrix[i-1][j] == 0) {
                top = 0;
            }
            else top = result[i-1][j] > 0 ? result[i-1][j] : -1;
        }
        if (j > 0) {
            if (matrix[i][j-1] == 0) {
                left = 0;
            } else left = result[i][j-1] > 0 ? result[i][j-1] : -1;
        }

        if (top == 0 || left == 0) {
            result[i][j] = 1;
            return 1;
        }

        int down = i < matrix.length - 1 ? setADataW(matrix, result, i + 1, j) : -1;
        int right = j < matrix.length - 1 ? setADataW(matrix, result, i, j + 1) : -1;

        int min = getMinW(getMinW(top, left), getMinW(down, right)) + 1;
        result[i][j] = min;
        return min;
    }

    public static int getMinW(int i1, int i2) {
        if (i1 == i2 && i1 == -1) {
            return -1;
        }
        if (i1 == -1 || i2 == -1) {
            return i1 == -1 ? i2 : i1;
        }
        return i1 > i2 ? i2 : i1;
    }
}
