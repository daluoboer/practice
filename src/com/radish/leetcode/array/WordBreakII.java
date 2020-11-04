package com.radish.leetcode.array;

import java.util.*;

/**
 * @Description WordBreakII
 *
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 * @Author Radish
 * @Date 2020-11-01 09:24
 */
public class WordBreakII {
    public static void main(String[] args) {
        WordBreakII w = new WordBreakII();
//        System.out.println("abc".substring(0,1));
        /*String s = "catsanddog";
        List<String> list = Arrays.asList("cat","cats", "and","sand","dog");*/
        /*String s = "catsandog";
        List<String> list = Arrays.asList("cats", "dog", "sand", "and", "cat");*/
        String s = "pineapplepenapple";
        List<String> list = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> res = w.wordBreak(s, list);
        System.out.println(res);
    }

    //题解的写法
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer,List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s,s.length(),new HashSet<String>(wordDict),0,map);
        List<String> breakList = new LinkedList<>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    private List<List<String>> backtrack(String s, int length, HashSet<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length) {
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index,i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWorkBreaks = backtrack(s,length,wordSet,i,map);
                    for (List<String> nextWorkBreak : nextWorkBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<>(nextWorkBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    //e...这样先判断还是超时，看来后面回溯的过程也需要优化
    public List<String> wordBreak2(String s, List<String> wordDict) {
        //先动态规划获取是否能够构建，如果能构建，就将它返回，哎？不对哎，因为可能在不同的地方断句噢
        //比方说 dogsend --- dog send -- dogs end，那这咋整呢？怎么记录呢？可以在单词的起点记录它的有效终点，也可以在终点记录它的起点，昂，那然后咋算呢？
        //就是把每一位上后面或者前面可以组成的字符串存储起来
        //先判断能否构建
        boolean[] dp = new boolean[s.length()+1];
        Set<String> wordDictSet = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        List<String> res = new LinkedList<>();
        if (dp[s.length()] = false) return res;
        LinkedList<String> path = new LinkedList<>();
        dfs(s, 0, path, wordDict,res);
        return res;
    }

    public List<String> wordBreakM(String s, List<String> wordDict) {
        //这不是跟那个ip地址一样的吗~就是拆分，就不用重新排序嘛~可以用回溯
        List<String> res = new LinkedList<>();
        LinkedList<String> path = new LinkedList<>();
        dfs(s,0, path, wordDict,res);
        return res;
    }

    private void dfs(String s, int i, LinkedList<String> path, List<String> wordDict, List<String> res) {
        if (i == s.length()) {
            //已经到达字符串末尾了，添加元素
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < path.size(); j++) {
                buffer.append(path.get(j));
                if (j < path.size() - 1) {
                    buffer.append(" ");
                }
            }
            res.add(buffer.toString());
        }
        for (int j = 1;j <= s.length() - i; j++) {
            String cur = s.substring(i, i + j);
            for (String ss : wordDict) {
                if (ss.equals(cur)) {
                    path.addLast(cur);
                    //已经遍历过最后一位了
                    dfs(s,i+j,path, wordDict, res);
                    path.removeLast();
                }
            }
        }
    }
}
