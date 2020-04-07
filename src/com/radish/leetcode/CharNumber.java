package com.radish.leetcode;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 输出
 * 复制
 * 3
 * @Author Radish
 * @Date 2020/3/12
 */

public class CharNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.next();
            char[] chars = next.toCharArray();
            HashSet<Character> set = new HashSet<>();
            for (char c : chars) {
                if (c>0&&c<127){
                    set.add(c);
                }
            }
            System.out.println(set.size());
        }
    }
}
