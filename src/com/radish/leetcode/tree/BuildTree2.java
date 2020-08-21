package com.radish.leetcode.tree;

/**
 * @description BuildTree2
 *
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @Author Radish
 *
 * 为啥要通过两种遍历确定一棵树，为啥一定有中序遍历？
 * @Date 2020-05-22 11:13:58
 */

public class BuildTree2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //怎样构造二叉树？先要确定数据，然后再构建树
        //先找到根节点，再创建左右子树，中序遍历第一个就是根节点呀，然后找到前序遍历中根节点在哪儿，前面的就是左子树
        return null;
    }
}
