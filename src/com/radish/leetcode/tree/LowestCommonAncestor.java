package com.radish.leetcode.tree;

/**
 * @Description LowestCommonAncestor
 *
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * @Author Radish
 * @Date 2020-09-27 08:56
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        LowestCommonAncestor l = new LowestCommonAncestor();
        Integer[] ints = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode node = TreeNode.convertArrToTree(ints);
        TreeNode node1 = l.lowestCommonAncestor(node, node.left.right, node.left);
        System.out.println(node1.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //这个居然是简单题哎？二叉搜索树的特点：左子树小于当前节点，右子树大于当前节点
        //在root节点下找p、q节点，如果root等于其中一个那肯定就是父节点咯
        //先找到这俩节点，然后返回true或false，如果俩true就是父节点
        if (root == p || root == q) {
            return root;
        }
        //如果一个是左子树一个是右子树，那么root也是父节点
        if ((p.val - root.val) * (q.val - root.val) < 0) {
            return root;
        }
        //都在左子树上
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        //都在右子树上
        return lowestCommonAncestor(root.right,p,q);
    }
}
