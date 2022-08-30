package com.perye.problem.tree;

/**
 * 938. 二叉搜索树的范围和
 * 树、深度优先搜索
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst/
 *
 * @author honggd
 */
public class RangeSumBST {


    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

}
