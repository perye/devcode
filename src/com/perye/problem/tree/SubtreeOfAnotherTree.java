package com.perye.problem.tree;

/**
 * 572. 另一个树的子树
 * 树、深度优先算法
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree/
 *
 * @author honggd
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

}
