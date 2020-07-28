package com.radish.leetcode.listNodes;

/**
 * @description SwapPairs
 *
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @Author Radish
 * @Date 2020-07-28 15:01:06
 */

public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        /*head.next.next.next = new ListNode(4);*/
        ListNode node = swapPairs(null);
        System.out.println(node);
    }
    //双指针？第一个指针和第二个指针进行交换，可是交换完呢？还要把next也修改掉啊
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = head.next;

        a.next = b.next;
        b.next = a;

        ListNode node = swapPairs(a.next);
        a.next = node;
        return b;
    }
}
