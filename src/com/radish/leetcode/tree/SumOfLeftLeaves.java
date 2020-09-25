package com.radish.leetcode.tree;

/**
 * @Description SumOfLeftLeaves
 *
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @Author Radish
 * @Date 2020-09-19 22:03
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        SumOfLeftLeaves s = new SumOfLeftLeaves();
        int i = s.sumOfLeftLeaves(node);
        System.out.println(i);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeft(root,false);
    }

    public int sumOfLeft(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (isLeft && root.left == null && root.right == null) {
            return root.val;
        }
        return sumOfLeft(root.left, true) + sumOfLeft(root.right, false);
    }
}
