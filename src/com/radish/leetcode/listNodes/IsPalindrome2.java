package com.radish.leetcode.listNodes;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome2 {
    public boolean isPalindrome(ListNode head) {

        boolean flag = true;

        //双指针

        ListNode a = head;
        ListNode b = head;
        while (b.next != null && b.next.next != null) {
            a = a.next;
            b = b.next.next;
        }

        //先找到中点，翻转后半段？再进行比较？
        //可不可以从中点直接比较？不行？不能往前，嗷！可以用栈哎！前一半都塞到栈里头，从中点开始弹栈！哇！机智！不过要开辟新空间。
        //
        return false;
    }
}
