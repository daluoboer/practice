package com.radish.leetcode.tree;

/**
 * @description MaxDepth
 *
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @Author Radish
 * @Date 2020-07-28 10:16:40
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int i = maxDepth(root);
        System.out.println(i);
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /*最大深度..要遍历每一个节点嘛~哎呀，你傻啊！每一层的下标不是有规律的吗！最大节点肯定是最后一个不为空的值那个节点啊！吧？哈哈哈哈
    啊但是人家给的不是数组...是节点啊
    那要把每一个节点遍历到头？e....咋遍历来着
    e....这....好简单呐...........
    */
    public static int maxDepth(TreeNode root) {
        if (root != null) {
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }
        return 0;
    }
}
