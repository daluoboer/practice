package com.radish.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description GetMinimumDifference
 *
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * @Author Radish
 * @Date 2020-10-12 17:56
 */
public class GetMinimumDifference {
    public static void main(String[] args) {
        GetMinimumDifference g = new GetMinimumDifference();
//        TreeNode node = TreeNode.convertArrToTree(new Integer[]{1,null,3,null,null,2});
//        TreeNode node = TreeNode.convertArrToTree(new Integer[]{4,2,6,1,3,null,null});
//        TreeNode node = TreeNode.convertArrToTree(new Integer[]{236,104,701,null,227,null,911});
        TreeNode node = TreeNode.convertArrToTree(new Integer[]{1,null,5,3});
        int min = g.getMinimumDifference(node);
        System.out.println(min);
    }

    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        //哎呀,怎么这么傻勒,应该是左序遍历嘛,左序遍历得到的数组就是从小到大排好序的
        setArray(root);
        return getMin(list);
    }

    private int getMin(List<Integer> list) {
        int size = list.size();
        Integer min = list.get(size - 1) - list.get(size - 2);
        for (int i = size - 1; i > 0; i--) {
            if (list.get(i) - list.get(i - 1) < min) {
                min = list.get(i) - list.get(i - 1);
            }
        }
        return min;
    }

    private void setArray(TreeNode root) {
        if (root == null) return;
        setArray(root.left);
        list.add(root.val);
        setArray(root.right);
    }
}
