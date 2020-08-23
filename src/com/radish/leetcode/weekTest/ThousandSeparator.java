package com.radish.leetcode.weekTest;

/**
 * @Description ThousandSeparator
 *
 * 5479. 千位分隔数 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数1
 * 用户总通过次数0
 * 用户总提交次数1
 * 题目难度Easy
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 987
 * 输出："987"
 * 示例 2：
 *
 * 输入：n = 1234
 * 输出："1.234"
 * 示例 3：
 *
 * 输入：n = 123456789
 * 输出："123.456.789"
 * 示例 4：
 *
 * 输入：n = 0
 * 输出："0"
 *
 *
 * 提示：
 *
 * 0 <= n < 2^31
 *
 * @Author Radish
 * @Date 2020-08-22 22:32
 */
public class ThousandSeparator {
    public static void main(String[] args) {
        String s = thousandSeparator(123456789);
        System.out.println(s);
    }
    public static String thousandSeparator(int n) {
        String str = String.valueOf(n);
        if (str.length() <= 3) return str;
        StringBuilder builder = new StringBuilder();
        int i1 = str.length() % 3;
        int i = str.length() / 3;
        if (i1 != 0) builder.append(str.substring(0,i1) + '.');
        int j = 0;
        for (; j < i - 1; j++) {
            builder.append(str.substring(i1+3*j,i1+3*(j+1)) + '.');
        }
        builder.append(str.substring(i1+3*j,i1+3*(j+1)));
        return builder.toString();
    }
}
