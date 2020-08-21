package com.radish.leetcode.listNodes;

/**
 * @description MergeTwoLists
 *
 *   合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *
 * @Author Radish
 * @Date 2020-05-06 14:13:17
 */

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode n1 = ListNode.createNodeList(new int[]{1, 2, 4}, -1);
        ListNode n2 = ListNode.createNodeList(new int[]{1, 3, 4}, -1);
        ListNode listNode = mergeTwoLists1(n1, n2);
        System.out.println(listNode);
    }
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            ListNode listNode = mergeTwoLists1(l1.next, l2);
            l1.next = listNode;
            return l1;
        } else {
            ListNode listNode = mergeTwoLists1(l1, l2.next);
            l2.next = listNode;
            return l2;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        //拼接两个有序链表
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur ;
        ListNode head;
        if (cur1.val <= cur2.val) {
            head = cur = cur1;
            cur1 = cur1.next;
        } else {
            head = cur = cur2;
            cur2 = cur2.next;
        }

        while (cur1 != null || cur2 != null) {
            if (cur2 == null) {
                cur.next = cur1;
                cur1 = cur1.next;
                cur = cur.next;
                break;
            }
            if (cur1 == null) {
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
                break;
            }

            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
                cur = cur.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
