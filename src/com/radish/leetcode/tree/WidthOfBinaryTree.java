package com.radish.leetcode.tree;

import java.util.ArrayList;

/**
 * @Description WidthOfBinaryTree
 *
 * 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 *
 * @Author Radish
 * @Date 2020-09-30 17:10
 */
public class WidthOfBinaryTree {
    public static void main(String[] args) {
        WidthOfBinaryTree w = new WidthOfBinaryTree();
//        Integer[] integers = new Integer[]{1,3,null,5,3,null,null};
//        Integer[] integers = new Integer[]{1,3,2,5,3,null,9};
//        Integer[] integers = new Integer[]{1,2,3,5,null};
        Integer[] integers = new Integer[]{1,3,2,5,null,null,9,6,null,null,null,null,null,null,7};
        TreeNode node = TreeNode.convertArrToTree(integers);
        int i = w.widthOfBinaryTree(node);
        System.out.println(i);
    }
    //e....又超出内存限制了，看来是跟上次那个，就前两天那啥一个原因，好吧，搞一搞
    ArrayList<TreeNode> nodes = new ArrayList<>();
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        //层序遍历，遇到不为空的节点就统计宽度
        nodes.add(root);
        if (root.left != null || root.right != null) setNodes(2);
        return getMaxWidth(1);
    }

    //从第几层开始树最宽的宽度
    private int getMaxWidth(int depth) {
        int start = (int)Math.pow(2, depth - 1) - 1;
        if (nodes.size() <= start) return 0;
        int end = (int) Math.pow(2, depth) - 2;
        int i = start, j = end;
        while (i < j) {
            if (nodes.get(i) != null) break;
            i++;
        }
        while (i < j) {
            if (nodes.get(j) != null) break;
            j--;
        }
        int max = 0;
        if (i < j) {
            max = j - i + 1;
        } else if (i == j) max = 1;
        max = Math.max(max,getMaxWidth(depth + 1));
        return max;
    }

    //i为depth
    private void setNodes(int depth) {
        //前头有2^（i-1）-1个元素，该层元素从2^(i-1)个开始，到第2^i-1个结束，e.....但是你算这些好像没有用哎...要根据上一层的元素来计算的....
        //上一层的元素从第2^(i-2)个开始，到第2^（i-1）-1个结束
        int start = (int)Math.pow(2, depth - 2) - 1;
        int end = (int) Math.pow(2, depth - 1) - 1;
        int count = 0;
        for (int i = start; i < end; i++) {
            TreeNode node = nodes.get(i);
            if (node != null) {
                nodes.add(node.left);
                nodes.add(node.right);
                if ((node.left != null && (node.left.left != null || node.left.right != null)) || (node.right != null && (node.right.left != null || node.right.right != null))) count++;
            } else {
                nodes.add(null);
                nodes.add(null);
            }
        }

        if (count > 0) {
            setNodes(depth + 1);
        }
    }
}
