package com.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入
 * 复制
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出
 * 复制
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 * @Author Radish
 * @Date 2020/3/12
 */

public class SortString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strings.add(in.next());
            }
            Collections.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int n = o1.length() > o2.length() ? o2.length() : o1.length();
                    int flag = o1.length() > o2.length() ? 1 : o1.length() == o2.length() ? 0 : -1;
                    for (int i = 0; i < n; i++) {
                        if (o1.charAt(i)==o2.charAt(i)) continue;
                        flag = o1.charAt(i)>o2.charAt(i)?1:-1;
                        break;
                    }
                    return flag;
                }
            });
            for (String str : strings) {
                System.out.println(str);
            }
        }
    }
}
