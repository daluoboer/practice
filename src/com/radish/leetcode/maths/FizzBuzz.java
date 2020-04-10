package com.radish.leetcode.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * @description FizzBuzz
 *
 * Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *
 * @Author Radish
 * @Date 2020/4/918:17
 */

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(20));
    }
    public static List<String> fizzBuzz(int n) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            strings.add(getS(i));
        }
        return strings;
    }
    public static String getS(int i) {
        //根据数字返回它对应的字符串
        if (i%3==0 && i%5 == 0) {
            return "FizzBuzz";
        }
        if (i%3 == 0) {
            return "Fizz";
        }
        if (i%5 == 0) {
            return "Buzz";
        }
        return String.valueOf(i);
    }
}
