package com.radish.leetcode.strs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 描述：
 *
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 *
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 复制
 * 1516000
 * 输出
 * 复制
 * 0006151
 * @Author Radish
 * @Date 2020/3/12
 */
public class FanXu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            while (n != 0) {
                list.add(n%10);
                n/=10;
            }
            for (Integer i : list) {
                System.out.print(i);
            }
        }
    }
}
