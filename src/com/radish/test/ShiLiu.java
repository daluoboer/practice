package com.radish.test;

import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 * 示例1
 * 输入
 * 复制
 * 0xA
 * 输出
 * 复制
 * 10
 * @Author Radish
 * @Date 2020/3/12
 */

public class ShiLiu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.next();
            String s = next.toUpperCase();
            char[] chars = s.toCharArray();
            int num = 0;//十进制结果
            int multiple = 1;
            for (int i = chars.length-1; i > 1; i--) {
                if (chars[i]>57){//字母
                    num += ((int)chars[i]-55)*multiple;
                } else {//数字
                    num +=((int)chars[i]-48)*multiple;
                }
                multiple*=16;
            }
            System.out.println(num);
        }
    }
}
