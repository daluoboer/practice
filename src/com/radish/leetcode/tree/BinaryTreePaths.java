package com.radish.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description BinaryTreePaths
 *
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * @Author Radish
 * @Date 2020-09-04 23:33
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        int i = 8;
        i = i++;
        System.out.println(i);
        /*TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(5);
        List<String> list = binaryTreePaths1(node);
        System.out.println(list);*/
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
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
        } else {
            List<String> strings = binaryTreePaths(root.left);
            if (strings != null) {
                for (String s : strings) {
                    list.add(root.val + "->" + s);
                }
            }
            List<String> strings1 = binaryTreePaths(root.right);
            if (strings1 != null) {
                for (String s : strings1) {
                    list.add(root.val + "->" + s);
                }
            }
        }
        return list;
    }


    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root,"",paths);
        return paths;
    }

    public static void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root == null) return;
        StringBuilder builder = new StringBuilder(path);
        builder.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(builder.toString());
        } else {
            builder.append("->");
            constructPaths(root.left,builder.toString(),paths);
            constructPaths(root.right,builder.toString(),paths);
        }
    }
}
