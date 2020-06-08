package com.radish.leetcode.maths;

import java.util.Scanner;

/**
 * @description MySqrt
 *
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * @Author Radish
 * @Date 2020-05-09 13:46:39
 */

public class MySqrt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int i = in.nextInt();
            if (i <= 0) return;
            System.out.println(i + "的平方根是：" + mySqrt(i));
        }
    }
    public static int mySqrt(int x) {
        //好像做过？但是忘了具体方法了，先遍历吧！
        int result = 1;
        while (result <= x/2 && ((result+1) * (result+1)) <= x) {
            result++;
        }
        return result;
        //有时候不对？？为啥呢？之前是用的二分查找，啊啊啊啊啊啊啊好烦躁啊，一点都静不下心
    }
}
