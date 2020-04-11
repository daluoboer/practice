package com.radish.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        /*TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        List<Integer> integerList = preorderTraversal(node);
        System.out.println(integerList);
        List<Integer> integerList1 = inorderTraversal(node);
        System.out.println(integerList1);
        List<Integer> integerList2 = postorderTraversal(node);
        System.out.println(integerList2);

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(levelOrder(treeNode));*/
        /*ArrayList<Integer> objects = new ArrayList<>();
        getHeight(10, objects);
        System.out.println(objects.size());
        System.out.println(objects);*/


        /*TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);*/
//        System.out.println(maxDepth(node));
//        System.out.println(isSymmetric(node));
        /*System.out.println(hasPathSum(node,12));
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        System.out.println(hasPathSum(treeNode,8));
        System.out.println(hasPathSum(null,0));
        System.out.println(hasPathSum(treeNode,6));
        System.out.println(hasPathSum(treeNode,7));
        System.out.println(hasPathSum(node,38));
        System.out.println(hasPathSum(node,30));

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        System.out.println(hasPathSum(node1,1));*/

        TreeNode nodeByList = getNodeByList(Arrays.asList(1, 2, 3, 6, 4, 7));
    }

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left!=null) list.addAll(preorderTraversal(root.left));
        if (root.right!=null) list.addAll(preorderTraversal(root.right));
        return list;
    }

    /*前序遍历*/
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> aa = new ArrayList<>();
        if (root != null) {
            aa.add(root.val);
            if (root.left != null) {
                aa.addAll(preorderTraversal(root.left));
            }
            if (root.right != null) {
                aa.addAll(preorderTraversal(root.right));
            }
        }
        return aa;
    }

    /*中序遍历*/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> bb = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                bb.addAll(inorderTraversal(root.left));
            }
            bb.add(root.val);
            if (root.right != null) {
                bb.addAll(inorderTraversal(root.right));
            }
        }
        return bb;
    }

    /*后序遍历*/
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> cc = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                cc.addAll(postorderTraversal(root.left));
            }
            if (root.right != null) {
                cc.addAll(postorderTraversal(root.right));
            }
            cc.add(root.val);
        }
        return cc;
    }

    /**
     * 二叉树的层次遍历
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            setMap(root, 0, lists);
        }
        return lists;
    }

    /**
     * @param node   节点
     * @param number 第几层
     * @param lists  把每一个值以及对应的层数存起来
     */
    public static void setMap(TreeNode node, Integer number, List<List<Integer>> lists) {
        if (lists.size() < number + 1) {
            lists.add(new ArrayList<>());
        }
        if (node != null) {
            List<Integer> list = lists.get(number);
            list.add(node.val);
            if (node.left != null) {
                setMap(node.left, number + 1, lists);
            }
            if (node.right != null) {
                setMap(node.right, number + 1, lists);
            }
        }
    }

    /*根据数组生成一棵二叉树*/
    public static TreeNode getNodeByList(List<Integer> list) {
        TreeNode root = null;
        List<Integer> numberList = new ArrayList<>();
        getHeight(list.size(), numberList);
        int height = numberList.size();
        if (list != null && list.size() > 0) {
            root = new TreeNode(list.get(0));
            setNode(root, list, 1);
        }
        return root;
    }

    /*为父节点节点增加左右节点*/
    public static void setNode(TreeNode node, List<Integer> list, Integer number) {
        if (node != null && list != null && list.size() - 1 > number) {
            node.left = new TreeNode(list.get(number++));
        }
        if (list.size() - 1 > number) {
            node.right = new TreeNode(list.get(number++));
        }
        if (list.size() > number) {
            setNode(node.left, list, number);
            setNode(node.right, list, number);
        }
    }

    /*根据数组长度获得要生成二叉树的高度*/
    public static void getHeight(int length, List<Integer> numberList) {
        if (length > 0) {
            if (numberList.size() > 0) {
                if (length - numberList.get(numberList.size() - 1) * 2 > 0) {
                    length = length - numberList.get(numberList.size() - 1) * 2;
                    System.out.println("numberList.add(" + numberList.get(numberList.size() - 1) * 2 + ")");
                    numberList.add(numberList.get(numberList.size() - 1) * 2);
                    getHeight(length, numberList);
                } else {
                    numberList.add(length);
                    System.out.println("numberList.add(" + length + ")");
                }
            } else {
                numberList.add(1);
                System.out.println("numberList.add(1)");
                getHeight(length - 1, numberList);
            }
        }
    }

    /*获取节点最大深度*/
    public static int maxDepth(TreeNode root) {
        if (root != null) {
            int leftDepth = 0;
            int rightDepth = 0;
            if (root.left != null) {
                leftDepth = maxDepth(root.left);
            }
            if (root.right != null) {
                rightDepth = maxDepth(root.right);
            }
            return leftDepth > rightDepth?leftDepth+1:rightDepth+1;
        }
        return 0;
    }

    /*看看二叉树是否是镜像的*/
    public static boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return isSymmetrics(root.left,root.right);
        }
        return true;
    }

    /*查看左右两课子树是否镜像*/
    public static boolean isSymmetrics(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && isSymmetrics(left.left,right.right) && isSymmetrics(left.right,right.left);
        }
        return false;
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSums(root,sum);
    }

    public static boolean hasPathSums(TreeNode node, int sum) {
        if (node == null) {
            if (sum == 0) return true;
            return false;
        }
        if (node.left == null && node.right == null) {
            if (node.val == sum) return true;
            return false;
        }
        if (node.left != null && node.right != null) {
            return hasPathSums(node.left,sum-node.val) || hasPathSums(node.right,sum-node.val);
        }
        return node.left != null ? hasPathSums(node.left,sum-node.val) : hasPathSums(node.right,sum-node.val);
    }
}
