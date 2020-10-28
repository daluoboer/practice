package com.radish.leetcode.array;

import java.util.*;

/**
 * @Description UniqueOccurrences
 *
 * 1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @Author Radish
 * @Date 2020-10-28 09:26
 */
public class UniqueOccurrences {
    public static void main(String[] args) {
        UniqueOccurrences u = new UniqueOccurrences();
//        int[] ints = {1,2,2,1,1,3};
        int[] ints = {1,2};
//        int[] ints = {-3,0,1,-3,1,1,1,-3,10,0};
        boolean b = u.uniqueOccurrences(ints);
        System.out.println(b);
    }
    public boolean uniqueOccurrences1(int[] arr) {
        //先把次数记下来，然后看看有没有一样的
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer integer = map.get(i);
            if (integer == null) map.put(i,1);
            else {
                map.put(i,integer+1);
            }
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        if (set.size() < map.size()) return false;
        return true;
    }

    public boolean uniqueOccurrences(int[] arr) {
        // 嗷，可以先排序，然后再进行数量的统计
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                if (set.add(count)) {
                    count = 1;
                } else {
                    return false;
                }
            }
        }
        if (!set.add(count)) return false;
        return true;
    }

}
