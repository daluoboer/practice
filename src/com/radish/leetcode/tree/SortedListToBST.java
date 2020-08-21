package com.radish.leetcode.tree;

import com.radish.leetcode.listNodes.ListNode;

/**
 * @Description SortedListToBST
 *
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @Author Radish
 * @Date 2020-08-18 21:51
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        //e..之前竟然做过而且还做得很简单，啧啧啧...要重回智商巅峰了呀，就是把有序数组转换为高度平衡二叉搜索树，只不过这里把数组改成单链表了而已~那就把链表先转化为数组？
        //这么一看，好像树挺简单的呀？那你还有啥不会？还有各种排序，还是要复习一下还有查找树啊队列啊栈啊还是要复习一下~这些都比较基础嘛
        //a,根本就不能获取到val？因为没有在一个包里嘛~改成public吧~
        //但是这种方法也太愚蠢了吧！因为得转换来转换去的~关键就是怎么利用单链表呐~双指针找到中点，然后拆成左子树右子树，哎，可是怎么知道左子树或右子树取值到哪里呢？

        //哇！！！！人家写的也太厉害廖！！！！！！膜拜！！！！！
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        //循环后得到中点p
        while (q != null && q.next != null) {
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }
        //中点断开
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
}
