package com.radish.leetcode.tree;

import java.util.List;

/**
 * @description RightSideView
 *
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 *   昂？这是什么神奇的题目？就是看到每一层的最右值~
 *
 * @Author Radish
 * @Date 2020-04-22 11:08:29
 */

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //如果是满二叉树，可取到最右的下标
        //如果数组长度大于该值，且该值不为空，则看到该值
        //如果数组长度小于该值，可看到该层非空的最右值
        return null;
    }
}
