package com.radish.leetcode.tree;

/**
 * @Description ConvertBST
 *
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @Author Radish
 * @Date 2020-09-21 23:02
 */
public class ConvertBST {
    public static void main(String[] args) {
        ConvertBST c = new ConvertBST();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        TreeNode node1 = c.convertBST(node);
        System.out.println(node1);
    }
    //啊！右序遍历直接把上一个节点的值和当前节点的值相加即可！
    int sum1 = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val = sum1 += root.val;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST1(TreeNode root) {
        //总不能每一个节点都遍历一些吧？就遍历一遍，把树转化为有序数组，然后嗯...前序遍历，啊，不用转化为数组，转化为队列即可，先进先出嘛！啊！不对，直接求一遍和，然后没遍历一个节点就减掉该值不就行啦？把后面的值加起来即可
        if (root == null) return null;
        int treeSum = getTreeSum(root);
        setTreeSum(root, treeSum);
        return root;
    }

    public int getTreeSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getTreeSum(root.left) + getTreeSum(root.right);
    }

    public int setTreeSum(TreeNode root, int sum) {
        //当前节点为最小节点，就将当前值设置为sum，将sum设置为sum-root.val
        if (root.left != null) sum = setTreeSum(root.left, sum);
        int cur = root.val;
        root.val = sum;
        sum -= cur;
        if (root.right != null) sum = setTreeSum(root.right,sum);
        return sum;
    }
}
