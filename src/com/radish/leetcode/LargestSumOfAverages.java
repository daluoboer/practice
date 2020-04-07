package com.example.leetcode;

import java.util.*;

/**
 * @Description
 *
 * 最大平均值和的分组
 * 我们将给定的数组 ReflectionTest 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
 *
 * 注意我们必须使用 ReflectionTest 数组中的每一个数进行分组，并且分数不一定需要是整数。
 *
 * 示例:
 * 输入:
 * ReflectionTest = [9,1,2,3,9]
 * K = 3
 * 输出: 20
 * 解释:
 * ReflectionTest 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 ReflectionTest 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 * 说明:
 *
 * 1 <= ReflectionTest.length <= 100.
 * 1 <= ReflectionTest[i] <= 10000.
 * 1 <= K <= ReflectionTest.length.
 * 答案误差在 10^-6 内被视为是正确的。
 *
 *
 * 最大的值单独为一个数组，这样平均值最大
 *
 * @Author Radish
 * @Date 2020/3/18
 */

public class LargestSumOfAverages {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            if (str.equals("")) continue;
            String[] strs = str.split(" ");
            int[] ints = new int[strs.length-1];
            for (int i = 0; i < strs.length - 1; i++) {
                ints[i] = Integer.valueOf(strs[i]);
            }
            int k = Integer.valueOf(strs[strs.length-1]);

            double sum = getSum(ints, k);
            System.out.println("最高分数为：" + sum);
        }
    }

    public static double getSum(int[] A,int k) {
        //哎呀呀！没有那么简单呐？还要用动态规划？啊！动态规划的题目还中等难度呐？哎呀呀呀呀


        //嗷！先将数组排序啊！哎呀呀刚才在想啥呢！
        //拍完序之后..从前往后取值不就行啦！哎呀呀呀！

        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (A[j] > A[j-1]) {
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
            }
        }

        double sum = 0;
        for (int i = 0; i < k-1; i++) {
            sum += A[i];
        }

        int length = A.length-k+1;
        double lastSum = 0;
        for (int i = k-1; i < A.length; i++) {
            lastSum += A[i];
        }

        sum += lastSum/length;

        return sum;

    }


    public static double getSumOfPriority(int[] A,int k) {
        //好像不能用set？因为可能有重复元素啊，但是用ArrayList吗？效率不高？哎呀，先实现再说
        //查找最大值并移除，咦那是不是用队列更合适喔！嘿嘿嘿，自动排序！
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);
            }
        });

        for (int i : A) {
            priorityQueue.add(i);
        }
        //peek()就是给你看看，poll就是给你了

        double sum = 0;
        //分为k个数组
//        int[][] ks = new int[k][];
        //先找最大的，逐一放在每个数组中，如果是最后一个数组，就把所有数字放进去
        for (int i = 0; i < k - 1; i++) {
            Integer poll = priorityQueue.poll();
//            ks[k] = new int[]{poll};
            sum += poll;
        }
        /*剩下的数字全放进最后一个数组里头*/
//        ks[k-1] = new int[priorityQueue.size()];
        double lastSum = 0;
        for (Integer i : priorityQueue) {
            lastSum += i;
        }

        sum += lastSum/priorityQueue.size();
        return sum;

    }

}
