package com.radish.leetcode.tree;

/**
 * @Description IsBalanced
 *
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 * @Author Radish
 *
 * e...就是要求树的分支的高度嘛
 * @Date 2020-08-17 14:46
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }
    public static boolean isBalanced(TreeNode root) {
        int depth = getDepth(root);
        if (depth >= 0) return true;
        return false;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = getDepth(root.left);
        int depth1 = getDepth(root.right);
        if (depth < 0 || depth1 < 0) {
            return -1;
        }
        int i = depth - depth1;
        i = i < 0 ? -i : i;
        if (i > 1) return -1;
        return depth > depth1 ? depth + 1 : depth1 + 1;
    }
}
