package com.radish.leetcode.questionBank;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 想法：没有想法....
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
//        int i = longestValidParentheses("(()())())(");
//        int i = longestValidParentheses("(()()");
//        int i = longestValidParentheses("(");
//        int i = longestValidParentheses(")");
//        int i = longestValidParentheses(")()())");
        //这种情况还是不对啊，是不是还得搞个数记录连续的括号哇，看来是这样~
        int i = longestValidParentheses("()(()");

        System.out.println(i);
    }
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int leftLen = 0;
        int rightLen = 0;
        StringBuilder builder = new StringBuilder(s);
        while (builder.length() > 0) {
            if (builder.substring(0,1).equals("(")) {
                leftLen ++;
            }
            if (builder.substring(0,1).equals(")")) {
                rightLen ++;
            }
            //当左括号与右括号一一对应时，即括号关闭

            //左括号小于右括号..咦，加了上面那个条件这个好像不会出现啦
            if (leftLen < rightLen) {
                maxLen = maxLen>leftLen*2?maxLen:leftLen*2;
                leftLen = 0;
                rightLen = 0;
            }
            if (builder.length() == 1) {
                if (leftLen == rightLen) {
                    maxLen = maxLen>leftLen*2?maxLen:leftLen*2;
                }
                else {
                    int max = leftLen>rightLen?rightLen:leftLen;
                    maxLen = maxLen>max*2?maxLen:max*2;
                }
            }
            builder = builder.delete(0,1);
            System.out.println(builder);
        }
        return maxLen;
    }
}
