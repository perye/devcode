package com.perye.problem.tree;

/**
 * 1123. 最深叶节点的最近公共祖先
 * 树、深度优先算法
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * @author honggd
 */
public class LcaDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) {
            return root;
        } else if (left < right) {
            return lcaDeepestLeaves(root.right);
        } else {
            return lcaDeepestLeaves(root.left);
        }
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

}
