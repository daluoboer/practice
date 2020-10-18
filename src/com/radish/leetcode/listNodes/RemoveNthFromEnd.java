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
        RemoveNthFromEnd r = new RemoveNthFromEnd();
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
            ListNode node = r.removeNthFromEnd(nodeList, n);
            System.out.println("处理结果：" + node);
//            break;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快慢指针，快指针计算节点总数，可以根据节点总数计算出该节点是正数第几个节点，此时慢指针在中点位置，如果n在前半部分，从head节点遍历即可，如果在后半部分，从慢节点处遍历即可
        if (head == null) return null;
        ListNode slow = head, fast = head;
        int length = 1;
        while (fast != null && fast.next != null) {
            if (fast.next != null) {
                length+=1;
                if (fast.next.next != null) {
                    length+=1;
                }
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
        }
        //得到length，获取index
        //慢指针index
        int slowI = (length - 1)/2 + (length - 1)%2;
        int targetI = length - n;
        if (targetI == 0) {
            return head.next;
        }

        if (slowI > targetI-1) {
            //从头开始遍历
            slow = head;
            slowI = 0;
        }
        //从slowI开始往后遍历
        while (slowI < targetI-1) {
            slow = slow.next;
            slowI++;
        }
        //要删除的是slow节点
        //啊！删除节点最重要的是找到上一个节点啊
        slow.next = slow.next.next;
        return head;
    }
    public static ListNode removeNthFromEndOld(ListNode head, int n) {
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
