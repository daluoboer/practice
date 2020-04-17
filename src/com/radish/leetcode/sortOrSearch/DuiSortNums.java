package com.radish.leetcode.sortOrSearch;

import com.radish.utils.MyUtils;

/**
 * @description DuiSortNums
 *
 * 使用堆排序对无序数组排序
 *
 * @Author Radish
 * @Date 2020-04-17 19:05:45
 */

public class DuiSortNums {
    public static void main(String[] args) {
        int[] ints = {5, 1, 2, 3, 0, 12, 8, 7, 6};
//        int[] ints = {};
        sort(ints);
        MyUtils.print(ints);
    }
    //咦~居然不太难哎！主要是理解了就行
    public static void sort(int[] nums) {
        //把一组数从小到大排序，构建大顶堆
        //从最后一个非叶子节点开始，构建大顶堆
        int length = nums.length;

        while (length > 0) {
            for (int i = length/2 - 1; i >= 0; i--) {
                //看该值是否大于它的2i+1和2i+2的值
                int maxIndex;
                if (2*i+2 < length) {
                    maxIndex = nums[2*i+1] > nums[2*i+2] ? 2*i+1 : 2*i+2;
                } else {
                    maxIndex = 2*i+1;
                }
                if (nums[maxIndex] > nums[i]) {
                    //将大值给堆顶
                    int temp = nums[i];
                    nums[i] = nums[maxIndex];
                    nums[maxIndex] = temp;
                }
            }
            //此时第一个元素已经为最大值，将最大值与最后一个元素交换，完成一轮
            int temp = nums[length-1];
            nums[length-1] = nums[0];
            nums[0] = temp;
            length--;
        }

    }
}
