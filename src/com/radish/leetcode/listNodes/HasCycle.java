package com.radish.leetcode.listNodes;

/**
 * @Description
 *
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @Author Radish
 * @Date 2020/3/31
 */

public class HasCycle {
    public static void main(String[] args) {
        ListNode nodeList = ListNode.createNodeList(new int[]{1, 2}, -1);

        boolean b = hasCycle(nodeList);
        System.out.println(b);
    }

    //e...这个其实之前看到过人家说一个快指针一个慢指针，它们总会相遇，既然知道了啥是快慢指针，那就尝试一下吧~
    public static boolean hasCycle(ListNode head) {


        //如果只有<=1个元素，且next为空，说明没有环
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        /*为啥会报空指针呢？感觉不应该报啊*/
        while (slow != fast) {
            if (slow.next == null || fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
