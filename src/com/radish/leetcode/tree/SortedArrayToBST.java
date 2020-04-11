package com.radish.leetcode.tree;

import java.util.List;

/**
 * @Description SortedArrayToBST
 *
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @Author Radish
 * @Date 2020-04-11 16:12
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        TreeNode node = sortedArrayToBST(new int[]{1, 2, 3,4,5,6});
        List<Integer> integers = PreorderTraversal.inorderTraversal(node);
        System.out.println(integers);
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        //将有序数组转换成平衡二叉搜索树
        //从中点创建嘛~左边是左子树右边是右子树，每个mid都是根节点
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public static TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int mid = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        //左子树
        root.left = sortedArrayToBST(nums,l,mid-1);
        //右子树
        root.right = sortedArrayToBST(nums,mid+1,r);
        return root;
    }
}
