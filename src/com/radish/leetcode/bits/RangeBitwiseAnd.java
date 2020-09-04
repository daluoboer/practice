package com.radish.leetcode.bits;

/**
 * @Description RangeBitwiseAnd
 *
 * 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1:
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 *
 * @Author Radish
 * @Date 2020-08-23 20:12
 */
public class RangeBitwiseAnd {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int i = rangeBitwiseAnd2(2,100);
        System.out.println(i);
    }

    /**
     * 这种方法叫啥 Brian Kernighan 算法，它用于清除二进制串中最右边的 1。
     * Brian Kernighan 算法的关键在于我们每次对 \textit{number}number 和 \textit{number}-1number−1 之间进行按位与运算后，\textit{number}number 中最右边的 11会被抹去变成 00。
     * 基于上述技巧，我们可以用它来计算两个二进制字符串的公共前缀。
     *
     * 其思想是，对于给定的范围 [m,n][m,n]（m<nm<n），我们可以对数字 n 迭代地应用上述技巧，清除最右边的 1，直到它小于或等于 m，此时非公共前缀部分的 1 均被消去。因此最后我们返回 n 即可。
     *
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }

    /**
     * 为啥可以这样写~你把二进制数字写出来就知道了~只需要取到这些数字的公共前缀即可，也就是只要取到最小和最大数字的公共前缀
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd1(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }
    /**
     * 超出时间限制了哎
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m, int n) {
        int t = m;
        for (int i = m + 1; i <= n; i++) {
            if (i != Integer.MAX_VALUE) {
                t &= i;
            }
        }
        return t;
    }
}
