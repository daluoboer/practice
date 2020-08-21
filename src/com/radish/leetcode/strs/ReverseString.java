package com.radish.leetcode.strs;

/**
 * @Description ReverseString
 *
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * @Author Radish
 * @Date 2020-08-20 19:22
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] chars = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString1(chars);
    }
    public static void reverseString1(char[] s) {
        int i = 0,j = s.length-1;
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }

        //噢~其实你写这种就是双指针的意思嘛~只不过没有写明双指针，而是用一个下标计算出要交换的下标
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}
