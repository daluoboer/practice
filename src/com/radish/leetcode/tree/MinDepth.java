package com.radish.leetcode.tree;

/**
 * @Description MinDepth
 *
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * @Author Radish
 * @Date 2020-08-21 08:27
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
    }
    public static int minDepth(TreeNode root) {
        //左子树和右子树的最小深度+1
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int i = minDepth(root.left);
        int i1 = minDepth(root.right);
        return root.left == null || root.right == null ? i + i1 + 1 : Math.min(i,i1) + 1;
    }
}
