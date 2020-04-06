package com.radish.leetcode.questionBank;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 2:abc
 *
 * 3:def
 *
 * 4:ghi
 *
 * 5:jkl
 *
 * 6:mno
 *
 * 7:pqrs
 *
 * 8:tuv
 *
 * 9:wxyz
 *
 */
public class LetterCombinations {

    static {
        List<char[]> numberList = new ArrayList<>();
        numberList.add(null);
        numberList.add(null);
        numberList.add("abc".toCharArray());
        numberList.add("def".toCharArray());
        numberList.add("ghi".toCharArray());
        numberList.add("jkl".toCharArray());
        numberList.add("mno".toCharArray());
        numberList.add("pqrs".toCharArray());
        numberList.add("tuv".toCharArray());
        numberList.add("wxyz".toCharArray());
        StringBuilder stringBuilder = new StringBuilder("[");
        for (char[] chars : numberList) {
            stringBuilder.append(print(chars));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> list = new ArrayList<>();
        if (chars.length > 0) {
            for (char c : chars) {

            }
        }
        return list;
    }

    public List<String> setNumber(List<String> list, Integer number) {
        if (number > 1 && number < 10) {

        }
        return list;
    }

    public static StringBuilder print(char[] chars) {
        StringBuilder str = new StringBuilder("[");
        if (chars != null && chars.length > 0) {
            for (char c : chars) {
                str.append(c+",");
            }
        }
        str.append("]");
        return str;
    }

    public static void main(String[] args) {
        letterCombinations("1");
    }
}
