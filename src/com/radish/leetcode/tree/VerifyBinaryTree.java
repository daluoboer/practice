package com.radish.leetcode.tree;

import java.util.HashMap;

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
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(12);
//        node.right = new TreeNode(2);
        node.left.left = new TreeNode(1);
        boolean validBST = isValidBST(node);
        System.out.println(validBST);
    }
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //先用最笨的方法好了，最笨的方法写出来再进行优化
        //1.先找到最底层的树，从下判断是不是一棵树，并返回该树的最值，然后逐层往上迭代。
        HashMap<String, Object> map = validTree(root);
        boolean valid = (boolean) map.get("valid");
        return valid;
    }

    //带上子树的最值返回
    public static HashMap<String,Object> validTree(TreeNode root) {
        HashMap<String,Object> map = new HashMap<>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        //左右子树都没有下一层了
        map.put("valid",true);
        if (left == null && right == null) {
            //这是底层了
            map.put("max",root.val);
            map.put("min",root.val);
        }

        if (left != null) {
            HashMap<String, Object> mapL = validTree(left);
            boolean valid = (boolean) mapL.get("valid");
            //如果有子树不是二叉搜索树，直接返回该结果即可
            if (!valid) {
                return mapL;
            }
            //如果子树是二叉搜索树，需要判断子树的最大值是否小于根节点
            Integer maxLeft = (int) mapL.get("max");
            if (maxLeft >= root.val) {
                mapL.put("valid",false);
                return mapL;
            }
            //如果子树是二叉搜索树，并且子树的最大值小于根节点的值，更新要返回的树最小值（左树包含最小值啊）
//            map.put("max",root.val);
            int min = (int) mapL.get("min");
            map.put("min",min < root.val?min:root.val);
            if (right == null) {
                //如果右树为空，则最大值也在这儿
                map.put("max",maxLeft > root.val?maxLeft:root.val);
            }
        }

        if (right != null) {
            HashMap<String, Object> mapR = validTree(right);
            //如果有子树不是二叉搜索树，直接返回结果
            boolean valid = (boolean) mapR.get("valid");
            if (!valid) {
                return mapR;
            }
            //如果子树是二叉搜索树，需要判断子树的最小值是否大于根节点
            int minRight = (int) mapR.get("min");
            if (minRight <= root.val){
                mapR.put("valid",false);
                return mapR;
            }
            //如果子树是二叉搜索树，且该树最小值大于根节点，更新该树最小值
            int max = (int) mapR.get("max");
            map.put("max",max > root.val? max : root.val);
            if (left == null) {
                map.put("min",minRight < root.val ? minRight : root.val);
            }
        }

        return map;
    }



}
