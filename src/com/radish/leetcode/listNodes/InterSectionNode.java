package com.example.leetcode.listNodes;

/**
 * @Description
 *
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @Author Radish
 * @Date 2020/4/1
 */

public class InterSectionNode {
    public static void main(String[] args) {

    }
    /*en....这可咋整捏*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //如果用HashSet可以求出来，就是遍历嘛~用双指针？怎么求呢
        //啊！人家的脑子是咋长的啊！咋想得出来这么神奇的方法勒？！
        //a+b=b+a
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int times = 0;
        //先走到最后一个节点
        while (!nodeA.equals(nodeB)) {
            //nodeA先遍历A，然后遍历B；nodeB先遍历B，然后遍历A；但是怎么判断A已经走完B但是没有相交呢？,如果又走回到自己的原点了，说明一直没有相交的元素啊,咦但是不会回到原点呀？
            if (nodeA.next != null) {
                nodeA = nodeA.next;
            } else {
                nodeA = headB;
                times++;
            }

            if (nodeB.next != null) {
                nodeB = nodeB.next;
            } else {
                nodeB = headA;
                times++;
            }

            if (times>2) {
                return null;
            }
        }

        return nodeA;
    }
}
