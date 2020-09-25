package com.radish.leetcode.weekTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Week207nd
 * 第207场周赛
 * @Author Radish
 * @Date 2020-09-20 10:33
 */
public class Week207nd {

    public static void main(String[] args) {
        Week207nd w = new Week207nd();
//        String s = "   5   5   5";
//        String s = "     a     ";
//        String s = "  this   is  a sentence ";
//        String ss = w.reorderSpaces(s);
//        System.out.println("-----" + ss + "-----");
        /*int[][] ints = new int[][]{
                *//*{-1,-2,-3},
                {-2,-3,-3},
                {-3,-3,-2}*//*
                {1,-2,1},
                {1,-2,1},
                {3,-4,1}
        };
        int i = w.maxProductPath(ints);
        System.out.println(i);*/
    }

    /**
     * 5519. 重新排列单词间的空格 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Easy
     * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
     * <p>
     * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
     * <p>
     * 返回 重新排列空格后的字符串 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：text = "  this   is  a sentence "
     * 输出："this   is   a   sentence"
     * 解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
     * 示例 2：
     * <p>
     * 输入：text = " practice   makes   perfect"
     * 输出："practice   makes   perfect "
     * 解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
     * 示例 3：
     * <p>
     * 输入：text = "hello   world"
     * 输出："hello   world"
     * 示例 4：
     * <p>
     * 输入：text = "  walks  udp package   into  bar a"
     * 输出："walks  udp  package  into  bar  a "
     * 示例 5：
     * <p>
     * 输入：text = "a"
     * 输出："a"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= text.length <= 100
     * text 由小写英文字母和 ' ' 组成
     * text 中至少包含一个单词
     *
     * @param text
     * @return
     */
    public String reorderSpaces(String text) {
        //单词数、空格数、将空格插入单词中
        int length = text.length();
        String trim = text.trim();
        List<String> list = new ArrayList<>();
        int i = 0;
        int len1 = length - trim.length();
        int wordStart;
        while (i < trim.length()) {
            wordStart = i;
            while (i < trim.length() && trim.charAt(i) != ' ') {
                i++;
            }
            list.add(trim.substring(wordStart, i));
            while (i < trim.length() && trim.charAt(i) == ' ') {
                i++;
                len1++;
            }
        }

        int wordSize = list.size();

        int i1 = wordSize > 1 ? len1 / (wordSize - 1) : len1;
        int i2 = wordSize > 1 ? len1 % (wordSize - 1) : len1;

        StringBuilder sss = new StringBuilder();
        for (int j = 0; j < i1; j++) {
            sss.append(' ');
        }

        StringBuilder ssss = new StringBuilder();

        for (int j = 0; j < wordSize; j++) {
            ssss.append(list.get(j));
            if (j == wordSize - 1) {
                for (int m = 0; m < i2; m++) {
                    ssss.append(' ');
                }
            } else {
                ssss.append(sss);
            }
        }
        return ssss.toString();
    }

    /**
     * 5520. 拆分字符串使唯一子字符串的数目最大 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
     * <p>
     * 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
     * <p>
     * 注意：子字符串 是字符串中的一个连续字符序列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ababccc"
     * 输出：5
     * 解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
     * 示例 2：
     * <p>
     * 输入：s = "aba"
     * 输出：2
     * 解释：一种最大拆分方法为 ['a', 'ba'] 。
     * 示例 3：
     * <p>
     * 输入：s = "aa"
     * 输出：1
     * 解释：无法进一步拆分字符串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 16
     * <p>
     * s 仅包含小写英文字母
     *
     * @param s
     * @return
     */
    public int maxUniqueSplit(String s) {
        return 0;
    }

    /**
     * 5521. 矩阵的最大非负积 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
     * <p>
     * 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
     * <p>
     * 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。
     * <p>
     * 注意，取余是在得到最大积之后执行的。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [[-1,-2,-3],
     * [-2,-3,-3],
     * [-3,-3,-2]]
     * 输出：-1
     * 解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
     * 示例 2：
     * <p>
     * 输入：grid = [[1,-2,1],
     * [1,-2,1],
     * [3,-4,1]]
     * 输出：8
     * 解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)
     * 示例 3：
     * <p>
     * 输入：grid = [[1, 3],
     * [0,-4]]
     * 输出：0
     * 解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)
     * 示例 4：
     * <p>
     * 输入：grid = [[ 1, 4,4,0],
     * [-2, 0,0,1],
     * [ 1,-1,1,1]]
     * 输出：2
     * 解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= rows, cols <= 15
     * -4 <= grid[i][j] <= 4
     *
     * @param grid
     * @return
     */
    public int maxProductPath(int[][] grid) {
        return 0;
    }
    /*public int maxProductPath(int[][] grid) {
        //动态规划，得到路径的最大乘积
        List<Integer>[][] result = new List[grid.length][grid[0].length];
        int[] path = new int[grid.length + grid[0].length -1];
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = new ArrayList<>(Arrays.asList(grid[i][j]));
                } else if (i == 0) {
                    result[i][j] = new ArrayList<>(Arrays.asList(result[i][j - 1].get(0) * grid[i][j]));
                } else if (j == 0) {
                    result[i][j] = new ArrayList<>(Arrays.asList(result[i - 1][j].get(0) * grid[i][j]));
                } else {
                    //哎呀！这里不能每次都求最大和啊因为有可能有正负号呢，哎呀呀呀呀这可咋整？那就不能用动态规划了？得回溯？哎呀呀呀呀好麻烦呐！因为只要最后一个最大嘛！前面的大不大无所谓啦，但是最后一个要最大，跟符号也有关系，然后了，跟数字绝对值大小也有关系，昂...
//                    result[i][j] = Math.max(result[i][j - 1] * grid[i][j],result[i - 1][j] * grid[i][j]);
                    result[i][j] = new ArrayList<>();
                }
            }
        }

        f(grid,result,path,flag);
        int i = result[grid.length - 1][grid[0].length - 1];
        return i >= 0 ? i : -1;
    }*/

    /*public int f(int[][] grid, int[][] result, int[] path, boolean[][] flag) {
        //应该从最后一个往前推，最后一个值相当于树顶
        //嗯....要把可能的值都存起来吗？只能这样吧？存起来然后当成树去遍历

        *//*for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (i != 0 && j != 0) {

                    //哎呀！这里不能每次都求最大和啊因为有可能有正负号呢，哎呀呀呀呀这可咋整？那就不能用动态规划了？得回溯？哎呀呀呀呀好麻烦呐！因为只要最后一个最大嘛！前面的大不大无所谓啦，但是最后一个要最大，跟符号也有关系，然后了，跟数字绝对值大小也有关系，昂...
//                    result[i][j] = Math.max(result[i][j - 1] * grid[i][j],result[i - 1][j] * grid[i][j]);
                    result[i][j] = f(grid,result,path,flag);
                }
            }
        }*//*
    }*/

    /**
     * 5522. 连通两组点的最小成本 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Hard
     * 给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。
     * <p>
     * 任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接成本。如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至少与第一组中的一个点连接。
     * <p>
     * 返回连通两组点所需的最小成本。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：cost = [[15, 96], [36, 2]]
     * 输出：17
     * 解释：连通两组点的最佳方法是：
     * 1--A
     * 2--B
     * 总成本为 17 。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
     * 输出：4
     * 解释：连通两组点的最佳方法是：
     * 1--A
     * 2--B
     * 2--C
     * 3--A
     * 最小成本为 4 。
     * 请注意，虽然有多个点连接到第一组中的点 2 和第二组中的点 A ，但由于题目并不限制连接点的数目，所以只需要关心最低总成本。
     * 示例 3：
     * <p>
     * 输入：cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
     * 输出：10
     * <p>
     * <p>
     * 提示：
     * <p>
     * size1 == cost.length
     * size2 == cost[i].length
     * 1 <= size1, size2 <= 12
     * size1 >= size2
     * 0 <= cost[i][j] <= 100
     *
     * @param cost
     * @return
     */
    public int connectTwoGroups(List<List<Integer>> cost) {
        return 0;
    }
}
