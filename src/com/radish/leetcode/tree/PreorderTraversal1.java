package com.radish.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description PreorderTraversal1
 *
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @Author Radish
 * @Date 2020-10-27 15:14
 */
public class PreorderTraversal1 {
    public static void main(String[] args) {
        PreorderTraversal1 p1 = new PreorderTraversal1();
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        List<Integer> list = p1.preorderTraversal(node);
        System.out.println(list);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        //前序遍历
        List<Integer> list = new ArrayList<>();
        setData(root, list);
        return list;
    }

    private void setData(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left != null) setData(root.left,list);
        if (root.right != null) setData(root.right, list);
    }
}
