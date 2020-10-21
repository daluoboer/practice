package com.radish.leetcode.listNodes;

/**
 * @Description ReorderList
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * @Author Radish
 * @Date 2020-10-20 08:35
 */
public class ReorderList {
    public static void main(String[] args) {
        ReorderList r = new ReorderList();
//        int[] ints = new int[]{1,2,3,4,5};
//        int[] ints = new int[]{1,2,3,4};
//        int[] ints = new int[]{1,2,3};
//        int[] ints = new int[]{1,2};
//        int[] ints = new int[]{1};
//        int[] ints = new int[]{};
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        ListNode node = new ListNode(ints);
        r.reorderList(node);
        System.out.println(node);
    }
    public void reorderList(ListNode head) {
        //应该把后半截先反转，这样才能在之后一次遍历，否则每个数都得遍历一遍啊，嗯~
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            if (fast.next.next != null) fast = fast.next.next;
            else fast = fast.next;
        }
        //fast已经是最后一个节点，slow为前半部分的最后一个节点，从slow的下一个节点开始为后半段
        //翻转后半段
        ListNode pre = null, cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            if (temp == null) break;
            cur = temp;
        }
        //双指针，从两端上一个一个增加即可
        fast = cur;
        slow = head.next;
        cur = head;
        while (slow != null || fast != null) {
            if (fast != null) {
                cur.next = fast;
                cur = cur.next;
                fast = fast.next;
            }

            if (slow != null) {
                cur.next = slow;
                cur = cur.next;
                slow = slow.next;
            }
        }
    }
}
