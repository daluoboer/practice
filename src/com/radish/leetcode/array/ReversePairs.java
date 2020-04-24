package com.radish.leetcode.array;

import com.radish.utils.MyUtils;

import java.util.Random;
import java.util.Scanner;

/**
 * @description ReversePairs
 *
 * 面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 *
 * en???这，不挨着的也算啊，那每一个数都要往后遍历所有的数啊
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * @Author Radish
 * @Date 2020-04-24 14:01:38
 */

public class ReversePairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        while (in.hasNext()) {
            int num = in.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = random.nextInt(num*10);
            }
            int i = reversePairs(arr);
            System.out.print("数组：");
            MyUtils.print(arr);
            System.out.print("共有 " + i + "逆序对");
        }
    }

    //e....这样超出时间限制了耶，怎么能更快呢
    public static int reversePairs(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) total++;
            }
        }
        return total;
    }

    //en...接下来就用归并排序查找逆序对？又犯懒了......不开心了...
}
