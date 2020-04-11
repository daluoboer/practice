package com.radish.leetcode.other;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Description IsValidBracket
 *
 *   有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @Author Radish
 * @Date 2020-04-11 20:21
 */
public class IsValidBracket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            boolean valid = isValid(in.next());
            System.out.println(valid);
        }
    }
    //哈哈哈哈哈哈可以用栈啊！左括号就入栈遇到右括号就出栈，看看匹不匹配就行啦！
    public static boolean isValid(String s) {
        LinkedList<String> queue = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            String str = s.substring(i, i + 1);
            String peek = queue.peek();
            i++;
            if (str.equals(")")) {
                if (!Objects.equals(peek, "(")) return false;
                queue.pop();
                continue;
            }
            if (str.equals("]")) {
                if (!Objects.equals(peek, "[")) return false;
                queue.pop();
                continue;
            }
            if (str.equals("}")) {
                if (!"{".equals(peek)) return false;
                queue.pop();
                continue;
            }
            queue.push(str);
        }
        if (queue.size() > 0) return false;
        return true;
    }
}
