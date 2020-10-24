package com.radish.leetcode.listNodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description IsPalindrome1
 *
 * 234. 回文链表
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
 *
 * @Author Radish
 * @Date 2020-10-23 08:53
 */
public class IsPalindrome1 {
    public static void main(String[] args) {
        IsPalindrome1 is = new IsPalindrome1();
//        ListNode node = new ListNode(new int[]{1, 2});
//        ListNode node = new ListNode(new int[]{1, 2, 1});
//        ListNode node = new ListNode(new int[]{1, 2,2, 1});
        ListNode node = new ListNode(new int[]{1});
        boolean palindrome = is.isPalindrome(node);
        System.out.println(palindrome);
    }
    public boolean isPalindrome(ListNode head) {
        //1.通过快慢指针找到中点，反转后半部分再比较，用完链表最好再恢复
        //2.直接将节点存到数组中，用前后俩指针同时走
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        int start = 0, end = nodes.size() - 1;
        while (start < end) {
            ListNode node = nodes.get(start);
            ListNode node1 = nodes.get(end);
            if (node != null && node1 != null && node.val == node1.val) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
