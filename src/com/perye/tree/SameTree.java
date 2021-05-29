package com.perye.tree;

/**
 * 100. 相同的树
 * 树、深度优先搜索
 * 链接：https://leetcode-cn.com/problems/same-tree/
 *
 * @author honggd
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
