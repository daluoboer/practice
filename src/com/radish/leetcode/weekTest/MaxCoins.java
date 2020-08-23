package com.radish.leetcode.weekTest;

import com.radish.utils.MyUtils;

/**
 * @Description MaxCoins
 *
 * 5496. 你可以获得的最大硬币数目 显示英文描述
 * 通过的用户数566
 * 尝试过的用户数590
 * 用户总通过次数569
 * 用户总提交次数617
 * 题目难度Medium
 * 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
 *
 * 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
 * Alice 将会取走硬币数量最多的那一堆。
 * 你将会取走硬币数量第二多的那一堆。
 * Bob 将会取走最后一堆。
 * 重复这个过程，直到没有更多硬币。
 * 给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
 *
 * 返回你可以获得的最大硬币数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：piles = [2,4,1,2,7,8]
 * 输出：9
 * 解释：选出 (2, 7, 8) ，Alice 取走 8 枚硬币的那堆，你取走 7 枚硬币的那堆，Bob 取走最后一堆。
 * 选出 (1, 2, 4) , Alice 取走 4 枚硬币的那堆，你取走 2 枚硬币的那堆，Bob 取走最后一堆。
 * 你可以获得的最大硬币数目：7 + 2 = 9.
 * 考虑另外一种情况，如果选出的是 (1, 2, 8) 和 (2, 4, 7) ，你就只能得到 2 + 4 = 6 枚硬币，这不是最优解。
 * 示例 2：
 *
 * 输入：piles = [2,4,5]
 * 输出：4
 * 示例 3：
 *
 * 输入：piles = [9,8,7,6,5,1,2,3,4]
 * 输出：18
 *
 *
 * 提示：
 *
 * 3 <= piles.length <= 10^5
 * piles.length % 3 == 0
 * 1 <= piles[i] <= 10^4
 *
 * @Author Radish
 * @Date 2020-08-23 10:47
 */
public class MaxCoins {
    public static void main(String[] args) {
        int[] ints = {2,4,1,2,7,8};
        int i = maxCoins(ints);
        MyUtils.print(ints);
        System.out.println(i);
    }
    public static int maxCoins(int[] piles) {
        //你的硬币最多，那么肯定是第三个人硬币最少咯，那就是3n中第三个人只能得到2n+1~3n这堆硬币，1-2n这堆，你取index为偶数的这堆儿
        quickSort(piles,0,piles.length-1);
        int length = piles.length/3;
        int amount = 0;
        for (int i = 1; i < length * 2; i = i + 2) {
            amount += piles[i];
        }
        return amount;
    }
    //快排是咋个排勒，算了先冒泡b...e..选择排序吧！啊！超出时间限制了妈蛋！非要老子搞快排呀！
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int maxI = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[maxI]) {
                    maxI = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[maxI];
            nums[maxI] = temp;
        }
    }
    //okok 挖坑填数
    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        int curVal = nums[l];
        while (i < j) {
            //从后面找一个大于基准的数放到前头
            while (i < j && nums[j] <= curVal) {
                j--;
            }
            if (i >= j) continue;
            nums[i++] = nums[j];
            //从前面找一个小于基准的数放到后头
            while (i < j && nums[i] > curVal) {
                i++;
            }
            if (i >= j) continue;
            nums[j--] = nums[i];
        }
        nums[i] = curVal;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }
}
