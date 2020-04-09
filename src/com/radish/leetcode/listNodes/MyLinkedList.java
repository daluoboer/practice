package com.radish.leetcode.listNodes;

public class MyLinkedList {
    private MyListNode head;
    private MyListNode tail;
    private int size;
    class MyListNode {
        int val;
        MyListNode pre;
        MyListNode next;

        public MyListNode() {
        }

        public MyListNode(int val) {
            this.val = val;
        }

        public MyListNode(int val, MyListNode pre, MyListNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public MyListNode getPre() {
            return pre;
        }

        public void setPre(MyListNode pre) {
            this.pre = pre;
        }

        public MyListNode getNext() {
            return next;
        }

        public void setNext(MyListNode next) {
            this.next = next;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) return -1;
        else {
            MyListNode node = getNodeByIndex(index);
            return node == null ? -1 : node.val;
        }
    }

    private MyListNode getNodeByIndex(int index) {
        if (index > size) return null;
        if (index == 0) return head;
        if (index == size - 1) return tail;
        /*遍历，从前或后*/
        MyListNode curNode;
        int curIndex;
        if (index < size/2) {
            //从前
            curNode = head;
            curIndex = 0;
            while (curIndex < index) {
                curNode = curNode.next;
                curIndex++;
            }
        } else {//从后
            curNode = tail;
            curIndex = size - 1;
            while (curIndex > index) {
                curNode = curNode.pre;
                curIndex--;
            }
        }
        return curNode;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyListNode newHead = new MyListNode(val);
        if (size == 0) {
            head = tail = newHead;
            size++;
            return;
        }
        newHead.next = head;
        head.pre = newHead;
        head = newHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }
        MyListNode newTail = new MyListNode(val);
        tail.next = newTail;
        newTail.pre = tail;
        tail = newTail;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        //头插
        if (index == 0) {
            addAtHead(val);
            return;
        }
        //中间插
        if (index < size) {
            MyListNode node = getNodeByIndex(index);
            if (node != null) {
                MyListNode pre = node.pre;
                MyListNode newNode = new MyListNode(val);
                pre.next = newNode;
                newNode.pre = pre;
                newNode.next = node;
                node.pre = newNode;
                size++;
            }
            return;
        }
        //尾插
        addAtTail(val);
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        //删除头结点
        if (index == 0) {
            if (size > 0) {
                head = head.next;
                if (head != null) head.pre = null;
                size--;
            }
            return;
        }
        //删除尾结点
        if (index == size - 1) {
            tail = tail.pre;
            if (tail != null) tail.next = null;
            size--;
            return;
        }
        //删除中间节点
        if (index < size) {
            MyListNode node = getNodeByIndex(index);
            MyListNode pre = node.pre;
            MyListNode next = node.next;
            if (pre != null) pre.next = next;
            if (next != null) next.pre = pre;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        MyListNode curNode = head;
        while (curNode != null) {
            s.append(curNode.val + ",");
            curNode = curNode.next;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        /*MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        System.out.println("obj.get(1): "+obj.get(1));
        obj.deleteAtIndex(1);
        System.out.println("obj.get(1): "+obj.get(1));
        System.out.println(obj);*/
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.deleteAtIndex(0);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
