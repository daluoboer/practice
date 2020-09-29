package com.radish.leetcode.tree;

/**
 * @Description InvertTree
 *
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * @Author Radish
 * @Date 2020-09-29 23:27
 */
public class InvertTree {
    public static void main(String[] args) {
        InvertTree i = new InvertTree();

        Integer[] ints = {4, 2, 7, 1, 3, 6, 9};
        TreeNode node = TreeNode.convertArrToTree(ints);
        TreeNode node1 = i.invertTree(node);
        String s = TreeNode.treeToString(node1);
        System.out.println(s);
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
