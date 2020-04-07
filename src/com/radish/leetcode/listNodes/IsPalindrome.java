package com.radish.leetcode.listNodes;

import java.util.ArrayList;

/**
 * @Description
 *
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
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Radish
 * @Date 2020/3/31
 */

public class IsPalindrome {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head) {
        /*
         * 普通方法~
         */
        //1.遍历链表放到数组中
        //2.遍历数组的第i个元素是否等于第length-i个元素
        //3.如果有！=返回false，否则返回true；
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode curNode = head;
        while (curNode != null) {
            nums.add(curNode.val);
            curNode = curNode.next;
        }
        int length = nums.size();
        for (int i = 0; i < length/2; i++) {
            if (nums.get(i).intValue() != nums.get(length-i-1).intValue()) {
                return false;
            }
        }

        /*
        进阶！快慢指针初体验！
        咦，不是在写这个吗？咋拿起了手机？？
        哦..刚才手机响了，找了一下之前给我打电话那个hr的号码，然后点开了知乎...好了我已经把知乎给删了，技术文章还是没有CSDN的好哎，老是冒出来一些乱七八糟的东西
         */

        //思路：
        //1.先将一半的数据反转，咦，单链表咋进行反转勒？就是把自己交给自己的下一个
        //2.然后比较两条链表


        //找到中点
        ListNode fast = head;
        ListNode slow = head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //反转

        reverse(slow.next);

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }


        return true;
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
