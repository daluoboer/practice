package com.radish.leetcode.strs;

/**
 * @Description RepeatedSubstringPattern
 *
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * @Author Radish
 * @Date 2020-08-24 14:25
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        boolean ababab = repeatedSubstringPattern("abaababaab");
        System.out.println(ababab);
    }

    //还可以优化噢~不拼接，直接比较
    public static boolean repeatedSubstringPattern(String s) {
        //也就是这个字符串是由某个字串组成的~
        int length = s.length();
        for (int i = 1; i <= length/2; i++) {
            if (length%i != 0) continue;
            //子串
            String s2 = s.substring(0, i);
            StringBuilder s1 = new StringBuilder();
            int i1 = length / i;
            while (i1-- > 0) {
                s1.append(s2);
            }
            if (s1.toString().equals(s)) return true;
        }
        return false;
    }
}
