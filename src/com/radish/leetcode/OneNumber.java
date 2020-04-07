package com.radish.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入
 * 复制
 * 5
 * 输出
 * 复制
 * 2
 * @Author Radish
 * @Date 2020/3/13
 */

public class OneNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int number = 0;
            while (n!=0){
                if (n%2==1) number++;
                n/=2;
            }
            System.out.println(number);
        }
    }
}
