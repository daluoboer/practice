package com.radish.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description PathSum
 *
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @Author Radish
 * @Date 2020-09-26 09:25
 */
public class PathSum {
    public static void main(String[] args) {
        PathSum p = new PathSum();
        TreeNode node = TreeNode.convertArrToTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,null,5,1});
        List<List<Integer>> lists = p.pathSum(null, 22);
        System.out.println(lists);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        //咋做呢？从父节点到子节点遍历并累加，得到的和如果为sum，就返回该路径上的数组
        List<LinkedList<Integer>> aaa = aaa(root, sum);
        if (aaa != null) {
            for (List<Integer> a : aaa) {
                list.add(a);
            }
        }

        return list;
    }


    //可以传回一个数组啊！对哎，如果结果不对的话就传空嘛，哎呀机智！
    //不行哎，那如果把参数传下去呢？怎么知道怎一个list是当前节点应该调用的呢？
    public List<LinkedList<Integer>> aaa(TreeNode node, int sum) {
        if (node == null) return null;

        //叶子节点判断是否符合条件
        if (node.left == null && node.right == null) {
            List<LinkedList<Integer>> list = null;
            if (sum - node.val == 0) {
                list = new LinkedList<>();
                LinkedList<Integer> list1 = new LinkedList<>();
                list1.add(node.val);
                list.add(list1);
            }
            return list;
        }

        //如果不是叶子节点，应该看子节点的返回指是否为空，不为空则加入自身并返回
        List<LinkedList<Integer>> aaa = aaa(node.left, sum - node.val);

        List<LinkedList<Integer>> aaa1 = aaa(node.right, sum - node.val);

        if (aaa == null && aaa1 == null) return null;

        if (aaa != null && aaa1 != null) {
            for (LinkedList<Integer> l : aaa1) {
                aaa.add(l);
            }
        } else {
            aaa = aaa == null ? aaa1 : aaa;
        }

        if (aaa != null) {
            for (LinkedList<Integer> list : aaa) {
                list.addFirst(node.val);
            }
        }

        return aaa;
    }
}