package com.radish.leetcode.tree;

import com.radish.utils.MyUtils;

import java.util.*;

/**
 * @Description FindMode
 *
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @Author Radish
 * @Date 2020-09-24 08:51
 */
public class FindMode {
    public static void main(String[] args) {
        FindMode f = new FindMode();
        TreeNode node = TreeNode.convertArrToTree(new Integer[]{1, 2, 3, 4, 1, 2, 1, 2});
        int[] mode = f.findMode(node);
        MyUtils.print(mode);
    }
    //噢我想起来了...map只能对key排序，得把它转换成Set才能对value进行排序，嗯....所以你才不知道map要咋排序
    Map<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        //暴力法：那就直接遍历一遍然后存到Map中？
        dfs(root);
        //得到了每个数出现的次数，还要对它进行排序？啊好复杂，不能吧？不是简单题吗，一定是你哪里想得复杂了,哎不过排序的话不一定要循环多少次呢，如果只循环两次，第一次找出最大值，第二次把等于最大值的也找出来，好像也挺简单噢
        //啊！不对！这样不能解决多个众数的情况啊
        //看了一下题解以及评论，看到大家都说简单题不简单我就放心了......
        TreeSet<Map.Entry<Integer,Integer>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()) return -1;
                if (o1.getValue() < o2.getValue()) return 1;
                return 0;
            }
        });
        set.addAll(map.entrySet());

        LinkedList<Integer> list = new LinkedList<>();

        Integer maxV = set.first().getValue();
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (entry.getValue().equals(maxV)) list.add(entry.getKey());
        }

        int[] r = new int[list.size()];
        //嗯...居然这里也踩坑了...
        for (int i = 0; list.size() > 0; i++) {
            r[i] = list.pop();
        }
        return r;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        Integer count = map.getOrDefault(node.val, 0);
        map.put(node.val, count + 1);
        dfs(node.left);
        dfs(node.right);
    }

    int base, count, maxCount;
    List<Integer> anwser = new ArrayList<>();
    public int[] findModeOfficial(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left != null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[anwser.size()];
        for (int i = 0; i < anwser.size(); i++) {
            mode[i] = anwser.get(i);
        }
        return mode;
    }

    private void update(int x) {
        if (x == base) count++;
        else {
            count = 1;
            base = x;
        }

        if (count == maxCount) {
            anwser.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            anwser.clear();
            anwser.add(base);
        }
    }
}
