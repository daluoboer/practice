package com.radish.leetcode.weekTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description YuanFuDaoWeek212
 *
 * 5546. 按键持续时间最长的键 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * LeetCode 设计了一款新式键盘，正在测试其可用性。测试人员将会点击一系列键（总计 n 个），每次一个。
 *
 * 给你一个长度为 n 的字符串 keysPressed ，其中 keysPressed[i] 表示测试序列中第 i 个被按下的键。releaseTimes 是一个升序排列的列表，其中 releaseTimes[i] 表示松开第 i 个键的时间。字符串和数组的 下标都从 0 开始 。第 0 个键 keysPressed[0] 在时间为 0 时被按下，接下来每个键都 恰好 在前一个键松开时被按下。
 *
 * 测试人员想要找出按键 持续时间最长 的键。第 i 次按键的持续时间为 releaseTimes[i] - releaseTimes[i - 1] ，第 0 次按键的持续时间为 releaseTimes[0] 。
 *
 * 注意，测试期间，同一个键可以在不同时刻被多次按下，而每次的持续时间都可能不同。
 *
 * 请返回按键 持续时间最长 的键，如果有多个这样的键，则返回 按字母顺序排列最大 的那个键。
 *
 *
 *
 * 示例 1：
 *
 * 输入：releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * 输出："c"
 * 解释：按键顺序和持续时间如下：
 * 按下 'c' ，持续时间 9（时间 0 按下，时间 9 松开）
 * 按下 'b' ，持续时间 29 - 9 = 20（松开上一个键的时间 9 按下，时间 29 松开）
 * 按下 'c' ，持续时间 49 - 29 = 20（松开上一个键的时间 29 按下，时间 49 松开）
 * 按下 'd' ，持续时间 50 - 49 = 1（松开上一个键的时间 49 按下，时间 50 松开）
 * 按键持续时间最长的键是 'b' 和 'c'（第二次按下时），持续时间都是 20
 * 'c' 按字母顺序排列比 'b' 大，所以答案是 'c'
 * 示例 2：
 *
 * 输入：releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
 * 输出："a"
 * 解释：按键顺序和持续时间如下：
 * 按下 's' ，持续时间 12
 * 按下 'p' ，持续时间 23 - 12 = 11
 * 按下 'u' ，持续时间 36 - 23 = 13
 * 按下 'd' ，持续时间 46 - 36 = 10
 * 按下 'a' ，持续时间 62 - 46 = 16
 * 按键持续时间最长的键是 'a' ，持续时间 16
 *
 *
 * 提示：
 *
 * releaseTimes.length == n
 * keysPressed.length == n
 * 2 <= n <= 1000
 * 0 <= releaseTimes[i] <= 109
 * releaseTimes[i] < releaseTimes[i+1]
 * keysPressed 仅由小写英文字母组成
 *
 * @Author Radish
 * @Date 2020-10-25 10:33
 */
public class YuanFuDaoWeek212 {
    public static void main(String[] args) {
        YuanFuDaoWeek212 y = new YuanFuDaoWeek212();
        /*int[] ints = new int[]{9,29,49,50};
        String s = "cbcd";*/

        /*int[] ints = new int[]{12,23,36,46,62};
        String s = "spuda";
        char c = y.slowestKey(ints, s);
        System.out.println(c);*/

        /*int[] ints = new int[]{4,6,5,9,3,7};
        int[] ints1 = new int[]{0,0,2};
        int[] ints2 = new int[]{2,3,5};*/
        int[] ints = new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] ints1 = new int[]{0,1,6,4,8,7};
        int[] ints2 = new int[]{4,4,9,7,9,10};
        List<Boolean> booleans = y.checkArithmeticSubarrays(ints, ints1, ints2);
        System.out.println(booleans);
    }
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] maxTimes = new int[26];
        char[] chars = keysPressed.toCharArray();
        for (int i = 0; i < releaseTimes.length; i++) {
            char curC = chars[i];
            if (i == 0) maxTimes[curC-'a'] = releaseTimes[i];
            else {
                maxTimes[curC-'a'] = Math.max(maxTimes[curC-'a'], releaseTimes[i] - releaseTimes[i-1]);
            }
        }
        int r = 0;
        for (int i = 1; i < maxTimes.length; i++) {
            //最大值
            if (maxTimes[r] <= maxTimes[i]) {
                r = i;
            }
        }
        return (char)(r+'a');
    }

    /**
     * 5547. 等差子数组 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 i ， s[i+1] - s[i] == s[1] - s[0] 都成立。
     *
     * 例如，下面这些都是 等差数列 ：
     *
     * 1, 3, 5, 7, 9
     * 7, 7, 7, 7
     * 3, -1, -5, -9
     * 下面的数列 不是等差数列 ：
     *
     * 1, 1, 2, 5, 7
     * 给你一个由 n 个整数组成的数组 nums，和两个由 m 个整数组成的数组 l 和 r，后两个数组表示 m 组范围查询，其中第 i 个查询对应范围 [l[i], r[i]] 。所有数组的下标都是 从 0 开始 的。
     *
     * 返回 boolean 元素构成的答案列表 answer 。如果子数组 nums[l[i]], nums[l[i]+1], ... , nums[r[i]] 可以 重新排列 形成 等差数列 ，answer[i] 的值就是 true；否则answer[i] 的值就是 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
     * 输出：[true,false,true]
     * 解释：
     * 第 0 个查询，对应子数组 [4,6,5] 。可以重新排列为等差数列 [6,5,4] 。
     * 第 1 个查询，对应子数组 [4,6,5,9] 。无法重新排列形成等差数列。
     * 第 2 个查询，对应子数组 [5,9,3,7] 。可以重新排列为等差数列 [3,5,7,9] 。
     * 示例 2：
     *
     * 输入：nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
     * 输出：[false,true,false,false,true,true]
     *
     *
     * 提示：
     *
     * n == nums.length
     * m == l.length
     * m == r.length
     * 2 <= n <= 500
     * 1 <= m <= 500
     * 0 <= l[i] < r[i] < n
     * -105 <= nums[i] <= 105
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new LinkedList<>();
        for (int i = 0; i < l.length; i++) {
            result.add(checkArithmeticSubarray(nums, l[i], r[i]));
        }
        return result;
    }

    private boolean checkArithmeticSubarray(int[] nums, int l, int r) {
        //先重排
        int[] ints = new int[r - l + 1];
        for (int i = 0; i <= r - l; i++) {
            ints[i] = nums[i+l];
        }
        Arrays.sort(ints);
        // 再计算
        // 等差子数组nums[i] - nums[i-1] = nums[l+1] - nums[l]
        //啊！还要重新排列哎！
        for (int i = 2; i < ints.length; i++) {
            if (ints[i] - ints[i-1] != ints[1] - ints[0]) return false;
        }
        return true;
    }


    /**
     * 5548. 最小体力消耗路径 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
     *
     * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
     *
     * 请你返回从左上角走到右下角的最小 体力消耗值 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
     * 输出：2
     * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
     * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路劲差值最大值为 3 。
     * 示例 2：
     *
     *
     *
     * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
     * 输出：1
     * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
     * 示例 3：
     *
     *
     * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
     * 输出：0
     * 解释：上图所示路径不需要消耗任何体力。
     *
     *
     * 提示：
     *
     * rows == heights.length
     * columns == heights[i].length
     * 1 <= rows, columns <= 100
     * 1 <= heights[i][j] <= 106
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        //这个动态规划我好像会哎！
        //好像没有那么简单噢，应该需要回溯？
        //height[i][j] = height
        int[][] res = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {

            }
        }
        return 0;
    }


    /**
     * 5156. 矩阵转换后的秩 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Hard
     * 给你一个 m x n 的矩阵 matrix ，请你返回一个新的矩阵 answer ，其中 answer[row][col] 是 matrix[row][col] 的秩。
     *
     * 每个元素的 秩 是一个整数，表示这个元素相对于其他元素的大小关系，它按照如下规则计算：
     *
     * 如果一个元素是它所在行和列的最小值，那么它的 秩 为 1。
     * 如果两个元素 p 和 q 在 同一行 或者 同一列 ，那么：
     * 如果 p < q ，那么 rank(p) < rank(q)
     * 如果 p == q ，那么 rank(p) == rank(q)
     * 如果 p > q ，那么 rank(p) > rank(q)
     * 秩 需要越 小 越好。
     * 题目保证按照上面规则 answer 数组是唯一的。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,2],[3,4]]
     * 输出：[[1,2],[2,3]]
     * 解释：
     * matrix[0][0] 的秩为 1 ，因为它是所在行和列的最小整数。
     * matrix[0][1] 的秩为 2 ，因为 matrix[0][1] > matrix[0][0] 且 matrix[0][0] 的秩为 1 。
     * matrix[1][0] 的秩为 2 ，因为 matrix[1][0] > matrix[0][0] 且 matrix[0][0] 的秩为 1 。
     * matrix[1][1] 的秩为 3 ，因为 matrix[1][1] > matrix[0][1]， matrix[1][1] > matrix[1][0] 且 matrix[0][1] 和 matrix[1][0] 的秩都为 2 。
     * 示例 2：
     *
     *
     * 输入：matrix = [[7,7],[7,7]]
     * 输出：[[1,1],[1,1]]
     * 示例 3：
     *
     *
     * 输入：matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
     * 输出：[[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
     * 示例 4：
     *
     *
     * 输入：matrix = [[7,3,6],[1,4,5],[9,8,2]]
     * 输出：[[5,1,4],[1,2,3],[6,3,1]]
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 500
     * -109 <= matrix[row][col] <= 109
     * @param matrix
     * @return
     */
    public int[][] matrixRankTransform(int[][] matrix) {
        //先找到所有的1，然后再依次找到更大的，有点像扫雷哎
        int[][] result = new int[matrix.length][matrix[0].length];
        boolean[] iHas = new boolean[matrix.length+matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            //如果这一行已经有最小值，跳过该行
            if (iHas[i]) continue;
            for (int j = 0; j < matrix[0].length; j++) {
                //如果这一列已经有最小值，跳过该列
                if (iHas[j + matrix.length]) continue;
                boolean aMin = isMin(matrix, i, j);
                iHas[i] = aMin;
                iHas[j + matrix.length] = aMin;
                result[i][j] = 1;
                if (aMin) break;
            }
        }

        return null;


    }

    private boolean isMin(int[][] matrix, int a, int b) {
        int matrix1 = matrix[a][b];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix1 > matrix[i][b]) {
                return false;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix1 > matrix[a][j]) {
                return false;
            }
        }
        return true;
    }

}
