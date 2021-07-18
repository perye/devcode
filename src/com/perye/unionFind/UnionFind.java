package com.perye.unionFind;

/**
 * 基于路径压缩的按秩合并优化的「并查集」
 */
public class UnionFind {

    int[] root;

    /**
     * rank 数组来记录每个顶点的高度，也就是每个顶点的「秩」
     */
    int[] rank;

    /**
     * 连通分量个数
     */
    int count;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            root[i] = i;
            // 一开始每个顶点的初始「秩」为1，因为它们只有自己本身的一个顶点。
            rank[i] = 1;
        }
    }

    /**
     * 查找顶点 x 的根结点
     */
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    /**
     * 连接两个顶点 x 和 y 。将它们的根结点变成相同的，即代表它们来自于同一个根节点
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    /**
     * 检查两个顶点 x 和 y 的「连通性」。
     */
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}