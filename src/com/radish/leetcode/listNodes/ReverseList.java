package com.example.leetcode.listNodes;

/**
 * @Description
 *
 * 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @Author Radish
 * @Date 2020/4/1
 */

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        //prev为第一个元素
        ListNode prev = null;
        ListNode curNode = head;
        //官方解答，我有点晕....
        /*while (curNode != null) {
            ListNode nextTemp = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = nextTemp;
        }*/
        //狗屁！明明就是双指针嘛！
        while (curNode != null) {
            ListNode tempCur = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = tempCur;
        }
        return prev;
    }
}
