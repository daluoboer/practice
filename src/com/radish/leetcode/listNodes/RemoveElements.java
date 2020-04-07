package com.example.leetcode.listNodes;

/**
 * @Description
 *
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @Author Radish
 * @Date 2020/4/1
 */

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        ListNode newHead = head;

        while (newHead != null) {
            if (newHead.val == val) {
                newHead = newHead.next;
            } else {
                break;
            }
        }

        if (newHead == null) return null;

        //获取到新的头结点
        ListNode curNode = newHead.next;

        //前一个有效节点
        ListNode prev = newHead;

        while (curNode != null) {
            if (curNode.val == val) {
                prev.next = curNode.next;
                curNode = curNode.next;
            } else {
                //向后走
                prev = curNode;
                curNode = curNode.next;
            }
        }
        return newHead;
    }
}
