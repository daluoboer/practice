package com.radish.leetcode.array;

import java.util.HashMap;

/**
 * @Description MajorityElement
 *
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @Author Radish
 * @Date 2020-08-31 09:12
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] ints = {1, 3, 1, 2, 3, 3, 2, 3, 3};
        int i = majorityElement(ints);
        System.out.println(i);
    }

    /**
     * 暴力法
     * 还可以排序，n/2位置的元素就是要取的值
     * 随即找，因为概率很大
     * 下面这俩还没有看
     * 分治
     * Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i,1);
            } else {
                map.put(i,count+1);
            }
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) > nums.length/2 ) return i;
        }
        return 0;
    }
}
