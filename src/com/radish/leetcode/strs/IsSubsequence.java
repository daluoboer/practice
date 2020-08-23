package com.radish.leetcode.strs;

/**
 * @description IsSubsequence
 *
 * 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢:
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *
 * @Author Radish
 * @Date 2020-07-27 10:30:51
 */

public class IsSubsequence {
    public static void main(String[] args) {
        boolean subsequence = isSub( "abdeg","abcdefg");
        System.out.println(subsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        //暴力查找，找到第一个相同的字母，然后查找第二个字母，......然后查找第n个字母
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            j = getIndexOfWord(t, s.charAt(i), j);
            if (j == -1) return false;
            j++;
        }
        return true;
    }

    public static int getIndexOfWord(String t, char c, int startIndex) {
        //查询字符c从startIndex开始第一次在s中出现的位置并返回
        int i = t.indexOf(c, startIndex);
        return i;
    }

    //o看人家写的可以用递归耶，直接截取字符串后调用自己，试试吧，你得连连递归呀
    public static boolean isSub(String s, String t) {
        if ("".equals(s)) {
            return true;
        }
        if ("".equals(t)) {
            return false;
        }
        if (s.charAt(0) == t.charAt(0)) {
            return isSub(s.substring(1),t.substring(1));
        }
        if (s.charAt(0) != t.charAt(0)) {
            return isSub(s,t.substring(1));
        }
        return false;
    }
}
