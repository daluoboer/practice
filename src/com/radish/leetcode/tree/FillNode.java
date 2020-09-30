package com.radish.leetcode.tree;

import java.util.ArrayList;

/**
 * @Description FillNode
 *
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 *
 * 提示：
 *
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 *
 * @Author Radish
 * @Date 2020-09-28 11:00
 */
public class FillNode {
    public static void main(String[] args) {
        FillNode f = new FillNode();
        Node node = new Node(1);
        node.left = new Node(2);
//        node.right = new Node(3);
        Node connect = f.connect(node);
        System.out.println(connect);
    }


    public Node connect(Node root) {
        return null;
    }


    // en....超出内存限制....好像是null太多了，不应该存储null哎 看看题解吧
    public Node connectMemoryBig(Node root) {
        if (root == null) return null;
        //a是下一个右侧节点而不是右子节点
        //可以将数组遍历到数组中，可以那就不是常量级额外空间了哎，是啊，o(n)啊
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(root);
        int depth = 1;
        if (root.left != null || root.right != null) depth = addNodeToList(1, nodes);
        addNextNode(nodes,depth);
        return root;
    }

    private void addNextNode(ArrayList<Node> nodes, int depth) {
        //层序...
        for (int i = 1; i <= depth; i++) {
            int head = (int)Math.pow(2, i - 1) - 1;
            int tail = (int)Math.pow(2,i) - 2;
            int j = head, k;
            while (j < tail) {
                while (j < tail) {
                    if (nodes.get(j) == null) j++;
                    else break;
                }
                k = j + 1;
                while (k <= tail) {
                    if (nodes.get(k) == null) k++;
                    else break;
                }

                if (k <= tail) {
                    nodes.get(j).next = nodes.get(k);
                }
                j = k;
            }
        }
    }

    private int addNodeToList(int depth, ArrayList<Node> nodes) {
        //当前要遍历的是第几层，从第几层往下拓展下一层~
        //第n层,元素总数量2^n-1,第一个元素为2^(n-1)个
        //所以第n层，第一个元素：2^(n-1)-1在，最后一个元素：2^n-2
        int head = (int)Math.pow(2, depth - 1) - 1;
        int tail = (int)Math.pow(2,depth) - 2;
        int count = 0;
        depth = depth + 1;
        for (int i = head; i <= tail; i++) {
            Node node = nodes.get(i);
            if (node == null) {
                nodes.add(null);nodes.add(null);
            } else {
                //本轮添加的节点有子节点才需要下一轮遍历
                if ((node.left != null && (node.left.left != null || node.left.right != null))
                        || (node.right != null && (node.right.left != null || node.right.right != null))) {
                    count++;
                }
                nodes.add(node.left);
                nodes.add(node.right);
            }
        }
        if (count > 0) depth = addNodeToList(depth, nodes);
        return depth;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};