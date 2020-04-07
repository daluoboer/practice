package com.radish.leetcode.interesting;

import java.util.Scanner;

/**
 * @Description
 *
 * 面试题64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 * 神奇的题目
 *
 * @Author Radish
 * @Date 2020/4/2
 */

public class SumNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("求0-n的和，请输入n：");
            int i = in.nextInt();
            System.out.println("结果为：" + sumNums(i));
        }
    }
    public static int sumNums(int n) {
        int sum = n;
        boolean flag = (n > 0) && (sum += sumNums(n-1)) > 0;
        return sum;
    }
}
