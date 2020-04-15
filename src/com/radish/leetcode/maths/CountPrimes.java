package com.radish.leetcode.maths;

/**
 * @description CountPrimes
 *
 *   计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @Author Radish
 * @Date 2020/4/918:26
 */

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(1500000));
    }

    public static int countPrimes(int n) {
        //怎样判断一个数是否是质数：只有1和它本身俩约数
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime2(i)) {
                num++;
                continue;
            }
        }
        return num;
    }


    //这样好快哦！但是..这个还是超出时间限制了耶
    public static boolean isPrime2(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }


    //下面这种方法简单粗暴，但是复杂度高，上面再来优化一哈~
    public static boolean isPrime(int n) {
        for (int i = 2; i < n/2+1; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
