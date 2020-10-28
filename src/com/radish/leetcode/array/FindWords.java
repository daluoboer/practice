package com.radish.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description FindWords
 *
 * 500. 键盘行
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 *
 *
 * American keyboard
 *
 *
 *
 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *
 *
 * 注意：
 *
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 *
 * @Author Radish
 * @Date 2020-10-27 16:12
 */
public class FindWords {
    public static void main(String[] args) {
        /*FindWords f = new FindWords();
        String[] strings = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words = f.findWords(strings);
        for (String s : words) {
            System.out.println(s);
        }*/
        StringBuffer hhh = new StringBuffer("hhh");
        StringBuffer hhh1 = new StringBuffer("hhh");
        System.out.println(hhh==hhh1);
        System.out.println(hhh.equals(hhh1));

        /*String s = "hhh";
        String s1 = "hhh";
        String s3 = new String("hhh");
        System.out.println(s.equals(s1));
        System.out.println(s.equals(s3));*/
    }
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);
        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);
        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            word = word.toLowerCase();
            char c = word.charAt(0);
            int ii = map.get(c);
            boolean en = true;
            for (int j = 1; j < word.length(); j++) {
                char c1 = word.charAt(j);
                int jj = map.get(c1);
                if (ii != jj) {
                    en = false;
                    break;
                }
            }
            if (en) result.add(i);
        }
        String[] ss = new String[result.size()];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = words[result.get(i)];
        }
        return ss;
    }
}
