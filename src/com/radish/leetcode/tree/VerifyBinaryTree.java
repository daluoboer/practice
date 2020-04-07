package com.radish.leetcode.tree;

import java.util.List;

/**
 * @Description
 *
 *  验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @Author Radish
 * @Date 2020/3/13
 */

public class VerifyBinaryTree {
    public static void main(String[] args) {

    }
    public boolean isValidBST(TreeNode root) {
        if (root==null) return false;
        //左子树是否是二叉搜索树
        if (root.left != null) {
            if (root.left.val>=root.val) return false;

        }
        //右子树是否是二叉搜索树
        if (root.right !=  null) {
            if (root.right.val<=root.val) return false;
            if (!isValidBST(root.right)) return false;
        }
        return true;
    }

    /*要获取左子树最大值，右子树最小值，需要从树的最底层向上遍历？*/
    public static List<Integer> validLeftBST(TreeNode root){

        return null;
    }

    /*或者从上往下遍历，记录需要大于的最大数和需要小于的最小数*/
    /*e...先吃饭吧！*/

}
