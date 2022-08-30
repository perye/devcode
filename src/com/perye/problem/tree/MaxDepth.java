package com.perye.problem.tree;

/**
 * 104. 二叉树的最大深度
 * 树、深度优先算法、递归
 * 链接：https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author honggd
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
