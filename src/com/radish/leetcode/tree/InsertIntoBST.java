package com.radish.leetcode.tree;

/**
 * @Description InsertIntoBST
 *
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 *
 *
 * 例如,
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 *
 * 提示：
 *
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 *
 * @Author Radish
 * @Date 2020-09-30 09:06
 */
public class InsertIntoBST {
    public static void main(String[] args) {
        InsertIntoBST in = new InsertIntoBST();
        Integer[] integers = new Integer[]{4,2,7,1,3,6};
        TreeNode node = TreeNode.convertArrToTree(integers);
        TreeNode node1 = in.insertIntoBST(node, 5);
        String s = TreeNode.treeToString(node1);
        System.out.println(s);
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //这咋还中等难度呢？难道还有啥玄机？不管，先按最简单的来
        if (root == null) root = new TreeNode(val);
        if (val < root.val) {
            if (root.left == null) root.left = new TreeNode(val);
            else insertIntoBST(root.left, val);
        } else if (val > root.val) {
            if (root.right == null) root.right = new TreeNode(val);
            else insertIntoBST(root.right,val);
        }
        return root;
    }
}
