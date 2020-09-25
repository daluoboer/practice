package com.radish.leetcode.tree;

import java.util.HashMap;

/**
 * @Description MinCameraCover
 *
 * 968. 监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 *
 *
 *
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 *
 *
 * 提示：
 *
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 *
 * @Author Radish
 * @Date 2020-09-22 19:34
 */
public class MinCameraCover {
    public static void main(String[] args) {
//        System.out.println(Math.pow(8, 1.0/3));
        MinCameraCover m = new MinCameraCover();
        /*TreeNode node = TreeNode.convertArrToTree(new Integer[]{3, 2, 3, null, 3, null, 1});
        int i = m.rob(node);
        System.out.println(i);*/
        TreeNode node = TreeNode.convertArrToTree(new Integer[]{0,0,null,0,null,0,null,null,0});
//        TreeNode node = TreeNode.convertArrToTree(new Integer[]{0,0,null,0,0});
        int i = m.minCameraCover(node);
        System.out.println(i);

    }


    public int minCameraCover(TreeNode root) {
        //太难了....明天再看吧！
        return 0;
    }


    public int rob(TreeNode root) {
        //有俩数组，一个数组放f，一个数组放g
        HashMap<TreeNode, Integer> f = new HashMap<>();
        HashMap<TreeNode, Integer> g = new HashMap<>();
        dfs(root, f, g);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root, HashMap<TreeNode, Integer> f, HashMap<TreeNode, Integer> g) {
        if (root == null) return;
        dfs(root.left, f, g);
        dfs(root.right, f, g);
        f.put(root,root.val + g.getOrDefault(root.left,0) + g.getOrDefault(root.right,0));
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }


    //官方题解
    public int minCameraCoverOthers(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }
}
