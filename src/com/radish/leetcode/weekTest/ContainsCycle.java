package com.radish.leetcode.weekTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description ContainsCycle
 *
 * 5482. 二维网格图中探测环 显示英文描述
 * 通过的用户数26
 * 尝试过的用户数36
 * 用户总通过次数27
 * 用户总提交次数43
 * 题目难度Hard
 * 给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。
 *
 * 一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值 。
 *
 * 同时，你也不能回到上一次移动时所在的格子。比方说，环  (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1, 1) 回到了上一次移动时的格子。
 *
 * 如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
 * 输出：true
 * 解释：如下图所示，有 2 个用不同颜色标出来的环：
 *
 * 示例 2：
 *
 *
 *
 * 输入：grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
 * 输出：true
 * 解释：如下图所示，只有高亮所示的一个合法环：
 *
 * 示例 3：
 *
 *
 *
 * 输入：grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
 * 输出：false
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 500
 * 1 <= n <= 500
 * grid 只包含小写英文字母。
 *
 * @Author Radish
 * @Date 2020-08-22 22:52
 */
public class ContainsCycle {
    public static void main(String[] args) {
        boolean b = containsCycle(new char[][]{{'a', 'a', 'a'}, {'a', 'b', 'a'}, {'a', 'a', 'a'}});
        System.out.println(b);
    }
    public static boolean containsCycle(char[][] grid) {
        //那我不得记录x和y的值嘛，那存起来咋检索呢？
        //还有哇如果把已经连起来的数都存到一个数组中，那如果剩余的两个方向都有咋办呢？回溯法？
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (inCycle(grid,i,j)) return true;
            }
        }
        return false;
    }

    /**
     * 这个点是否在环上，然后就可以用广度优先遍历还是深度优先遍历？还有回溯法就Ok啦
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public static boolean inCycle(char[][] grid, int x, int y) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{x,y});
        for (int[] ins : list) {
            System.out.println("[" + ins[0] + ", " + ins[1] + "]");
        }
        return setYourFriend(grid,list);
    }

    /**
     * 给最后一个元素找到临近的元素并set进list,如果一个朋友都没有返回false
     * 应该没有问题哎~但是超出时间限制了~
     * @param grid
     * @param list
     */
    public static boolean setYourFriend(char[][] grid, List<int[]> list) {
        if (list.size() == 0) return false;
        int[] ints = list.get(list.size() - 1);
        if (ints[0] == -1) return true;
        int[] lastInts = ints;
        if (list.size() >= 4) {
            int[] ints0 = list.get(0);
            if (ints0[0] == ints[0] && ints0[1] == ints[1]) {
                list.add(new int[]{-1,-1});
                return true;
            }
        }
        if (list.size()>1) lastInts = list.get(list.size() - 2);
        int x = ints[0], y = ints[1];
        char curVal = grid[x][y];
        boolean hasFriend = false;
        boolean isA = ints[0] == lastInts[0] && ints[1] ==  lastInts[1];
        //有一个以上点才需要判断不等于该节点的上一个，如果没有就不需要判断啦
        //上面
        if (x > 0 && (isA || (lastInts[0] != x-1 || lastInts[1] != y)) && grid[x-1][y] == curVal) {
            list.add(new int[]{x-1,y});
            hasFriend |= setYourFriend(grid,list);
        }
        //下面
        if (!hasFriend && x < grid.length - 1 && (isA || (lastInts[0] != x+1 || lastInts[1] != y)) && grid[x+1][y] == curVal) {
            list.add(new int[]{x+1,y});
            hasFriend |= setYourFriend(grid,list);
        }
        //左边
        if (!hasFriend && y > 0 && (isA || (lastInts[0] != x || lastInts[1] != y-1)) && grid[x][y-1] == curVal) {
            list.add(new int[]{x,y-1});
            hasFriend |= setYourFriend(grid,list);
        }
        //右边
        if (!hasFriend && y < grid[0].length-1 && (isA || (lastInts[0] != x || lastInts[1] != y+1)) && grid[x][y+1] == curVal) {
            list.add(new int[]{x,y+1});
            hasFriend |= setYourFriend(grid,list);
        }
        if (!hasFriend) list.remove(list.get(list.size()-1));
        return hasFriend;
    }
}
