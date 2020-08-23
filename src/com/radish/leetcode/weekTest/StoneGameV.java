package com.radish.leetcode.weekTest;

import com.radish.utils.MyUtils;

/**
 * @Description StoneGameV
 *
 * 5498. 石子游戏 V 显示英文描述
 * 通过的用户数198
 * 尝试过的用户数327
 * 用户总通过次数202
 * 用户总提交次数526
 * 题目难度Hard
 * 几块石子 排成一行 ，每块石子都有一个关联值，关联值为整数，由数组 stoneValue 给出。
 *
 * 游戏中的每一轮：Alice 会将这行石子分成两个 非空行（即，左侧行和右侧行）；Bob 负责计算每一行的值，即此行中所有石子的值的总和。Bob 会丢弃值最大的行，Alice 的得分为剩下那行的值（每轮累加）。如果两行的值相等，Bob 让 Alice 决定丢弃哪一行。下一轮从剩下的那一行开始。
 *
 * 只 剩下一块石子 时，游戏结束。Alice 的分数最初为 0 。
 *
 * 返回 Alice 能够获得的最大分数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：stoneValue = [6,2,3,4,5,5]
 * 输出：18
 * 解释：在第一轮中，Alice 将行划分为 [6，2，3]，[4，5，5] 。左行的值是 11 ，右行的值是 14 。Bob 丢弃了右行，Alice 的分数现在是 11 。
 * 在第二轮中，Alice 将行分成 [6]，[2，3] 。这一次 Bob 扔掉了左行，Alice 的分数变成了 16（11 + 5）。
 * 最后一轮 Alice 只能将行分成 [2]，[3] 。Bob 扔掉右行，Alice 的分数现在是 18（16 + 2）。游戏结束，因为这行只剩下一块石头了。
 * 示例 2：
 *
 * 输入：stoneValue = [7,7,7,7,7,7,7]
 * 输出：28
 * 示例 3：
 *
 * 输入：stoneValue = [4]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= stoneValue.length <= 500
 * 1 <= stoneValue[i] <= 10^6
 *
 * @Author Radish
 * @Date 2020-08-23 11:29
 */
public class StoneGameV {
    public static void main(String[] args) {
        int[] ints = {6, 2, 3, 4, 5, 5};
        int i = stoneGameV(ints);
        System.out.println(i);
        MyUtils.print(ints);
    }

    //这个也是人家做的
    int[] values;
    Integer[][] dp;
    int n;

    public int stoneGameV2(int[] stoneValue) {
        n = stoneValue.length;
        values = new int[n+1];
        dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            values[i+1] = values[i] + stoneValue[i];
        }
        return solve(stoneValue, 0, n-1);
    }

    int solve(int[] stoneValue, int s, int e) {
        if (s == e) return 0;
        if (dp[s][e] != null) return dp[s][e];

        int res = 0;
        for (int i = s; i < e; i++) {
            int left = values[i+1] - values[s];
            int right = values[e+1] - values[i+1];

            int tmp = 0;
            if (left > right) {
                tmp = right + solve(stoneValue, i + 1, e);
                res = Math.max(res, tmp);
            } else if (left < right) {
                tmp = left + solve(stoneValue, s, i);
                res = Math.max(res, tmp);
            } else {
                tmp = right + solve(stoneValue, i + 1, e);
                tmp = Math.max(tmp, left + solve(stoneValue, s, i));
                res = Math.max(res, tmp);
            }
        }
        dp[s][e] = res;
        return res;
    }

    /**
     * 这个是人家做的
     * @param stoneValue
     * @return
     */
    public static int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n];
        sum[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + stoneValue[i];
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int left = j;
                int right = j + i;

                int max = 0;
                for (int mid = left; mid < right; mid++) {
                    int sumleft = getsum(sum, left, mid);
                    int sumright = getsum(sum, mid + 1, right);

                    if (sumleft < sumright) {
                        max = Math.max(max, sumleft + dp[left][mid]);
                    } else if (sumleft > sumright) {
                        max = Math.max(max, sumright + dp[mid + 1][right]);
                    } else {
                        max = Math.max(max, sumleft + dp[left][mid]);
                        max = Math.max(max, sumright + dp[mid + 1][right]);
                    }
                }
                dp[left][right] = max;
            }
        }

        return dp[0][n - 1];
    }

    public static int getsum(int[] sum, int left, int right) {
        if (left == 0) {
            return sum[right];
        }
        return sum[right] - sum[left - 1];
    }

    /**
     * 你做的不对啊！
     * @param stoneValue
     * @return
     */
    public static int stoneGameVW(int[] stoneValue) {
        //每次分石子时，应该保持最小值最大，即接近平均数
        //但是如果接近平均数的只有一个石子，而非接近平均数的有很多石子可咋整？因为那一个石子一轮就完了，而剩下那一堆还可以继续玩儿
        //先看看咋平均分吧...排序？嗷！从最小值开始取，取到小于平均值即可。啊！你可太聪明了
        // 啊！如果得到了平均数那应该找个最小的数来凑一凑！
        //不对哎，这种想法，应该先找大的再说？找最接近平均值的，啊不会！
        quickSort(stoneValue, 0, stoneValue.length-1);
        //ok排好序了，接下来只要扔石子就行了
        int sum = 0;
        int l = 0, r = stoneValue.length - 1;
        while (r > l) {
            int notMySum = 0;
            int sum1 = getSum(stoneValue, l, r);
            for (; r > 0 && notMySum < ((double)sum1)/2; r--) {
                notMySum += stoneValue[r];
            }
            /*if (notMySum == ((double)sum1)/2) {
                notMySum += stoneValue[l++];
            }*/
            sum += sum1 - notMySum;
        }
        return sum;
    }

    public static int getSum(int[] nums, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        int curVal = nums[l];
        while (i < j) {
            //从后面找一个大于基准的数放到前头
            while (i < j && nums[j] >= curVal) {
                j--;
            }
            if (i >= j) continue;
            nums[i++] = nums[j];
            //从前面找一个小于基准的数放到后头
            while (i < j && nums[i] < curVal) {
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
