package com.radish.leetcode.tree;

/**
 * @Description BSTIterator
 *
 * 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/introduction-to-data-structure-binary-search-tree/xpg4qe/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @Author Radish
 *
 * 嗷！原来中序就是升序噢~
 * @Date 2020-08-19 22:07
 */
public class BSTIterator {
    private TreeNode root;

    private TreeNode curNode;

    private TreeNode maxNode;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /** @return the next smallest number */
    public int next() {
        //e...下一个最小值，那应该在左子树上遍历吧？存储当前遍历到的最小值，每次都从root遍历吗？e...其实不就是二分查找吗？根据这个数找到它的父节
        if (curNode == null) {
            curNode = root;
            while (curNode.left != null) {
                curNode = curNode.left;
            }
        } else {
            if (curNode.right != null) {
                //直接在right这个子树上找最小值即可
                curNode = curNode.right;
                while (curNode.left != null) {
                    curNode = curNode.left;
                }
            } else {
                //找到当前节点所在的位置
                //从左子节点开始找，当左子节点<当前节点时，去右子节点查找
                //当左子节点>当前节点时，去左子节点找
                TreeNode temp = root;
                TreeNode fatherTemp = null;
                while (temp.val != curNode.val) {
                    if (temp.val < curNode.val) {
                        fatherTemp = temp;
                        temp = temp.right;
                    } else {
                        fatherTemp = temp;
                        temp = temp.left;
                    }
                }
                curNode = fatherTemp;
            }
        }
        return curNode.val;
    }

    /** @return whether we have a next smallest number */
    //当前值不是最大值就说明还有
    public boolean hasNext() {
        if (maxNode == null) {
            maxNode = root;
            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }
        }
        if (curNode.val < maxNode.val) {
            return true;
        }
        return false;
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}
