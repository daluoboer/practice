package com.radish.leetcode.listNodes;

/**
 * @description MergeKLists
 *
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @Author Radish
 * @Date 2020-04-26 11:09:54
 */

public class MergeKLists {
    public static void main(String[] args) {
        ListNode nodeList = ListNode.createNodeList(new int[]{1, 2, 3}, -1);
        ListNode nodeList1 = ListNode.createNodeList(new int[]{0, 2, 3}, -1);
        ListNode nodeList2 = ListNode.createNodeList(new int[]{1, 4, 6}, -1);

        ListNode node = mergeKLists(new ListNode[]{nodeList, nodeList1, nodeList2});

        System.out.println(node);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        //合并k个链表？啊上次合并俩链表都需要优化呢，暴力法超时了啊
        //不管，先暴力法~
        //有多少个数组就要进行循环呐~只到这个数组没有数据了，咦，可是怎么记录它的位置呢？就是复制到哪个数据了？
        //哎呀！你看错啦！不是数组，是链表呐！
        //噢~~可以放到队列里头？要能进能出的那个，不对不对，那你咋取啊，最后
        //a!可以一边排序一边取值啊！那就要每取一个值拍一次序咯，啊！不行！你排了第一个元素它后面的元素不知道啊，罢了还是每次排序吧
        ListNode curNode = null;
        ListNode min = lists[0];
        ListNode first = null;
        int minIndex = 0;
        int nullSize = 0;
        while (nullSize < lists.length) {
            for (int i = 0; i < lists.length; i++) {
                //如果当前链表已经结束了
                if (lists[i] == null) {
                    nullSize++;
                    continue;
                }
                if(lists[i].val < min.val) {
                    min = lists[i];
                    minIndex = i;
                }
            }

            //找到一个最小值
            if (first == null) {
                first = lists[minIndex];
                lists[minIndex] = first.next;
//                first.next = null;
                curNode = first;
            } else {
                curNode.next = lists[minIndex];
                lists[minIndex] = lists[minIndex].next;
                curNode = curNode.next;
//                curNode.next = null;
            }

            minIndex = 0;
        }

        return first;
    }
}
