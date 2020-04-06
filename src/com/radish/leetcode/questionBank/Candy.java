package com.radish.leetcode.questionBank;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Candy {
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] candys = new int[ratings.length];
        int candyStydents = 0;
        /*第一轮*/
        for (int i = 0; i < ratings.length; i++) {
            boolean flag1 = true;
            boolean flag2 = true;
            if (i > 0) {
                if (ratings[i] > ratings[i - 1]) {
                    flag1 = false;
                }
            }
            if (i < ratings.length - 1) {
                if (ratings[i] > ratings[i + 1]) {
                    flag2 = false;
                }
            }
            if (flag1&&flag2) {
                candys[i] = 1;
                candyStydents++;
            }
        }
        while (candyStydents<ratings.length) {
            candyStydents+=getCandys(ratings,candys);
        }

        int sumCandys = 0;
        for (int i : candys) {
            sumCandys += i;
        }

        System.out.println("至少需要 " + sumCandys + " 颗糖果");

        return sumCandys;
    }

    /**
     * 每人发几颗糖果
     * 1、先发一颗糖果的：如果该学生评分p,左右都 >=p
     *
     * @param ratings
     * @param candys
     * @return
     */
    public static int getCandys(int[] ratings, int[] candys) {
        int candyStydents = 0;
        /*第n轮(先发评分低的)*/
        for (int i = 0; i < ratings.length; i++) {
            if (candys[i] > 0) continue;
            int candyNumber = 1;
            if (i > 0) {
                if (candys[i - 1] == 0 && ratings[i] > ratings[i - 1]) continue;

                if (ratings[i] > ratings[i - 1]) {
                    candyNumber = candys[i - 1] + 1;
                }
            }
            if (i < ratings.length - 1) {
                if (candys[i + 1] == 0 && ratings[i] > ratings[i + 1]) continue;

                if (ratings[i] > ratings[i + 1]) {
                    candyNumber = candys[i + 1] + 1 > candyNumber ? candys[i + 1] + 1 : candyNumber;
                }
            }
            if (candyNumber > 1) {
                candys[i] = candyNumber;
                candyStydents++;
            }
        }
        return candyStydents;
    }

    public static void main(String[] args) {
        candy(new int[]{1, 0, 2});
    }
}
