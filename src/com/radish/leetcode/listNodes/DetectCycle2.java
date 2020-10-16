package com.radish.leetcode.listNodes;

/**
 * @Description DetectCycle2
 * @Author Radish
 * @Date 2020-10-10 16:47
 */
public class DetectCycle2 {
    public static void main(String[] args) {
        DetectCycle2 d = new DetectCycle2();
//        ListNode node = new ListNode(new int[]{3,2,0,4});
        ListNode node = new ListNode(new int[]{1,2});
//        ListNode nn = node.next.next.next;
//        nn.next = node.next;
        ListNode node1 = d.detectCycle(node);
//        System.out.println(node1.val);
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next, slow = head;
        while (fast.next != null && fast.next.next != null) {
            if (fast == slow) {
                //追上了
                fast = head;
                slow = slow.next;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
