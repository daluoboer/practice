package com.example.leetcode;

import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 *
 * 接口说明
 *
 * /**
 *  * 反转句子
 *  *
 *  * @param sentence 原句子
 *  * @return 反转后的句子
 *  *
 *public String reverse(String sentence);
        *
        *
        *
        *
        *
        *
        *
        *输入描述:
        *将一个英文语句以单词为单位逆序排放。
        *
        *输出描述:
        *得到逆序的句子
        *
        *示例1
        *输入
        *复制
        *I am a boy
        *输出
        *复制
        *boy a am I
 * @Author Radish
 * @Date 2020/3/12
 */

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            System.out.println(reverse(next));
        }
    }

    public static String reverse(String sentence){
        String[] s = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = s.length-1; i >= 0; i--) {
            builder.append(s[i]);
            if (i!=0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
