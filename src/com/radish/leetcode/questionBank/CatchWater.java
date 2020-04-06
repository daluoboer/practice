package com.radish.leetcode.questionBank;

import java.util.Arrays;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class CatchWater {
    /**
     * 左边和右边围起来就是一个水槽，共有多少个水槽，能盛多少水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0,right = 0,water = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i]>0) {
                if (left == 0) {
                    left = i;
                } else{
                    right = i;
                }
                if (height[right]>=height[left]) {//以最短木板为准，当后面的比左边高时，就该收水啦
                    water += getWaterNumber(Arrays.copyOfRange(new int[right-left+1], left,right));
                    left = right;
                }
            }
        }
        return water;
    }

    /**
     * 计算一个水槽盛的水
     * @param flume
     * @return
     */
    public int getWaterNumber(int[] flume) {
        int water = 0;
        if (flume.length>2) {
            for (int i = 0; i < flume.length; i++) {

            }
        }
        return water;
    }
}
