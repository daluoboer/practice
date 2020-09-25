package com.radish.leetcode.tree;

import java.util.Arrays;

/**
 * @Description BuildTree925
 *
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @Author Radish
 * @Date 2020-09-25 09:01
 */
public class BuildTree925 {
    public static void main(String[] args) {
        BuildTree925 b = new BuildTree925();
        TreeNode node = b.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(node);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //后序遍历获得root节点，然后再中序遍历中查找该节点，分成左右子树，再对左右子树进行遍历
        if (postorder.length == 0) return null;
        if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }
        int val = postorder[postorder.length - 1];
        //查找val在inorder的下标，哎呀不能二分，你一排序人家不乱了吗！哎呀呀呀
        int inIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                inIndex = i;
                break;
            }
        }

        TreeNode node = new TreeNode(val);

        node.left = buildTree(Arrays.copyOfRange(inorder, 0, inIndex),Arrays.copyOfRange(postorder, 0, inIndex));
        node.right = buildTree(Arrays.copyOfRange(inorder, inIndex + 1, inorder.length),Arrays.copyOfRange(postorder, inIndex, postorder.length - 1));
        return node;
    }

}
