package com.radish.leetcode.tree;

import com.radish.utils.MyUtils;

import java.util.Scanner;

/**
 * @description NumTrees
 *
 * 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 *    e....啥是二叉搜索树？哦！左子树小于父节点，右子树大于父节点，有相等的数咋办呢？是不是二叉搜索树就不可能存在相等的数？因为搜索到一个结果后就结束了啊，如果按照某种算法来搜索的话，那后面的值就永远也不可能到达了啊
 *    不过这个题目也没有必要考虑相等的情况~背带裤的口袋里装了根头发...有点热，有一点点困，还有一点点两点点浮躁，总之只有一点点点点点点点点点点点点点点点想学习~至于有多小...大概是无穷小吧！
 *
 * @Author Radish
 * @Date 2020-07-15 13:51:56
 */

public class NumTrees {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int i = numTrees(n);
            System.out.printf("当n为%d时，共有%d种不同结构的二叉树",n,i);
        }

        /*Integer integer = null;
        long l = integer.longValue();
        System.out.println(l);*/
    }

    /**
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        if (n < 1) return 0;
        /*int[][] cache = new int[n][n];
        cache[0][0] = 1;
        int numTrees = numTrees(1, n, cache);*/

        int[] cache1 = new int[n];
        cache1[0] = 1;
        int numTrees1 = numTrees(1, n, cache1);

        MyUtils.print(cache1);
        return numTrees1;
    }

    /**
     * &emsp;&emsp;就是分成左子树和右子树然后迭代，不过直接迭代太慢了，会超时，咋缓存呢？
     * @param a
     * @param b
     * @return
     */
    public static int numTrees(int a, int b) {
        if (a > b) {
            return 1;
        }
        int nums = 0;
        for (int i = a; i <= b; i++) {
            int leftNums = numTrees(a, i-1);
            int rightNums = numTrees(i+1,b);
            nums += leftNums * rightNums;
        }
        return nums;
    }

    /**
     *
     * 其实现在用的方法浪费了一般空间吧？
     * 打印出了n=19时数组的使用情况，莫名有种美感？？？哈哈哈哈哈哈哈，对角线左下的内存就浪费了呀~先这样吧~懒得想了
     * @param a
     * @param b
     * @param cache
     * @return
     */
    public static int numTrees(int a, int b, int[][] cache) {
        if (a > b) {
            return 1;
        }
        if (cache[a-1][b-1] != 0) {
            return cache[a-1][b-1];
        }

        int nums = 0;
        for (int i = a; i <= b; i++) {
            int leftNums = 1;
            if (i > 1) {
                leftNums = cache[a-1][i-2] > 0 ? cache[a-1][i-2] : numTrees(a, i-1,cache);
            }
            int rightNums = 1;
            if (i < b) {
                rightNums = cache[i][b-1] > 0 ? cache[i][b-1] : numTrees(i+1,b,cache);
            }
            nums += leftNums * rightNums;
        }
        if (cache[a-1][b-1] == 0) {
            cache[a-1][b-1] = nums;
        }
        return nums;
    }


    /**
     * n = 19时：（咋这么神奇哈哈哈哈哈哈哈哈哈哈哈）n更大的时候还出现了负数！应该超过了int最大值了
     * 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190,
     * 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700,
     * 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790,
     * 0, 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670,
     * 0, 0, 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845,
     * 0, 0, 0, 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440,
     * 0, 0, 0, 0, 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900,
     * 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012,
     * 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 14, 42, 132, 429, 1430,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 14, 42, 132, 429,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 14, 42, 132,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 14, 42,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 14,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2,
     * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
     * 当n为19时，共有1767263190种不同结构的二叉树
     */



    public static int numTrees(int a, int b, int[] cache) {
        if (a > b) {
            return 1;
        }
        if (cache[b-a] != 0) {
            return cache[b-a];
        }
        int nums = 0;
        for (int i = a; i <= b; i++) {
            int leftNums = 1;
            if (i-1-a>=0 && i-1-a < cache.length) {
                if (cache[i-1-a] == 0) {
                    cache[i-1-a] = numTrees(a, i-1,cache);
                }
                leftNums = cache[i-1-a];
            }
            int rightNums = 1;
            if (b-i-1 >= 0 && b-i-1 < cache.length) {
                if (cache[b-i-1] == 0) {
                    cache[b-i-1] = numTrees(i+1,b,cache);
                }
                rightNums = cache[b-i-1];
            }

            nums += leftNums * rightNums;
        }

        cache[b-a] = nums;

        return nums;
    }
}
