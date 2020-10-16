package com.radish.leetcode.listNodes;

/**
 * @Description HasCycle1
 * @Author Radish
 * @Date 2020-10-09 15:06
 */
public class HasCycle1 {
    public static void main(String[] args) {
        HasCycle1 h = new HasCycle1();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        boolean b = h.hasCycleOfficial(l1);
        System.out.println(b);
    }

    public boolean hasCycle(ListNode head) {
        boolean has = false;
        ListNode slow = head, fast = head == null ? head : head.next;
        while (fast != null && fast.next != null && fast.next.next != null) {
            if (slow.equals(fast)) {
                has = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return has;
    }

    public boolean hasCycleOfficial(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
