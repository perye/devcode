package com.perye.problem.unionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * 947. 移除最多的同行或同列石头
 * 并查集、深度优先算法
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 *
 * @author honggd
 */
public class RemoveStones {

    public static int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();

        for (int[] stone : stones) {
             unionFind.union(~stone[0], stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    /**
     * 并查集
     */
    private static class UnionFind {

        private final Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
            // 两个连通分量合并成为一个，连通分量的总数 -1
            count--;
        }
    }

}
