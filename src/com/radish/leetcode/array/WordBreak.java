package com.radish.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description WordBreak
 *
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * @Author Radish
 * @Date 2020-11-01 10:21
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        String s = "leetcode";
        List<String> list = Arrays.asList("leet", "code");
        /*String s = "applepenapple";
        List<String> list = Arrays.asList("apple", "pen");*/
        /*String s = "catsandog";
        List<String> list = Arrays.asList("cats", "dog", "sand", "and", "cat");*/
        boolean b = w.wordBreak(s, list);
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreakM(String s, List<String> wordDict) {
        // 可以用回溯，拆分出单词之后，查看剩下的字符串是否仍能有效查询
        Set<String> set = new HashSet<>(wordDict);
        if (s.length() == 0) return true;
        for (int i = 0; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (set.contains(substring)) {
                boolean b = wordBreakM(s.substring(i), wordDict);
                if (b) return b;
            }
        }
        return false;
    }
}
