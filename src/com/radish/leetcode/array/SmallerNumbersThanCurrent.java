package com.radish.leetcode.array;

import com.radish.utils.MyUtils;

/**
 * @Description SmallerNumbersThanCurrent
 *
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 * @Author Radish
 * @Date 2020-10-26 08:26
 */
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        SmallerNumbersThanCurrent s = new SmallerNumbersThanCurrent();
//        int[] ints = new int[]{};
        int[] ints = new int[]{8,1,2,2,3};
//        int[] ints = new int[]{6,5,4,8};
//        int[] ints = new int[]{7,7,7,7};
        int[] ints1 = s.smallerNumbersThanCurrent(ints);
        MyUtils.print(ints1);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 嗷~每次比较的时候记录一下值就行了嘛
        //数字范围是0-100，所以可以记录每个数字出现的次数，然后就可以计算出每个数有多少小于它的数
        int[] numArr = new int[101];
        for (int i = 0; i < nums.length; i++) {
            numArr[nums[i]]++;
        }
        int[] numss = new int[101];
        numss[0] = 0;
        for (int i = 1; i <= 100; i++) {
            numss[i] = numss[i-1] + numArr[i-1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = numss[nums[i]];
        }
        return res;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        // 嗷~每次比较的时候记录一下值就行了嘛
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) continue;
                if (nums[i] < nums[j]) res[j]++;
                else res[i]++;
            }
        }
        return res;
    }

    public int[] smallerNumbersThanCurrent1(int[] nums) {
        // 如果直接把每一个数字循环一遍那就n^2了啊，而且每个数字都要跟别的每一个数字比较一次，不能比较一次就记录下来吗？查看一个数字比几个数字小？先暴力吧，想不到怎么能简单一点
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cur = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) cur++;
            }
            result[i] = cur;
        }
        return result;
    }
}
