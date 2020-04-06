package com.radish.leetcode.questionBank;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"aaa","bb","c"};
        longestCommonPrefix(strs);
    }
    public static String longestCommonPrefix(String[] strs) {
        int shortI = getShortestLenI(strs);
        String prefix = strs[shortI];
        for (int i = 0; i<strs.length; i++) {
            if (prefix != strs[i]) {
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return "";
    }

    public static int getShortestLenI(String[] strs) {
        int len = 0;
        int curI = 0;
        for (int i = 0; i<strs.length; i++) {
            if (strs[i].length() > len) {
                len = strs[i].length();
                curI = i;
            }
        }
        return curI;
    }

    /**
     * 获取两个字符串的最长前缀
     * @param prefix 前缀（较短字符串）
     * @param str 对比的字符串（较长字符串）
     * @return
     */
    public static String getLongestCommonPrefix(String prefix, String str) {
        for (int i = 0; i<prefix.length(); i++) {
            if (!prefix.equals(str)) {
//                prefix.
            }
        }
        return null;
    }
}
