package com.radish.leetcode.maths;

import java.util.*;

/**
 * @Description
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 复制
 * 0 3
 * 1 2
 * 3 4
 * @Author Radish
 * @Date 2020/3/12
 */

public class Indexes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*while (in.hasNext()) {
            HashMap<String,Integer> map = new HashMap<>();
            int n = in.nextInt();
            in.nextLine();
            for (int i = 0; i < n; i++) {
                String next = in.nextLine();
                String[] s = next.split(" ");
                if (map.get(s[0])!=null) {
                    map.put(s[0],map.get(s[0])+Integer.valueOf(s[1]));
                } else {
                    map.put(s[0],Integer.valueOf(s[1]));
                }
            }
            for (String s : map.keySet()) {
                System.out.println(s + " " + map.get(s));
            }
        }*/
        while (in.hasNext()) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int key = in.nextInt();
                int value = in.nextInt();
                if (map.get(key) != null) {
                    map.put(key,map.get(key)+value);
                } else {
                    map.put(key,value);
                }
            }
            ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
            Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });
            for (Map.Entry<Integer,Integer> entry : entries) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
