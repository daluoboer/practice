package com.radish.leetcode.weekTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description Week213Coupang
 *

 *
 * @Author Radish
 * @Date 2020-11-01 10:32
 */
public class Week213Coupang {
    public static void main(String[] args) {
        Week213Coupang w = new Week213Coupang();
        /*int[] ints = {85};
        int[][] ints2 = new int[][]{{85}};*/
        /*int[] ints = {15,88};
        int[][] ints2 = new int[][]{{88},{15}};*/
        /*int[] ints = {49,18,16};
        int[][] ints2 = new int[][]{{16,18,49}};*/
        /*int[] ints = {91,4,64,78};
        int[][] ints2 = new int[][]{{78},{4,64},{91}};*/
        /*int[] ints = {1,3,5,7};
        int[][] ints2 = new int[][]{{2,4,6,8}};
        boolean b = w.canFormArray(ints,ints2);
        System.out.println(b);*/
        /*int i = w.countVowelStrings(33);
        System.out.println(i);*/
        /*int[] ints = {4,2,7,6,9,14,12};
        int i = w.furthestBuilding(ints, 5, 1);*/
        /*int[] ints = {4,12,2,7,3,18,20,3,19};
        int i = w.furthestBuilding(ints, 10, 2);*/
        /*int[] ints = {14,3,19,3};
        int i = w.furthestBuilding(ints, 17, 0);
        System.out.println(i);*/
        /*int[] ints = {2,3};
        String s = w.kthSmallestPath(ints, 1);*/
        int[] ints = {2,3};
        String s = w.kthSmallestPath(ints, 3);
        System.out.println(s);
    }
    /**
     * 5554. 能否连接形成数组 显示英文描述
     *  * 通过的用户数0
     *  * 尝试过的用户数0
     *  * 用户总通过次数0
     *  * 用户总提交次数0
     *  * 题目难度Easy
     *  * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
     *  *
     *  * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
     *  *
     *  *
     *  *
     *  * 示例 1：
     *  *
     *  * 输入：arr = [85], pieces = [[85]]
     *  * 输出：true
     *  * 示例 2：
     *  *
     *  * 输入：arr = [15,88], pieces = [[88],[15]]
     *  * 输出：true
     *  * 解释：依次连接 [15] 和 [88]
     *  * 示例 3：
     *  *
     *  * 输入：arr = [49,18,16], pieces = [[16,18,49]]
     *  * 输出：false
     *  * 解释：即便数字相符，也不能重新排列 pieces[0]
     *  * 示例 4：
     *  *
     *  * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
     *  * 输出：true
     *  * 解释：依次连接 [91]、[4,64] 和 [78]
     *  * 示例 5：
     *  *
     *  * 输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
     *  * 输出：false
     *  *
     *  *
     *  * 提示：
     *  *
     *  * 1 <= pieces.length <= arr.length <= 100
     *  * sum(pieces[i].length) == arr.length
     *  * 1 <= pieces[i].length <= arr.length
     *  * 1 <= arr[i], pieces[i][j] <= 100
     *  * arr 中的整数 互不相同
     *  * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
     * @param arr
     * @param pieces
     * @return
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        boolean[] eq = new boolean[arr.length];
        for (int[] ints : pieces) {
            int first = ints[0];
            //找到first在arr中出现的位置
            int index = findIndex(first, arr);
            if (index == -1) return false;
            int ii = index;
            while (ii < arr.length && ii-index < ints.length) {
                if (arr[ii] != ints[ii-index]) {
                    return false;
                } else {
                    eq[ii++] = true;
                }
            }
            if (ii - index < ints.length - 1) return false;
        }
        for (boolean b : eq) {
            if (!b) return false;
        }
        return true;
    }

    public int findIndex(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) return i;
        }
        return -1;
    }

    /**
     * 5555. 统计字典序元音字符串的数目 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
     *
     * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 1
     * 输出：5
     * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
     * 示例 2：
     *
     * 输入：n = 2
     * 输出：15
     * 解释：仅由元音组成的 15 个字典序字符串为
     * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
     * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
     * 示例 3：
     *
     * 输入：n = 33
     * 输出：66045
     *
     *
     * 提示：
     *
     * 1 <= n <= 50
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        //就是n个数，只能可重复非降序排列5个数
        //要么找规律直接计算出来，要么就回溯，规律嘛...
        //就是n位嘛，第一位是啥，下一位可以是啥，然后统计出总结果就ok啦
        return dfs(0, n);
    }

    private int dfs(int i, int n) {
        if (n == 0) return 0;
        if (n == 1) {
            return 5-i;
        }
        int res = 0;
        //可以有5中选择
        for (int j = i; j <= 5; j++) {
            res += dfs(j,n-1);
        }
        return res;
    }

    /**
     * 5556. 可以到达的最远建筑 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
     *
     * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
     *
     * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
     *
     * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
     * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
     * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
     *
     *
     * 示例 1：
     *
     *
     * 输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
     * 输出：4
     * 解释：从建筑物 0 出发，你可以按此方案完成旅程：
     * - 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
     * - 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
     * - 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
     * - 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
     * 无法越过建筑物 4 ，因为没有更多砖块或梯子。
     * 示例 2：
     *
     * 输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
     * 输出：7
     * 示例 3：
     *
     * 输入：heights = [14,3,19,3], bricks = 17, ladders = 0
     * 输出：3
     *
     *
     * 提示：
     *
     * 1 <= heights.length <= 105
     * 1 <= heights[i] <= 106
     * 0 <= bricks <= 109
     * 0 <= ladders <= heights.length
     * @param heights
     * @param bricks
     * @param ladders
     * @return
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int i = 0;
        for (; i < heights.length - 1; i++) {
            if (heights[i+1] <= heights[i]) continue;
            if (heights[i + 1] - heights[i] <= bricks) {
                bricks -= heights[i+1] - heights[i];
            } else if (ladders > 0){
                ladders--;
            } else break;
        }
        return i;
    }

    /**
     * 5600. 第 K 条最小指令 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Hard
     * Bob 站在单元格 (0, 0) ，想要前往目的地 destination ：(row, column) 。他只能向 右 或向 下 走。你可以为 Bob 提供导航 指令 来帮助他到达目的地 destination 。
     *
     * 指令 用字符串表示，其中每个字符：
     *
     * 'H' ，意味着水平向右移动
     * 'V' ，意味着竖直向下移动
     * 能够为 Bob 导航到目的地 destination 的指令可以有多种，例如，如果目的地 destination 是 (2, 3)，"HHHVV" 和 "HVHVH" 都是有效 指令 。
     *
     * 然而，Bob 很挑剔。因为他的幸运数字是 k，他想要遵循 按字典序排列后的第 k 条最小指令 的导航前往目的地 destination 。k  的编号 从 1 开始 。
     *
     * 给你一个整数数组 destination 和一个整数 k ，请你返回可以为 Bob 提供前往目的地 destination 导航的 按字典序排列后的第 k 条最小指令 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：destination = [2,3], k = 1
     * 输出："HHHVV"
     * 解释：能前往 (2, 3) 的所有导航指令 按字典序排列后 如下所示：
     * ["HHHVV", "HHVHV", "HHVVH", "HVHHV", "HVHVH", "HVVHH", "VHHHV", "VHHVH", "VHVHH", "VVHHH"].
     * 示例 2：
     *
     *
     *
     * 输入：destination = [2,3], k = 2
     * 输出："HHVHV"
     * 示例 3：
     *
     *
     *
     * 输入：destination = [2,3], k = 3
     * 输出："HHVVH"
     *
     *
     * 提示：
     *
     * destination.length == 2
     * 1 <= row, column <= 15
     * 1 <= k <= nCr(row + column, row)，其中 nCr(a, b) 表示组合数，即从 a 个物品中选 b 个物品的不同方案数。
     * @param destination
     * @param k
     * @return
     */
    public String kthSmallestPath1(int[] destination, int k) {
        //就是把HV排列后取第k条
        //des[0]个V，des[1]个H
        //总数即C((des[0]+des[1]),des[0])
        int n = destination[0] + destination[1];
        //那第几大的咋算呢，肯定是v都在后面的最小
        char[] res = new char[n];
//        for (int i = 0; i < destination[1]; i++) res[i] = 'H';
//        for (int i = destination[1]; i < n; i++) res[i] = 'V';
        //第k大，第c-k小，要大一位，也就是要把最后一个V往前挪一位
        //不对呀，这样挪中间会跳过一些啊，能不能转换一个思路
        //能转化成位运算不？0代表H，1代表V，但是这个怎么找第几大的数呢？嗯，还是得遍历嘛，算了那就想一下怎么遍历吧~
//        int[] ints = new int[getC(n,destination[0])];
        LinkedList<Integer> path = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();
        getCArr(n,destination[1], destination[0], res, nums);
        return new String(res);
    }

    public String kthSmallestPath(int[] destination, int k){
        //重新来吧...
        //昂就是先获取所有结果，然后进行排序，获取第k位的即可
        //嘤嘤嘤，超时了...哭泣，只通过了5个用例....5555555555
        //嗯...今天的题目也是超出时间限制了哎~看来是一个问题咯~
        char[] cs = new char[destination[0]+destination[1]];
        List<Integer> nums = new LinkedList<>();
        int n = destination[0] + destination[1];
        getCArr(n,destination[1],destination[0],cs,nums);
        Collections.sort(nums);
        Integer integer = nums.get(k - 1);
        String s = Integer.toBinaryString(integer);
        if (s.length() < n) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < n - s.length(); i++) {
                buffer.append("H");
            }
            s = buffer.toString() + s;
        }
        String h = s.replaceAll("0", "H");
        String v = h.replaceAll("1", "V");
        return v;
    }

    private void getCArr(int n, int m0, int m1, char[] path, List<Integer> nums) {
        if (m0 == 0 && m1 == 0) {
            nums.add(Integer.valueOf(new String(path),2));
        }
        //树
        if (m0 > 0) {
            path[n-m0-m1] = '0';
            getCArr(n,m0-1,m1,path,nums);
        }
        if (m1 > 0) {
            path[n-m0-m1] = '1';
            getCArr(n,m0,m1-1,path,nums);
        }
    }

    private int getC(int n, int m) {
        int res = 1;
        while (n > 0) {
            res*=n--;
        }
        while (m>0) {
            res/=m--;
        }
        return res;
    }
}
