package com.radish.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description WidthOfBinaryTree1
 *
 * @Author Radish
 * @Date 2020-09-30 17:10
 */
public class WidthOfBinaryTree1 {
    public static void main(String[] args) {
        WidthOfBinaryTree1 w = new WidthOfBinaryTree1();
//        Integer[] integers = new Integer[]{1,3,null,5,3,null,null};
//        Integer[] integers = new Integer[]{1,3,2,5,3,null,9};
//        Integer[] integers = new Integer[]{1,2,3,5,null};
        Integer[] integers = new Integer[]{1,3,2,5,null,null,9,6,null,null,null,null,null,null,7};
        TreeNode node = TreeNode.convertArrToTree(integers);
        int i = w.widthOfBinaryTree(node);
        System.out.println(i);
    }
    //宽度优先搜索
    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }
}

class AnnotatedNode {
    TreeNode node;
    int depth, pos;
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}

