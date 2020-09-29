package com.radish.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description PostorderTraversal
 *
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 * @Author Radish
 * @Date 2020-09-29 23:09
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        PostorderTraversal p = new PostorderTraversal();
        Integer[] ints = {1, null, 2, null,null,3};
        TreeNode node = TreeNode.convertArrToTree(ints);
        List<Integer> list = p.postorderTraversal(node);
        System.out.println(list);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Integer> ppl = postorderTraversal(root.left);
        List<Integer> ppr = postorderTraversal(root.right);

        if (ppl.size() > 0 && ppr.size() > 0) {
            for (Integer i : ppr) {
                ppl.add(i);
            }
        } else if (ppl.size() > 0 || ppr.size() > 0) {
            ppl = ppl.size() > 0 ? ppl : ppr;
        }

        ppl.add(root.val);
        return ppl;
    }


}
