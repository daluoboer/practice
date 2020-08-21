package com.radish.leetcode.array;

import com.radish.utils.MyUtils;

/**
 * @description SingleNumbers
 *
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * @Author Radish
 * @Date 2020-04-28 16:53:05
 */

public class SingleNumbers {
    public static void main(String[] args) {
        int[] ints = singleNumbers(new int[]{1, 1, 2, 2, 3, 4, 5, 3, 4, 7});
        MyUtils.print(ints);
    }

    public static int[] singleNumbers(int[] nums) {
        int sum = 0;
        int[] res = new int[2];
        for (int num : nums) {
            sum ^= num;
        }
        int lowbit = sum & (-sum);
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
        /*Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
            i++;
        }
        int[] result = new int[2];
        Iterator<Integer> iterator = set.iterator();
        for (int m = 0; m < 2 && iterator.hasNext(); m++) {
            result[m] = iterator.next();
        }
        return result;*/
    }
}
