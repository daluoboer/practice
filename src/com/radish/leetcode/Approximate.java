package com.radish.leetcode;

import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入
 * 复制
 * 5.5
 * 输出
 * 复制
 * 6
 * @Author Radish
 * @Date 2020/3/12
 */

public class Approximate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            float v = in.nextFloat();
            float v1 = v * 10;
            if (v1%10>=5) {
                System.out.println((int)v+1);
            } else {
                System.out.println((int)v);
            }
        }
    }
}
