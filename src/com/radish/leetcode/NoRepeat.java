package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 复制
 * 9876673
 * 输出
 * 复制
 * 37689
 * @Author Radish
 * @Date 2020/3/12
 */

public class NoRepeat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            while (n != 0) {
                int a = n%10;
                list.add(a);
                n/=10;
            }
            HashSet<Integer> set = new HashSet<>();
            for (Integer i : list) {
                if(set.add(i)){
                    System.out.print(i);
                }
            }
        }
    }
}
