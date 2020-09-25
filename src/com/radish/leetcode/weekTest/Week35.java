package com.radish.leetcode.weekTest;

import java.util.*;

/**
 * @Description Week35
 * @Author Radish
 * @Date 2020-09-19 22:31
 */
public class Week35 {
    public static void main(String[] args) {
        Week35 w = new Week35();
        /*int i = w.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3,});
        System.out.println(i);*/
//        int i = w.maxSumRangeQuery(new int[]{1, 2, 3, 4, 5}, new int[][]{{1, 3}, {0, 1}});
//        int i = w.maxSumRangeQuery(new int[]{1, 2, 3, 4, 5, 6}, new int[][]{{0, 1}});
        int i = w.maxSumRangeQuery(new int[]{1,2,3,4,5,2147483647/6}, new int[][]{{0, 2}, {1,3}, {1,1}});
        System.out.println(i);
    }
    /**
     * 5503. 所有奇数长度子数组的和 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Easy
     * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
     * <p>
     * 子数组 定义为原数组中的一个连续子序列。
     * <p>
     * 请你返回 arr 中 所有奇数长度子数组的和 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,4,2,5,3]
     * 输出：58
     * 解释：所有奇数长度子数组和它们的和为：
     * [1] = 1
     * [4] = 4
     * [2] = 2
     * [5] = 5
     * [3] = 3
     * [1,4,2] = 7
     * [4,2,5] = 11
     * [2,5,3] = 10
     * [1,4,2,5,3] = 15
     * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
     * 示例 2：
     * <p>
     * 输入：arr = [1,2]
     * 输出：3
     * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
     * 示例 3：
     * <p>
     * 输入：arr = [10,11,12]
     * 输出：66
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 100
     * 1 <= arr[i] <= 1000
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        //但是应该可以计算出每一个数被加几次，然后进行优化~先这样
        int sum = 0;
        for (int i = 1; i <= arr.length; i = i+2) {
            //数组长度为i？
            for (int j = 0; j < arr.length - i + 1; j++) {
                //从下标为j开始的数组
                for (int m = j; m < j + i; m++) {
                    sum += arr[m];
                }
            }
        }
        return sum;
    }

    /**
     * 5505. 所有排列中的最大和 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。第 i 个查询求 nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 endi 数组索引都是 从 0 开始 的。
     * <p>
     * 你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。
     * <p>
     * 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
     * 输出：19
     * 解释：一个可行的 nums 排列为 [2,1,3,4,5]，并有如下结果：
     * requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
     * requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
     * 总和为：8 + 3 = 11。
     * 一个总和更大的排列为 [3,5,4,2,1]，并有如下结果：
     * requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
     * requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
     * 总和为： 11 + 8 = 19，这个方案是所有排列中查询之和最大的结果。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,4,5,6], requests = [[0,1]]
     * 输出：11
     * 解释：一个总和最大的排列为 [6,5,4,3,2,1] ，查询和为 [11]。
     * 示例 3：
     * <p>
     * 输入：nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
     * 输出：47
     * 解释：一个和最大的排列为 [4,10,5,3,2,1] ，查询结果分别为 [19,18,10]。
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 105
     * 0 <= nums[i] <= 105
     * 1 <= requests.length <= 105
     * requests[i].length == 2
     * 0 <= starti <= endi < n
     *
     * @param nums
     * @param requests
     * @return
     */
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        //为啥不行勒？一定是打开方式不对！
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()) return -1;
                else if (o1.getValue() < o2.getValue()) return 1;
                return 0;
            }
        };
        //就是要查看要查询的下标为哪个，然后这个下标对应的查询有几个数字，将查询最多次的放最大的数字即可
//        Map<Integer,Integer> map = new TreeMap<Integer, Integer>((SortedMap<Integer, Integer>) comparator);

        Map<Integer,Integer> map = new HashMap<>();
        int start,end;
        for (int[] req : requests) {
            start = req[0];
            end = req[1];
            for (int i = start; i <= end; i++) {
                Integer v = map.get(i);
                if (v == null) map.put(i,1);
                else map.put(i,v+1);
            }
        }
        Arrays.sort(nums);
//        System.out.println("map: " + map);
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries,comparator);
        //咋根据value把key排序呢？
//        System.out.println("list: " + entries);

//        MyUtils.print(nums);
        //entries 第一个最大从nums中取值即可
        //数太大，超了咋办？那每次都算除1_000_0000 + 7的余数？啥时机算呢？这是个问题...
        //哎呀哭泣，多通过了十来个测试用例，但是还是有错，嗷！！！也不能啊....不可能是除的多的事儿，因为如果数没有那么大除多少遍也没有用啊
        int sum = 0;
        for (int i = 0; i < entries.size(); i++) {
            Integer count = entries.get(i).getValue();
            //要么大的一乘就超了？在这儿再分一分？
            sum += count * (nums[nums.length - 1 - i]) % (10_0000_0000 + 7);
        }
//        System.out.println(Integer.MAX_VALUE);
//        sum = sum % (10_000_0000 + 7);

        return sum;
    }



    /**
     * 5504. 使数组和能被 P 整除 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
     * <p>
     * 请你返回你需要移除的最短子数组，如果无法满足题目要求，返回 -1 。
     * <p>
     * 子数组 定义为原数组中连续的一组元素。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,1,4,2], p = 6
     * 输出：1
     * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
     * 示例 2：
     * <p>
     * 输入：nums = [6,3,5,2], p = 9
     * 输出：2
     * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
     * 示例 3：
     * <p>
     * 输入：nums = [1,2,3], p = 3
     * 输出：0
     * 解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
     * 示例  4：
     * <p>
     * 输入：nums = [1,2,3], p = 7
     * 输出：-1
     * 解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
     * 示例 5：
     * <p>
     * 输入：nums = [1000000000,1000000000,1000000000], p = 3
     * 输出：0
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     * 1 <= p <= 109
     *
     * @param nums
     * @param p
     * @return
     */
    public int minSubarray(int[] nums, int p) {
        //最优解，那应该就是动态规划了吧！
        //移除一个？移除俩？
        boolean[] removed = new boolean[nums.length];
        int dfs = dfs(nums, p, removed);
        return dfs;
    }

    private int dfs(int[] nums, int p, boolean[] removed) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!removed[i]) {
                sum += nums[i];
            }
        }
        int count = -1;
        if (p % sum == 0) {
            count = 0;
            //计算个数
            for (boolean b : removed) {
                if (b) count++;
            }
        }

        if (count == -1) {
            for (int i = 0; i < nums.length; i++) {
                if (!removed[i]) {
                    removed[i] = true;
                    int dfs = dfs(nums, p, removed);
                    if (dfs > 0) return dfs;
                    removed[i] = false;
                }
            }
        }
        return count;
    }

    /**
     * 5506. 奇怪的打印机 II 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Hard
     * 给你一个奇怪的打印机，它有如下两个特殊的打印规则：
     * <p>
     * 每一次操作时，打印机会用同一种颜色打印一个矩形的形状，每次打印会覆盖矩形对应格子里原本的颜色。
     * 一旦矩形根据上面的规则使用了一种颜色，那么 相同的颜色不能再被使用 。
     * 给你一个初始没有颜色的 m x n 的矩形 targetGrid ，其中 targetGrid[row][col] 是位置 (row, col) 的颜色。
     * <p>
     * 如果你能按照上述规则打印出矩形 targetGrid ，请你返回 true ，否则返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：targetGrid = [[1,1,1,1],[1,2,2,1],[1,2,2,1],[1,1,1,1]]
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：targetGrid = [[1,1,1,1],[1,1,3,3],[1,1,3,4],[5,5,1,4]]
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：targetGrid = [[1,2,1],[2,1,2],[1,2,1]]
     * 输出：false
     * 解释：没有办法得到 targetGrid ，因为每一轮操作使用的颜色互不相同。
     * 示例 4：
     * <p>
     * 输入：targetGrid = [[1,1,1],[3,1,3]]
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == targetGrid.length
     * n == targetGrid[i].length
     * 1 <= m, n <= 60
     * 1 <= targetGrid[row][col] <= 60
     *
     * @param targetGrid
     * @return
     */
    public boolean isPrintable(int[][] targetGrid) {
        return false;
    }
}
