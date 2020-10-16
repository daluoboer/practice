package com.radish.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description WidthOfBinaryTree2
 *
 * @Author Radish
 * @Date 2020-09-30 17:10
 */
public class WidthOfBinaryTree2 {
    int ans;
    Map<Integer, Integer> left;
    //深度优先
    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root,0,0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth,x->pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}



