package com.perye.bfs;

import com.perye.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author honggd
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // root本身就一层，depth初始化为1
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 判断是否到达终点
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                // 将 cur 的相邻节点加入队列
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // 增加步数
            depth++;
        }
        return depth;
    }
}
