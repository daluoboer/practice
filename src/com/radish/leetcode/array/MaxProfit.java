package com.radish.leetcode.array;

/**
 * @Description MaxProfit
 *
 * 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 *
 * @Author Radish
 * @Date 2020-08-20 14:50
 */
public class MaxProfit {
    public static void main(String[] args) {
        int i = maxProfit1(new int[]{3,3});
        System.out.println(i);
    }
    public static int maxProfit(int[] prices) {
        //哎呀呀呀呀！不就是要找出后面较大的值减去前面较小的值的最大值嘛！
        //e...但是咋找呢？咋知道有几种情况呢？
        //画出折线图更好理解，就是找峰值和低值，即峰值-低值之和
        //也可以慢慢登峰，每次找到大一点的时候就加，直到峰值
        int buy = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]) {
                buy += prices[i+1] - prices[i];
            }
        }
        return buy;
    }

    public static int maxProfit1(int[] prices) {
        //哎呀呀呀呀！不就是要找出后面较大的值减去前面较小的值的最大值嘛！
        //e...但是咋找呢？咋知道有几种情况呢？
        //画出折线图更好理解，就是找峰值和低值，即峰值-低值之和
        //也可以慢慢登峰，每次找到大一点的时候就加，直到峰值
        int buy = 0, sell = 0;
        int i = 0;
        int amount = 0;
        while (i < prices.length - 1) {
            //低值
            while (i < prices.length - 1 && prices[i+1] <= prices[i]) {
                i++;
            }
            buy = prices[i];
            //峰值
            while (i < prices.length - 1 && prices[i+1] >= prices[i]) {
                i++;
            }
            sell = prices[i];
            amount += sell-buy;
        }
        return amount;
    }
}
