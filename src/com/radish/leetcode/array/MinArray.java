package com.radish.leetcode.array;

/**
 * @Description MinArray
 *
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * 这个题是简单，另一个题居然是困难？？？？不是一样的吗！神奇，明天看看吧~现在要准备睡觉了~
 *
 * @Author Radish
 * @Date 2020-07-22 22:31
 */
public class MinArray {
    public int minArray(int[] numbers) {
        //简单粗暴，直接遍历
        /*int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;*/
        //不过这没啥意思，普通数组直接这样遍历，这是排好序的旋转数组,只要这个数比它前面的数小它就是最小值，难道也要一个个遍历？还是二分？
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i-1]) {
                min = numbers[i];
                break;
            }
        }
        return min;

        //上面的方法看起来有点傻噢~感觉不太优雅，还是试试二分吧！话说二分是咋写来着？奥，不过前头俩还没有测试呢,咦上面那种居然效率很高！！！哈哈哈哈可以可以

    }

    public int minArray(int[] numbers, int left, int right) {
        //看看该二分的最右是否比最左小，是，则最小值在该区间，否则就不在
        return 0;
    }
}
