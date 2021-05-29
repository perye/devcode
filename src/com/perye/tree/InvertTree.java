package com.perye.tree;

/**
 * 226. 翻转二叉树
 * 树
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author honggd
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
