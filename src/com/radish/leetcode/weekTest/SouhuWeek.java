package com.radish.leetcode.weekTest;

import java.util.HashSet;

/**
 * @Description SouhuWeek
 *
 * e...还没有做出来呢想啥优化！都怪你加了个条件导致一直得不到正确的结果！哎呀呀呀呀呀
 * 没关系，好歹比昨天好一点啦！继续努力吧！！
 * @Author Radish
 * @Date 2020-09-13 10:31
 */
public class SouhuWeek {
    public static void main(String[] args) {
        SouhuWeek week = new SouhuWeek();
        /*int[][] ints;
//        ints = new int[][]{{1,0,0},{0,0,1},{1,0,0}};
//        ints = new int[][]{{0,0,0,1},{1,0,0,0},{0,1,1,0},{0,0,0,0}};
        ints = new int[][]{{0,0,0,0,0,},{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        int i = week.numSpecial(ints);
        System.out.println(i);*/
        int n;
        int[][] preferences;
        int[][] pairs;
        //预期：0
//        n = 2;
//        preferences = new int[][]{{1},{0}};
//        pairs = new int[][]{{1,0}};
        //预期：4
//        n = 4;
//        preferences = new int[][]{{1, 3, 2},{2, 3, 0},{1, 3, 0},{0, 2, 1}};
//        pairs = new int[][]{{1,3},{0,2}};

        //预期：2
//        preferences = new int[][]{{1, 2, 3},{3, 2, 0},{3,1,0},{1, 2, 0}};
//        pairs = new int[][]{{0,1},{2,3}};
//        预期：4
//        preferences = new int[][]{{1, 3, 2},{2, 3, 0},{1,3,0},{0,2,1}};
//        pairs = new int[][]{{3,1},{2,0}};
        n = 6;
        preferences = new int[][]{{1,4,3,2,5},{0,5,4,3,2},{3,0,1,5,4},{2,1,4,0,5},{2,1,0,3,5},{3,4,2,0,1}};
        pairs = new int[][]{{3,1},{2,0},{5,4}};
        int i = week.unhappyFriends(n, preferences, pairs);
        System.out.println(i);
    }
    /**
     * 5511. 二进制矩阵中的特殊位置 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Easy
     * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
     *
     * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
     *
     *
     *
     * 示例 1：
     *
     * 输入：mat = [[1,0,0],
     *             [0,0,1],
     *             [1,0,0]]
     * 输出：1
     * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
     * 示例 2：
     *
     * 输入：mat = [[1,0,0],
     *             [0,1,0],
     *             [0,0,1]]
     * 输出：3
     * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
     * 示例 3：
     *
     * 输入：mat = [[0,0,0,1],
     *             [1,0,0,0],
     *             [0,1,1,0],
     *             [0,0,0,0]]
     * 输出：2
     * 示例 4：
     *
     * 输入：mat = [[0,0,0,0,0],
     *             [1,0,0,0,0],
     *             [0,1,0,0,0],
     *             [0,0,1,0,0],
     *             [0,0,0,1,1]]
     * 输出：3
     *
     *
     * 提示：
     *
     * rows == mat.length
     * cols == mat[i].length
     * 1 <= rows, cols <= 100
     * mat[i][j] 是 0 或 1
     * @param mat
     * @return
     */
    public int numSpecial(int[][] mat) {
        int count = 0;
        //int[i][j] == 1 && int[i][0-length-1] == 0 && int[0-length][j] == 0
        //是否需要记录下符合条件的i j？
        //怎样降维？将第i行的1数和第j行的1数存储起来，以后再到这一行这一列就可以直接查询了啊
        int[] is = new int[mat.length];
        int[] js = new int[mat[0].length];
        boolean flag = false;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                //如果该列已经有，就没有必要继续查找？但是没有记录这一列有没有的数组哎，之前做过那个题是啥情况来着，想不起来了，就是出来的数组很神奇可以用简便的方法来记数据..在比赛哎！先做出来再说吧！
                if (mat[i][j] == 1) {
                    //查询第i行和第j列1个数
                    if (is[i] == 0) {
                        //查询该行的1数
                        for (int n = 0; n < mat[0].length; n++) {
                            if (mat[i][n] == 1) is[i]++;
                        }
                    }
                    if (is[i] != 1) continue;

                    if (js[j] == 0) {
                        for (int m = 0; m < mat.length; m++) {
                            if (mat[m][j] == 1) js[j]++;
                        }
                    }
                    if (js[j] != 1) continue;

                    count++;
                    //这一行这一列有了，那么这一行就没必要再查了
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 5512. 统计不开心的朋友 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
     *
     * 对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
     *
     * 所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。
     *
     * 但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
     *
     * x 与 u 的亲近程度胜过 x 与 y，且
     * u 与 x 的亲近程度胜过 u 与 v
     * 返回 不开心的朋友的数目 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
     * 输出：2
     * 解释：
     * 朋友 1 不开心，因为：
     * - 1 与 0 配对，但 1 与 3 的亲近程度比 1 与 0 高，且
     * - 3 与 1 的亲近程度比 3 与 2 高。
     * 朋友 3 不开心，因为：
     * - 3 与 2 配对，但 3 与 1 的亲近程度比 3 与 2 高，且
     * - 1 与 3 的亲近程度比 1 与 0 高。
     * 朋友 0 和 2 都是开心的。
     * 示例 2：
     *
     * 输入：n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
     * 输出：0
     * 解释：朋友 0 和 1 都开心。
     * 示例 3：
     *
     * 输入：n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
     * 输出：4
     *
     *
     * 提示：
     *
     * 2 <= n <= 500
     * n 是偶数
     * preferences.length == n
     * preferences[i].length == n - 1
     * 0 <= preferences[i][j] <= n - 1
     * preferences[i] 不包含 i
     * preferences[i] 中的所有值都是独一无二的
     * pairs.length == n/2
     * pairs[i].length == 2
     * xi != yi
     * 0 <= xi, yi <= n - 1
     * 每位朋友都 恰好 被包含在一对中
     * @param n
     * @param preferences
     * @param pairs
     * @return
     */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            for (int i1 = 0; i1 < 2; i1++) {
                //共有i对朋友
                //检查每一对是否开心
                int x = pairs[i][i1];
                int y = pairs[i][1-i1];
                int[] pX = preferences[x];
                int pXY = 0;
                for (int m = 0; m < pX.length; m++) {
                    if (pX[m] == y) {
                        pXY = m;
                        break;
                    }
                }
                for (int j = 0; j < pairs.length && j != i; j++) {
                    for (int j1 = 0; j1 < 2; j1++) {
                        int u = pairs[j][j1];
                        int v = pairs[j][1-j1];

                        if (set.contains(x) && set.contains(u)) continue;

                        int pXU = 0;
                        for (int m = 0; m < pX.length; m++) {
                            if (pX[m] == u) {
                                pXU = m;
                                break;
                            }
                        }

                        //如果xy比xu亲近 下一个,数越小越亲近
//                        if (pXU > pXY) continue;

                        int[] pU = preferences[u];
                        int pUV = 0;
                        int pUX = 0;
                        for (int m = 0; m < pU.length; m++) {
                            if (pU[m] == v) {
                                pUV = m;
                            }
                            if (pU[m] == x) {
                                pUX = m;
                            }
                        }
                        //如果ux比uv亲近，则他俩不开心（x，u）
                        if (pXU < pXY && pUX < pUV) {
                            set.add(x);
                            set.add(u);
                        }
                    }
                }
            }

        }
        return set.size();
    }

    /**
     * 5513. 连接所有点的最小费用 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
     *
     * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
     *
     * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
     * 输出：20
     * 解释：
     *
     * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
     * 注意到任意两个点之间只有唯一一条路径互相到达。
     * 示例 2：
     *
     * 输入：points = [[3,12],[-2,5],[-4,1]]
     * 输出：18
     * 示例 3：
     *
     * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
     * 输出：4
     * 示例 4：
     *
     * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
     * 输出：4000000
     * 示例 5：
     *
     * 输入：points = [[0,0]]
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= points.length <= 1000
     * -106 <= xi, yi <= 106
     * 所有点 (xi, yi) 两两不同。
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        return 0;
    }

    /**
     * 5514. 检查字符串是否可以通过排序子字符串得到另一个字符串 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Hard
     * 给你两个字符串 s 和 t ，请你通过若干次以下操作将字符串 s 转化成字符串 t ：
     *
     * 选择 s 中一个 非空 子字符串并将它包含的字符就地 升序 排序。
     * 比方说，对下划线所示的子字符串进行操作可以由 "14234" 得到 "12344" 。
     *
     * 如果可以将字符串 s 变成 t ，返回 true 。否则，返回 false 。
     *
     * 一个 子字符串 定义为一个字符串中连续的若干字符。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "84532", t = "34852"
     * 输出：true
     * 解释：你可以按以下操作将 s 转变为 t ：
     * "84532" （从下标 2 到下标 3）-> "84352"
     * "84352" （从下标 0 到下标 2） -> "34852"
     * 示例 2：
     *
     * 输入：s = "34521", t = "23415"
     * 输出：true
     * 解释：你可以按以下操作将 s 转变为 t ：
     * "34521" -> "23451"
     * "23451" -> "23415"
     * 示例 3：
     *
     * 输入：s = "12345", t = "12435"
     * 输出：false
     * 示例 4：
     *
     * 输入：s = "1", t = "2"
     * 输出：false
     *
     *
     * 提示：
     *
     * s.length == t.length
     * 1 <= s.length <= 105
     * s 和 t 都只包含数字字符，即 '0' 到 '9' 。
     * @param s
     * @param t
     * @return
     */
    public boolean isTransformable(String s, String t) {
        return false;
    }
}
