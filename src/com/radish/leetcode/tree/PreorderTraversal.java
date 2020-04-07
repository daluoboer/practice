package com.radish.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 *   二叉树的前序遍历
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
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 嗯？迭代算法？是啥
 *
 * @Author Radish
 * @Date 2020/3/13
 */

public class PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left!=null) list.addAll(preorderTraversal(root.left));
        if (root.right!=null) list.addAll(preorderTraversal(root.right));
        return list;
    }
}
