package com.radish.leetcode.strs;

import java.util.*;

/**
 * @Description PartitionLabels
 *
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * @Author Radish
 * @Date 2020-10-22 09:24
 */
public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
//        String s = "ababcbacadefegdehijhklij";
//        String s = "abc";
//        String s = "abca";
        String s = "";
        List<Integer> list = p.partitionLabels(s);
        System.out.println(list);
    }
    public List<Integer> partitionLabels(String S) {
        //就是有多少个没有字符交集的字符串
        //字符出现位置的线段没有交集
        HashMap<Character, Integer[]> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (S.indexOf(c) != -1) {
                int start = S.indexOf(c);
                int end = S.lastIndexOf(c);
                map.put(c,new Integer[]{start, end});
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            Integer[] ints = map.get(c);
            if (ints == null) continue;
            for (char c1 = 'a'; c1 <= 'z'; c1++) {
                if (c1 == c) continue;
                Integer[] ints1 = map.get(c1);
                if (ints1 != null) {
                    //没有交集，下一个
                    if (ints[0] > ints1[1] || ints[1] < ints1[0]) continue;
                    //如果被比较的这个范围与ints有交集，如果左边长，左范围增加，如果右边长，右范围增加，（如果被包含），移除
                    ints[0] = ints[0] < ints1[0] ? ints[0] : ints1[0];
                    ints[1] = ints[1] > ints1[1] ? ints[1] : ints1[1];
                    map.remove(c1);
                    map.put(c, ints);
                }
            }
        }

        //哎呀，咋给它按照顺序排列呢
        TreeSet<Integer[]> set = new TreeSet<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] == o2[0]) return 0;
                return o1[0] < o2[0] ? -1 : 1;
            }
        });

        for (char c = 'a'; c <= 'z'; c++) {
            Integer[] integers = map.get(c);
            if (integers != null) set.add(integers);
        }

        Iterator<Integer[]> iterator = set.iterator();
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Integer[] next = iterator.next();
            result.add(next[1] - next[0] + 1);
        }
        return result;
    }
}
