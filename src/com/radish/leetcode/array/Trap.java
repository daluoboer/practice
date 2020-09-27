package com.radish.leetcode.array;

/**
 * @Description Trap
 *
 *   接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @Author Radish
 * @Date 2020-09-26 14:06
 */
public class Trap {
    public static void main(String[] args) {
        Trap t = new Trap();
//        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] ints = {1,7,5};
        int[] ints = {4,3,3,9,3,0,9,2,8,3};
//        int[] ints = {5,2,1,2,1,5};
//        int[] ints = {9,8,2,6};
        int trap = t.trap(ints);
        System.out.println(trap);
    }

    //一列一列接雨水，啊可是一列一列去接的话，还要涉及其他列哎，其实就是一块一块去接了，ok
    public int trap(int[] height) {

        return 0;
    }

    //一行一行接雨水
    public int trapInLine(int[] height) {
        if (height.length == 0) return 0;
        //为什么不一行一行地接呢？每一行只要被有数的包围的即是雨水
        //可以一行一行地接，也可以一列一列地接，还可以一块一块地接
        //下面就一行一行接吧！
        int sum = 0;
        //嗷！要找到最大值啊，你咋以下标去计算了呢
        int max = height[0];
        int min = height[0];
        for (int i : height) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        //啊！最后一个用例超出时间限制了耶，那就少循环几次，把最小值也求出来~
        //啊还是超时哎，那就试试一列一列接雨水吧，感觉一列一列效率会高一些
        for (int i = 0; i < max; i++) {
            //第i行
            //第j列
            //从第一个该值大于i的值开始，从第一个小于i的值开始计算，到下一个大于i的值结束
            int start = 0;
            int j = 0;
            while (j < height.length) {
                //找到大于i高度的值，即雨水的前一块
                while (j < height.length) {
                    if (height[j] > i) {
                        j++;
                        break;
                    }
                    j++;
                }

                //找到雨水开始的地方
                while (j < height.length) {
                    if (height[j] <= i) {
                        start = j++;
                        break;
                    }
                    j++;
                }

                while (j < height.length) {
                    if (height[j] > i) {
                        sum += j - start;
                        break;
                    }
                    j++;
                }
            }
        }
        return sum;
    }
}
