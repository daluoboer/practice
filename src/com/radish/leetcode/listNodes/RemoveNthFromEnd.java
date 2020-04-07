package com.radish.leetcode.listNodes;

import java.util.Scanner;

/**
 * @Description
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @Author Radish
 * @Date 2020/4/1
 */

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请输入链表长度: \n");
            int length = in.nextInt();
            int[] nums = new int[length];
            System.out.println("请输入链表数据：\n");
            for (int i = 0; i < length; i++) {
                nums[i] = in.nextInt();
            }
            ListNode nodeList = ListNode.createNodeList(nums, -1);
            System.out.println("您的链表创建完成：" + nodeList + ", 您要删除倒数第几个数？");
            int n = in.nextInt();
            ListNode node = removeNthFromEnd(nodeList, n);
            System.out.println("处理结果：" + node);
//            break;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //这个又跟双指针有啥关系勒？
        //喔好！知道啦！就是双指针走的比较快嘛！根据双指针可以知道链表的长度，如果倒数第n个在后面的话，慢指针直接过去就行，如果倒数第n个在前面一半，快指针从头遍历即可，所以所以一趟扫描就可以实现啦！
        ListNode fast = head;
        ListNode slow = head;
        int index = 0;
        int total = 0;
        while (fast.next != null && fast.next.next != null) {
            index++;
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时，如果fast是从while中出来的，fast是倒数第二个或者倒数第一个
        if (fast.next == null) {
            total = index * 2 + 1;
        } else {
            total = index * 2 + 2;
        }

        if (total == n) {
            return head.next;
        }
        //要删的是target的下一个
        int target = total - n - 1;
        if (target < index) {
            index = 0;
            slow = head;
        }
        //慢指针直接往后找
        while (target != index) {
            slow = slow.next;
            index++;
        }
        slow.next = slow.next.next;
        //直接返回head呀
        return head;
    }
}
