package com.radish.leetcode.listNodes;

/**
 * @Description MergeTwoLists1
 *
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * @Author Radish
 * @Date 2020-09-30 11:13
 */
public class MergeTwoLists1 {
    public static void main(String[] args) {
        MergeTwoLists1 m = new MergeTwoLists1();
        ListNode l1 = new ListNode(1);
        l1.next(2).next(4);
        ListNode l2 = new ListNode(1);
        l2.next(3).next(4);
        ListNode listNode = m.mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode head = l1.val > l2.val ? l2 : l1;
        head.next = l1.val > l2.val ? mergeTwoLists(l1,l2.next) : mergeTwoLists(l1.next,l2);
        return head;
    }
}
