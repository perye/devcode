package com.perye.problem.tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 树、深度优先算法
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author honggd
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

}
