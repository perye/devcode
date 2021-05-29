package com.perye.tree;

/**
 * 617. 合并二叉树
 * 树、深度优先算法
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author honggd
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

}
