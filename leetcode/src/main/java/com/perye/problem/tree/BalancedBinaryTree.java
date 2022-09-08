package com.perye.problem.tree;

/**
 * 110. 平衡二叉树
 * 树、深度优先算法
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author honggd
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
