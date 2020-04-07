package com.example.leetcode.tree;

import java.util.List;

/**
 * @Description
 * 从中序与后序遍历序列构造二叉树
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
 * @Date 2020/3/13
 */

public class BuildTree {
    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{4, 2, 5, 1, 6, 3, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
//        TreeNode treeNode = buildTree(new int[]{2,1,3}, new int[]{2,3,1});
        List<Integer> list = PreorderTraversal.preorderTraversal(treeNode);
        System.out.println(list);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = 0; i < postorder.length; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        //创建左子树
        int i = 0;
        if (index>0) {
            /*如果只有一个节点*/
            if (index==1) {
                root.left = new TreeNode(inorder[i]);
            } else {
                /*如果有一棵树*/
                int[] inLeft = new int[index];
                int[] postLeft = new int[index];
                while (i<index) {
                    inLeft[i] = inorder[i];
                    postLeft[i] = postorder[i];
                    i++;
                }
                root.left = buildTree(inLeft,postLeft);
            }
        }

        //创建右子树
        i = index+1;
        if (index<postorder.length-1){
            /*只有一个节点*/
            if (index == postorder.length-2) {
                root.right = new TreeNode(inorder[i]);
            } else {/*有一棵树*/
                int[] inRight = new int[inorder.length-index-1];
                int[] postRight = new int[inorder.length-index-1];

                while (i<inorder.length) {
                    inRight[i-index-1] = inorder[i];
                    postRight[i-index-1] = postorder[i-1];
                    i++;
                }
                root.right = buildTree(inRight,postRight);
            }
        }
        return root;
    }
}
