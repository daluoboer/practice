package com.radish.leetcode.listNodes;

/**
 * @Description
 *
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @Author Radish
 * @Date 2020/4/1
 */

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        //e...啥是原地算法呢？
        if (head == null || head.next == null) return head;

        ListNode evenFirst = head.next;
        //奇数尾巴的下一个就是偶数尾巴
        ListNode odd = head;//奇数尾巴
        ListNode even = head.next;//偶数尾巴

        while (odd != null && odd.next != null && odd.next.next != null) {
            ListNode tempOdd = odd.next.next;
            ListNode tempEven = null;
            if (tempOdd.next != null) {
                tempEven = tempOdd.next;
            }
            odd.next = tempOdd;
            even.next = tempEven;
            odd = odd.next;
            if (even != null) {
                even = even.next;
            }
        }

        odd.next = evenFirst;

        return head;
    }
}
