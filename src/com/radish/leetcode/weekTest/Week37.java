package com.radish.leetcode.weekTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Week37
 * @Author Radish
 * @Date 2020-10-17 22:34
 */
public class Week37 {
    public static void main(String[] args) {
        Week37 w = new Week37();
//        int[] ints = new int[]{6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
       /* int[] ints = new int[]{6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4};
//        w.quickSort(ints, 0, ints.length - 1);
//        MyUtils.print(ints);
        double v = w.trimMean(ints);
        System.out.println(v);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list.get(0));*/
        Fancy f = new Fancy();
        /*f.append(10);
        f.addAll(5);
        System.out.println(f.list);
        f.multAll(3);
        f.append(5);*/
        f.append(100);
        for (int i = 0; i < 10; i++) {
            f.multAll(100);
        }
        System.out.println(f.getIndex(0));
        System.out.println(f.list);
    }
    /**
     * 5122. 删除某些元素后的数组均值 显示英文描述
     * 通过的用户数156
     * 尝试过的用户数172
     * 用户总通过次数156
     * 用户总提交次数173
     * 题目难度Easy
     * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
     *
     * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
     * 输出：2.00000
     * 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
     * 示例 2：
     *
     * 输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
     * 输出：4.00000
     * 示例 3：
     *
     * 输入：arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
     * 输出：4.77778
     * 示例 4：
     *
     * 输入：arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3]
     * 输出：5.27778
     * 示例 5：
     *
     * 输入：arr = [4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1]
     * 输出：5.29167
     *
     *
     * 提示：
     *
     * 20 <= arr.length <= 1000
     * arr.length 是 20 的 倍数
     * 0 <= arr[i] <= 105
     * @param arr
     * @return
     */
    public double trimMean(int[] arr) {
        //先排序，再删除，然后计算
        quickSort(arr,0,arr.length - 1);
        int num = arr.length / 20;
//        int[] newArr = new int[arr.length - num*2];
        int sum = 0;
        int newLen = arr.length - num*2;
        for (int i = 0; i < newLen; i++) {
//            newArr[i] = arr[i+num];
            sum+=arr[i+num];
        }
        return newLen == 0 ? 0 : sum/(double)newLen;
    }

    //快排：（挖坑填数）
    public static void quickSort(int[] nums, int l, int r) {
        int i = l, j = r;
        if (i>=j) return;
        //基准数
        int cur = nums[l];
        while (i < j) {
            //从后往前找一个小于基准的数
            while (i<j && nums[j] > cur) {
                j--;
            }
            if (i>=j) continue;
            nums[i++] = nums[j];
            //从前往后找一个大于基准的数
            while (i<j && nums[i] <= cur) {
                i++;
            }
            if (i>=j) continue;
            nums[j--] = nums[i];
        }
        nums[i] = cur;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }

    // 快排,e...不行哎，明天再看吧！
    //荷兰国旗，每一次都把等于基准数的值位置放好，而不是每次只把一个数的位置放好
    public void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int less = l - 1, more = r, curI = l, cur = arr[r];
        while (curI < more) {
            if (arr[curI] < cur) {
                swap(arr, ++less, curI++);
            }else if (arr[curI] == cur) {
                curI++;
            }else if (arr[curI] > cur) {
                swap(arr, --more, curI++);
            }
        }
        swap(arr, more - 1, r);
        sort(arr, l, curI - 1);
        sort(arr, more, r);
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 5528. 网络信号最好的坐标 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你一个数组 towers 和一个整数 radius ，数组中包含一些网络信号塔，其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的坐标是 (xi, yi) 且信号强度参数为 qi 。所有坐标都是在  X-Y 坐标系内的 整数 坐标。两个坐标之间的距离用 欧几里得距离 计算。
     *
     * 整数 radius 表示一个塔 能到达 的 最远距离 。如果一个坐标跟塔的距离在 radius 以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，所以 radius 以外的距离该塔是 不能到达的 。
     *
     * 如果第 i 个塔能到达 (x, y) ，那么该塔在此处的信号为 ⌊qi / (1 + d)⌋ ，其中 d 是塔跟此坐标的距离。一个坐标的 网络信号 是所有 能到达 该坐标的塔的信号强度之和。
     *
     * 请你返回 网络信号 最大的整数坐标点。如果有多个坐标网络信号一样大，请你返回字典序最小的一个坐标。
     *
     * 注意：
     *
     * 坐标 (x1, y1) 字典序比另一个坐标 (x2, y2) 小：要么 x1 < x2 ，要么 x1 == x2 且 y1 < y2 。
     * ⌊val⌋ 表示小于等于 val 的最大整数（向下取整函数）。
     *
     *
     * 示例 1：
     *
     *
     * 输入：towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
     * 输出：[2,1]
     * 解释：
     * 坐标 (2, 1) 信号强度之和为 13
     * - 塔 (2, 1) 强度参数为 7 ，在该点强度为 ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
     * - 塔 (1, 2) 强度参数为 5 ，在该点强度为 ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
     * - 塔 (3, 1) 强度参数为 9 ，在该点强度为 ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
     * 没有别的坐标有更大的信号强度。
     * 示例 2：
     *
     * 输入：towers = [[23,11,21]], radius = 9
     * 输出：[23,11]
     * 示例 3：
     *
     * 输入：towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
     * 输出：[1,2]
     * 示例 4：
     *
     * 输入：towers = [[2,1,9],[0,1,9]], radius = 2
     * 输出：[0,1]
     * 解释：坐标 (0, 1) 和坐标 (2, 1) 都是强度最大的位置，但是 (0, 1) 字典序更小。
     *
     *
     * 提示：
     *
     * 1 <= towers.length <= 50
     * towers[i].length == 3
     * 0 <= xi, yi, qi <= 50
     * 1 <= radius <= 50
     * @param towers
     * @param radius
     * @return
     */
    public int[] bestCoordinate(int[][] towers, int radius) {
        return null;
    }

    /**
     * 5527. 大小为 K 的不重叠线段的数目 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你一维空间的 n 个点，其中第 i 个点（编号从 0 到 n-1）位于 x = i 处，请你找到 恰好 k 个不重叠 线段且每个线段至少覆盖两个点的方案数。线段的两个端点必须都是 整数坐标 。这 k 个线段不需要全部覆盖全部 n 个点，且它们的端点 可以 重合。
     *
     * 请你返回 k 个不重叠线段的方案数。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：n = 4, k = 2
     * 输出：5
     * 解释：
     * 如图所示，两个线段分别用红色和蓝色标出。
     * 上图展示了 5 种不同的方案 {(0,2),(2,3)}，{(0,1),(1,3)}，{(0,1),(2,3)}，{(1,2),(2,3)}，{(0,1),(1,2)} 。
     * 示例 2：
     *
     * 输入：n = 3, k = 1
     * 输出：3
     * 解释：总共有 3 种不同的方案 {(0,1)}, {(0,2)}, {(1,2)} 。
     * 示例 3：
     *
     * 输入：n = 30, k = 7
     * 输出：796297179
     * 解释：画 7 条线段的总方案数为 3796297200 种。将这个数对 109 + 7 取余得到 796297179 。
     * 示例 4：
     *
     * 输入：n = 5, k = 3
     * 输出：7
     * 示例 5：
     *
     * 输入：n = 3, k = 2
     * 输出：1
     *
     *
     * 提示：
     *
     * 2 <= n <= 1000
     * 1 <= k <= n-1
     * @param n
     * @param k
     * @return
     */
    public int numberOfSets(int n, int k) {
        //嗯...不知道咋算呀？感觉应该会的，但是有点困，脑子好像不太动了...
        //就是根据k肯定知道需要分成几段嘛~然后再进行划分就行了，算了，也做不出来，还是去睡觉吧~
        return 0;
    }
}

/**
 * 5530. 奇妙序列 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Hard
 * 请你实现三个 API append，addAll 和 multAll 来实现奇妙序列。
 *
 * 请实现 Fancy 类 ：
 *
 * Fancy() 初始化一个空序列对象。
 * void append(val) 将整数 val 添加在序列末尾。
 * void addAll(inc) 将所有序列中的现有数值都增加 inc 。
 * void multAll(m) 将序列中的所有现有数值都乘以整数 m 。
 * int getIndex(idx) 得到下标为 idx 处的数值（下标从 0 开始），并将结果对 109 + 7 取余。如果下标大于等于序列的长度，请返回 -1 。
 *
 *
 * 示例：
 *
 * 输入：
 * ["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"]
 * [[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
 * 输出：
 * [null, null, null, null, null, 10, null, null, null, 26, 34, 20]
 *
 * 解释：
 * Fancy fancy = new Fancy();
 * fancy.append(2);   // 奇妙序列：[2]
 * fancy.addAll(3);   // 奇妙序列：[2+3] -> [5]
 * fancy.append(7);   // 奇妙序列：[5, 7]
 * fancy.multAll(2);  // 奇妙序列：[5*2, 7*2] -> [10, 14]
 * fancy.getIndex(0); // 返回 10
 * fancy.addAll(3);   // 奇妙序列：[10+3, 14+3] -> [13, 17]
 * fancy.append(10);  // 奇妙序列：[13, 17, 10]
 * fancy.multAll(2);  // 奇妙序列：[13*2, 17*2, 10*2] -> [26, 34, 20]
 * fancy.getIndex(0); // 返回 26
 * fancy.getIndex(1); // 返回 34
 * fancy.getIndex(2); // 返回 20
 *
 *
 * 提示：
 *
 * 1 <= val, inc, m <= 100
 * 0 <= idx <= 105
 * 总共最多会有 105 次对 append，addAll，multAll 和 getIndex 的调用。
 */
class Fancy {
    List<Integer> list;
    public Fancy() {
        list = new ArrayList<>();
    }

    public void append(int val) {
        list.add(val);
    }

    public void addAll(int inc) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i) + inc);
        }
    }

    public void multAll(int m) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i)*m);
        }
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        return list.get(idx)%(1000000000 + 7);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
