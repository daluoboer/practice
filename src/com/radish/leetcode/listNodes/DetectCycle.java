package com.radish.leetcode.listNodes;

import java.util.HashSet;

/**
 * @Description
 * 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 * @Author Radish
 * @Date 2020/4/1
 */

public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = ListNode.createNodeList(new int[]{1, 2, 3,4,5}, 4);
        detectCycle2(head);
    }

    //先有额外空间的方法：TreeSet
    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            if (nodes.contains(cur)) {
                //找下标，嘤嘤嘤，不能简单一点？还得遍历啊
                ListNode first = head;
                while (!first.equals(cur)) {
                    first = first.next;
                    i++;
                }
                System.out.println("tail connects to node index " + i);
                return cur;
            }
            nodes.add(cur);
            cur = cur.next;
        }
        System.out.println("no cycle");
        return null;
    }


    //下面是双指针
    public static ListNode detectCycle2(ListNode head) {

        //慢的指针就是位置，可以记录下它的index？但是还是利用了额外空间啊

        //嗨呀！不需要自己输出index，是人家输出的！

        if (head == null || head.next == null) {
            //System.out.println("no cycle");
            return null;
        }
        //int index = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                //不对呀，这样只是记录了第一次快慢指针相遇的地方~

                //哇哦，大家好厉害哦，怎么想到这么神奇的办法的！
                //相遇的节点找到了，现在从头开始走，和从相遇点开始走
                fast = head;
                while (slow != fast) {
                    //index++;
                    slow = slow.next;
                    fast = fast.next;
                }
                //System.out.println("tail connects to node index " + index);
                return slow;
            }
        }
        //System.out.println("no cycle");
        return null;
    }
}
