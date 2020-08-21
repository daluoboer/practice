package com.radish.leetcode.strs;

import java.util.HashMap;

/**
 * @Description FirstUniqChar
 *
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * @Author Radish
 * @Date 2020-08-20 20:43
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        int z = firstUniqChar2("z");
        System.out.println(z);
    }
    //哇哇哇，都咋想的，咋这么厉害呢！
    public static int firstUniqChar2(String s) {
        int ans = -1;
        for (char u = 'a'; u <= 'z'; u++) {
            int i = s.indexOf(u);
            int i1 = s.lastIndexOf(u);
            if (i == i1 && i1 != -1) {
                if (ans == -1 || ans > i) {
                    ans = i;
                }
            }
        }
        return ans;
    }
    //卧槽！原来题目最后一句话可以默认全都是小写字母还是有深意的！
    public int firstUniqChar1(String s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (res[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
        //
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        //先存起来
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                map.put(c,1);
            } else {
                map.put(c,count+1);
            }
        }
        //再查
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.get(c);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
