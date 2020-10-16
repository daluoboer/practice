package com.radish.leetcode.listNodes;

/**
 * @Description AddTwoNumbers
 *
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @Author Radish
 * @Date 2020-10-09 17:09
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
//        ListNode l1 = new ListNode(new int[]{9});
//        ListNode l2 = new ListNode(new int[]{1,9,9,9,9,9,9,9,9,9});
        ListNode listNode = a.addTwoNumbers(l1, l2);
        System.out.println(listNode);

    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //加一个数存一个节点，有进位就把进位存起来
        int curNum = l1.val + l2.val;
        //上一个节点，因为要将上一个节点指向当前节点
        ListNode result = new ListNode(curNum%10);
        curNum/=10;
        ListNode pre = result;
        ListNode ll1 = l1.next, ll2 = l2.next;
        while (ll1 != null || ll2 != null) {
            int v1 = ll1 != null ? ll1.val : 0;
            int v2 = ll2 != null ? ll2.val : 0;
            curNum += v1+v2;
            pre.next = new ListNode(curNum % 10);
            pre = pre.next;
            curNum /= 10;
            ll1 = ll1 == null ? null : ll1.next;
            ll2 = ll2 == null ? null : ll2.next;
        }
        if (curNum > 0) {
            pre.next = new ListNode(curNum);
        }
        return result;
    }
    public ListNode addTwoNumbersNo(ListNode l1, ListNode l2) {
        //这样不行啊！数太大的时候就溢出了，数值就不对啦，那...就加一次存一个节点呗~
        int sum = 0,count = 0;
        ListNode ll1 = l1, ll2 = l2;
        while (ll1 != null || ll2 != null) {
            int v1 = ll1 != null ? ll1.val : 0;
            int v2 = ll2 != null ? ll2.val : 0;
            sum+=Math.pow(10,count++)*(v1 + v2);
            ll1 = ll1 == null ? null : ll1.next;
            ll2 = ll2 == null ? null : ll2.next;
        }
        ListNode result = new ListNode();
        ListNode cur = result;
        if (sum > 0) {
            result.val = sum%10;
            sum/=10;
        }
        while (sum > 0) {
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            sum/=10;
        }
        return result;
    }
}
