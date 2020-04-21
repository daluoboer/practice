package com.radish.leetcode.array;

/**
 * @description NumberOfSubarrays
 *
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 * @Author Radish
 * @Date 2020-04-21 14:51:53
 */

public class NumberOfSubarrays {
    //有多少可以有的奇数数组
    //奇数数组可加偶数,前面可加的长度*后面可加的长度
    public int numberOfSubarrays(int[] nums, int k) {
        //总个数
        int totalNum = 0;
        //该子奇数数组最前面的偶数
        int beginEven = -1;
        //该奇数数组第一个有效奇数
        int beginOdd = -1;
        //该奇数数组最后一个有效奇数
        int endOdd = -1;
        //该奇数数组最后偶数位置
        int endEven = -1;

        int numOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0;  numOdd < k; j++) {
                //如果是奇数
                if (nums[i]%2==1) {
                    //判断是不是第一个奇数，或者该组的奇数够不够
                    if (beginOdd == -1) {
                        beginOdd = j;
                    }
                    numOdd++;
                    if (numOdd == k) {
                        //该组够了，计算一下，继续下一组
                        //啊不对哦~还要看看后头是不是偶数，后头是偶数的话要计算进去啊
                        int before = 0;
                        if (beginEven > -1) {
                            before = beginOdd - beginEven + 1;
                        }

                    }
                } else {//是偶数

                }
            }
        }
        return totalNum;
    }
}
