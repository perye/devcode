package com.perye.problem.tree;

/**
 * 101. 对称二叉树
 * 树、深度优先搜索
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author honggd
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
