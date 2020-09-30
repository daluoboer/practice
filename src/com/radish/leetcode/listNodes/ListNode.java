package com.radish.leetcode.listNodes;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/31
 */

public class ListNode {
     public int val;
     public ListNode next;

     ListNode() {}

     ListNode(int x) { val = x; }

     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public ListNode next(int x) {
         next = new ListNode(x);
         return next;
     }

    @Override
    public String toString() {
         ListNode cur = next;
         StringBuilder s = new StringBuilder(val + ", ");
         while (cur != null) {
             s.append(cur.val + ", ");
             cur = cur.next;
         }
         return s.toString();
    }

    public static ListNode createNodeList(int[] nums, int pos) {

         if (nums == null || nums.length == 0) return null;
         ListNode last = new ListNode(nums[0]);
         ListNode head = last;
         ListNode posNode = null;
         //怎样生成链表
         for (int i = 1; i < nums.length;i++) {
             ListNode cur = new ListNode(nums[i]);
             last.next = cur;
             last = cur;
             if (pos == i) {
                 posNode = cur;
             }
         }
         if (pos == 0) {
             last.next = head;
         }

         if (pos > 0) {
             //找到该节点并赋值
             last.next = posNode;
         }

         return head;
     }
 }
