package com.radish.leetcode.array;

import com.radish.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description Rob
 * @Author Radish
 * @Date 2020-09-22 21:22
 */
public class Rob {

    public static void main(String[] args) {
        Rob rob = new Rob();
//        int[] money = new int[]{1,2,3,1};
//        int[] money = new int[]{1,2,1,1};
//        int[] money = new int[]{2,2,3};
//        int[] money = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
//        int i = rob.robII(money);
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(1);
        int i = rob.robIII(node);
        System.out.println(i);
    }
    /**
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     * @param nums
     * @return
     */
    public int robI(int[] nums) {
        if (nums.length == 0) return 0;
        int[] moneys = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) moneys[i] = nums[i];
            else if (i == 1) moneys[i] = Math.max(nums[0],nums[1]);
            else moneys[i] = Math.max(moneys[i - 1], moneys[i - 2] + nums[i]);
        }
        return moneys[nums.length - 1];
    }

    /**
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     *
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * @param nums
     * @return
     */
    public int robII(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robIIs(Arrays.copyOfRange(nums,0,nums.length - 1)),robIIs(Arrays.copyOfRange(nums,1,nums.length)));
    }

    public int robIIs(int[] nums) {
        int pre = 0, sum = 0, tmp;
        for (int money : nums) {
            tmp = sum;
            sum = Math.max(pre + money,sum);
            pre = tmp;
        }
        return sum;
    }

    /**
     * 337. 打家劫舍 III
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 示例 1:
     *
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     *
     * 输入: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     * @param root
     * @return
     */
    public int robIII(TreeNode root) {
        //嗯 偷root最多可得 Math.max(dfs(root.left.left) + dfs(root.left.right) + dfs(root.right.left) + dfs(root.right.right) + root, dfs(root.left) + dfs(root.right));
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        f.put(root,root.val + g.getOrDefault(root.left,0) + g.getOrDefault(root.right, 0));
        g.put(root,Math.max(f.getOrDefault(root.left,0),g.getOrDefault(root.left,0)) + Math.max(f.getOrDefault(root.right,0),f.getOrDefault(root.right,0)));
    }

    HashMap<TreeNode, Integer> f = new HashMap<>();
    HashMap<TreeNode, Integer> g = new HashMap<>();

}
