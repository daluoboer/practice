package com.radish.leetcode.questionBank;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(batches("2[x]"));
    }

    /**
     * 1.先截取有效组合列表
     * 2.每一个有效组合解码为字符串
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        return null;
    }

    /**
     * 截取有效组合
     * @param s
     * @return
     */
    public static List<String> getStrs(String s) {
        return null;
    }

    public static String getDecodeStr(String s) {
        return null;
    }

    public static boolean batches(String s) {
        String pattern = "\\d+\\[\\w+\\]";
        return Pattern.matches(pattern,s);
    }
}
