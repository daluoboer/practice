package com.radish.leetcode.weekTest;

/**
 * @Description ByteDanceWeek
 * @Author Radish
 * @Date 2020-09-12 15:03
 */
public class ByteDanceWeek {
    public static void main(String[] args) {
        ByteDanceWeek week = new ByteDanceWeek();
        int[] staples = new int[]{10,20,5};
        int[] drinks = {5, 5, 2};
        int i = week.breakfastNumber(staples, drinks, 15);
        System.out.println(i);
        /*int ab = week.calculate("AB");
        System.out.println(ab);*/
    }
    /**
     * 1. 速算机器人
     * 通过的用户数693
     * 尝试过的用户数711
     * 用户总通过次数694
     * 用户总提交次数728
     * 题目难度Easy
     * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
     *
     * "A" 运算：使 x = 2 * x + y；
     * "B" 运算：使 y = 2 * y + x。
     * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
     *
     * 示例 1：
     *
     * 输入：s = "AB"
     *
     * 输出：4
     *
     * 解释：
     * 经过一次 A 运算后，x = 2, y = 0。
     * 再经过一次 B 运算，x = 2, y = 2。
     * 最终 x 与 y 之和为 4。
     *
     * 提示：
     *
     * 0 <= s.length <= 10
     * s 由 'A' 和 'B' 组成
     * @param s
     * @return
     */
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int x = 1, y = 0;
        if (chars.length > 0) {
            for (char c : chars) {
                if (c == 'A') x = calA(x,y);
                else y = calB(x,y);
            }
        }
        return x+y;
    }

    public int calA(int x, int y) {
        return 2 * x + y;
    }

    public int calB(int x, int y) {
        return 2 * y + x;
    }


    /**
     * 2. 早餐组合
     * 通过的用户数40
     * 尝试过的用户数60
     * 用户总通过次数40
     * 用户总提交次数62
     * 题目难度Easy
     * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
     *
     * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
     *
     * 示例 1：
     *
     * 输入：staple = [10,20,5], drinks = [5,5,2], x = 15
     *
     * 输出：6
     *
     * 解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
     * 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
     * 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
     * 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
     * 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
     * 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
     * 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
     *
     * 示例 2：
     *
     * 输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9
     *
     * 输出：8
     *
     * 解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
     * 第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
     * 第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
     * 第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
     * 第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
     * 第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
     * 第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
     * 第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
     * 第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
     *
     * 提示：
     *
     * 1 <= staple.length <= 10^5
     * 1 <= drinks.length <= 10^5
     * 1 <= staple[i],drinks[i] <= 10^5
     * 1 <= x <= 2*10^5
     * @param staple
     * @param drinks
     * @param x
     * @return
     */
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        //昂？居然超出时间限制了？？？？嗷！可以先排序然后大的就可以直接不用算了！
        //卧槽！堆排序也超时！
        int fMaxIndex = sort(staple, x);
        int dMaxIndex = sort(drinks, x);
        //卧槽！！！！快排也超时！看来问题不是出在排序这儿咯...
        //我已经绞尽脑汁了但是还是不行，罢了~下一个
        //不应该遍历取值，而是应该直接找到组合的值进行排列组合的计算这样才是最快的
//        quickSort(staple,0,staple.length-1);
//        quickSort(drinks,0,drinks.length-1);

        //按照二分查找的方法找到staple和drinks小于x的下标
        //e...如果要这么说的话，那应该在排序的时候就不管那些大数
        //e...已经没有一个一个遍历累加了但是还是超出时间...这次是真的绞尽脑汁竭尽全力了...s
        int count = 0;

        //啊！这里应该从大值遍历啊！找到大的然后就直接得到值了啊！
        for (int i = fMaxIndex-1; i >= 0; i--) {
            for (int j = dMaxIndex - 1; j >= 0; j--) {
                if (staple[i] + drinks[j] <= x) {
                    count += j+1;
                    break;
                }
            }
        }

        /*for (int i = 0; i < fMaxIndex; i++) {
            for (int j = 0; j < dMaxIndex; j++) {
                if (staple[i] + drinks[j] <= x) {
                    count++;
                } else {
                    if (j == 0) {
                        flag = true;
                    }
                    break;
                }
            }
            if (flag) break;
        }*/
        return count % 1000000007;
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l;
        int j = r;
        int point = nums[i];
        while (i < j) {
            //右边的小数
            while (i < j && nums[j] >= point){
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            //左边的大数
            while (i < j && nums[i] <= point) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = point;
        //左边
        quickSort(nums, l, i-1);
        //右边
        quickSort(nums, i+1, r);
    }

    public int sort(int[] nums, int x) {
        int length = nums.length;
        int rMaxIndex = -1;

        while (length > 0) {
            for (int i = length/2 - 1; i >= 0; i--) {
                //看该值是否大于它的2i+1和2i+2的值
                int maxIndex = 0;
                if (2*i+2 < length) {
                    maxIndex = nums[2*i+1] > nums[2*i+2] ? 2*i+1 : 2*i+2;
                } else {
                    maxIndex = 2*i+1;
                }
                if (nums[maxIndex] > nums[i]) {
                    //将大值给堆顶
                    int temp = nums[i];
                    nums[i] = nums[maxIndex];
                    nums[maxIndex] = temp;
                }
            }
            //此时第一个元素已经为最大值，将最大值与最后一个元素交换，完成一轮
            if (nums[0] > x) {
                rMaxIndex = length;
            }
            int temp = nums[length-1];
            nums[length-1] = nums[0];
            nums[0] = temp;
            length--;
        }
        return rMaxIndex > 0 ? rMaxIndex-1 : nums.length;
    }

    /**
     * 3. 秋叶收藏集
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
     * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
     *
     * 示例 1：
     *
     * 输入：leaves = "rrryyyrryyyrr"
     *
     * 输出：2
     *
     * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
     *
     * 示例 2：
     *
     * 输入：leaves = "ryr"
     *
     * 输出：0
     *
     * 解释：已符合要求，不需要额外操作
     *
     * 提示：
     *
     * 3 <= leaves.length <= 10^5
     * leaves 中只包含字符 'r' 和字符 'y'
     * @param leaves
     * @return
     */
    public int minimumOperations(String leaves) {
        return 0;
    }

    /**
     * 4. 快速公交
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Hard
     * 小扣打算去秋日市集，由于游客较多，小扣的移动速度受到了人流影响：
     *
     * 小扣从 x 号站点移动至 x + 1 号站点需要花费的时间为 inc；
     * 小扣从 x 号站点移动至 x - 1 号站点需要花费的时间为 dec。
     * 现有 m 辆公交车，编号为 0 到 m-1。小扣也可以通过搭乘编号为 i 的公交车，从 x 号站点移动至 jump[i]*x 号站点，耗时仅为 cost[i]。小扣可以搭乘任意编号的公交车且搭乘公交次数不限。
     *
     * 假定小扣起始站点记作 0，秋日市集站点记作 target，请返回小扣抵达秋日市集最少需要花费多少时间。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。
     *
     * 注意：小扣可在移动过程中到达编号大于 target 的站点。
     *
     * 示例 1：
     *
     * 输入：target = 31, inc = 5, dec = 3, jump = [6], cost = [10]
     *
     * 输出：33
     *
     * 解释：
     * 小扣步行至 1 号站点，花费时间为 5；
     * 小扣从 1 号站台搭乘 0 号公交至 6 * 1 = 6 站台，花费时间为 10；
     * 小扣从 6 号站台步行至 5 号站台，花费时间为 3；
     * 小扣从 5 号站台搭乘 0 号公交至 6 * 5 = 30 站台，花费时间为 10；
     * 小扣从 30 号站台步行至 31 号站台，花费时间为 5；
     * 最终小扣花费总时间为 33。
     *
     * 示例 2：
     *
     * 输入：target = 612, inc = 4, dec = 5, jump = [3,6,8,11,5,10,4], cost = [4,7,6,3,7,6,4]
     *
     * 输出：26
     *
     * 解释：
     * 小扣步行至 1 号站点，花费时间为 4；
     * 小扣从 1 号站台搭乘 0 号公交至 3 * 1 = 3 站台，花费时间为 4；
     * 小扣从 3 号站台搭乘 3 号公交至 11 * 3 = 33 站台，花费时间为 3；
     * 小扣从 33 号站台步行至 34 站台，花费时间为 4；
     * 小扣从 34 号站台搭乘 0 号公交至 3 * 34 = 102 站台，花费时间为 4；
     * 小扣从 102 号站台搭乘 1 号公交至 6 * 102 = 612 站台，花费时间为 7；
     * 最终小扣花费总时间为 26。
     *
     * 提示：
     *
     * 1 <= target <= 10^9
     * 1 <= jump.length, cost.length <= 10
     * 2 <= jump[i] <= 10^6
     * 1 <= inc, dec, cost[i] <= 10^6
     * @param target
     * @param inc
     * @param dec
     * @param jump
     * @param cost
     * @return
     */
    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        //应该是动态规划吧~
        //如果target=0就返回0
        //
        return 0;
    }

    /**
     * 5. 追逐游戏
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Hard
     * 秋游中的小力和小扣设计了一个追逐游戏。他们选了秋日市集景区中的 N 个景点，景点编号为 1~N。此外，他们还选择了 N 条小路，满足任意两个景点之间都可以通过小路互相到达，且不存在两条连接景点相同的小路。整个游戏场景可视作一个无向连通图，记作二维数组 edges，数组中以 [a,b] 形式表示景点 a 与景点 b 之间有一条小路连通。
     *
     * 小力和小扣只能沿景点间的小路移动。小力的目标是在最快时间内追到小扣，小扣的目标是尽可能延后被小力追到的时间。游戏开始前，两人分别站在两个不同的景点 startA 和 startB。每一回合，小力先行动，小扣观察到小力的行动后再行动。小力和小扣在每回合可选择以下行动之一：
     *
     * 移动至相邻景点
     * 留在原地
     * 如果小力追到小扣（即两人于某一时刻出现在同一位置），则游戏结束。若小力可以追到小扣，请返回最少需要多少回合；若小力无法追到小扣，请返回 -1。
     *
     * 注意：小力和小扣一定会采取最优移动策略。
     *
     * 示例 1：
     *
     * 输入：edges = [[1,2],[2,3],[3,4],[4,1],[2,5],[5,6]], startA = 3, startB = 5
     *
     * 输出：3
     *
     * 解释：
     * image.png
     *
     * 第一回合，小力移动至 2 号点，小扣观察到小力的行动后移动至 6 号点；
     * 第二回合，小力移动至 5 号点，小扣无法移动，留在原地；
     * 第三回合，小力移动至 6 号点，小力追到小扣。返回 3。
     *
     * 示例 2：
     *
     * 输入：edges = [[1,2],[2,3],[3,4],[4,1]], startA = 1, startB = 3
     *
     * 输出：-1
     *
     * 解释：
     * image.png
     *
     * 小力如果不动，则小扣也不动；否则小扣移动到小力的对角线位置。这样小力无法追到小扣。
     *
     * 提示：
     *
     * edges 的长度等于图中节点个数
     * 3 <= edges.length <= 10^5
     * 1 <= edges[i][0], edges[i][1] <= edges.length 且 edges[i][0] != edges[i][1]
     * 1 <= startA, startB <= edges.length 且 startA != startB
     * @param edges
     * @param startA
     * @param startB
     * @return
     */
    public int chaseGame(int[][] edges, int startA, int startB) {
        //就是如果俩人都在环形图或者小扣可以到达环形图上就追不上，如果在非环形图上且小扣不能到达环形图，则可以追上
        return 0;
    }
}
