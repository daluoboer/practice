package com.radish.leetcode.tree;

/**
 * @Description MergeTrees
 *
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始
 *
 * @Author Radish
 * @Date 2020-09-23 09:11
 */
public class MergeTrees {
    public static void main(String[] args) {
        MergeTrees m = new MergeTrees();
        /*TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(3);
        node1.left.right = new TreeNode(4);
        node1.right.right = new TreeNode(7);*/
//        TreeNode.convertArrToTree(new Integer[]{2, null});
        TreeNode node3 = TreeNode.convertArrToTree(new Integer[]{1, 3, 2, 5});
        TreeNode node4 = TreeNode.convertArrToTree(new Integer[]{2, 1, 3,null, 4,null, 7});
        TreeNode node2 = m.mergeTrees(node3, node4);
        System.out.println(TreeNode.treeToString(node2));
//        System.out.println(Math.pow(8,1.0/3.0));
//        System.out.println(node2);
//        System.out.println(Math.log(17)/Math.log(2));
        /*TreeNode node = TreeNode.convertArrToTree(new Integer[]{1, 2, null, 3,4});
        String s = TreeNode.treeToString(node);
        System.out.println(s);*/
    }



    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //从两棵树的根节点开始遍历，就是将两棵树合并到另一棵树上嘛
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
