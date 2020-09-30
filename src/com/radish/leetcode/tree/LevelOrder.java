package com.radish.leetcode.tree;

import com.radish.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description LevelOrder
 *
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * @Author Radish
 * @Date 2020-09-30 11:39
 */
public class LevelOrder {

    public static void main(String[] args) {
        LevelOrder l = new LevelOrder();
//        Integer[] integers = new Integer[]{3,9,20,null,null,15,7};
        Integer[] integers = new Integer[]{};
        TreeNode node = TreeNode.convertArrToTree(integers);
        int[] ints = l.levelOrder(node);
        MyUtils.print(ints);
    }
    List<TreeNode> nodes = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        nodes.add(root);
        setNode(1);
        int[] ints = new int[nodes.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = nodes.get(i).val;
        }
        return ints;
    }

    private void setNode(int i) {
        int count = 0;
        int size = nodes.size();
        int i1 = nodes.size() - i;
        for (int j = i1; j < size; j++) {
            TreeNode node = nodes.get(j);
            if (node.left != null) {
                nodes.add(node.left);
                count++;
            }
            if (node.right != null) {
                nodes.add(node.right);
                count++;
            }
        }
        if (count > 0) {
            setNode(count);
        }
    }

}
