package com.radish.leetcode.strs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 输入描述:
 * 输入N个字符
 *
 * 输出描述:
 * 输出该字符串反转后的字符串
 *
 * 示例1
 * 输入
 * 复制R
 * abcd
 * 输出
 * 复制
 * dcba
 * @Author Radish
 * @Date 2020/3/12
 */

public class FanZhuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.next();
            ArrayList<Character> characters = new ArrayList<>();
            for (int i = next.length()-1; i >= 0; i--) {
                characters.add(next.charAt(i));
            }
            for (Character c : characters) {
                System.out.print(c);
            }
        }
    }
}
