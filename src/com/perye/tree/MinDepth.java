package com.perye.tree;

/**
 * 111. 二叉树的最小深度
 * 树、深度优先算法
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author honggd
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return 1 + minDepth;
    }

}
