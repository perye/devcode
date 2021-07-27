package com.perye.moban;

import java.util.Arrays;

/**
 * 二分图带权最大匹配问题
 */
public class IntegerKM {
    private static final int INF = Integer.MAX_VALUE / 2;

    /**
     * 权重矩阵（方阵）
     */
    private int[][] table = null;
    /**
     * X标号值
     */
    private int[] leftLabel = null;
    /**
     * Y标号值
     */
    private int[] rightLabel = null;
    /**
     * X点对应的匹配点
     */
    private int[] leftPartner = null;
    /**
     * Y点对应的匹配点
     */
    private int[] rightPartner = null;
    /**
     * 矩阵维度
     */
    private int n;

    public IntegerKM(int[][] table) {
        this.table = table;
        this.n = table.length;
        this.leftLabel = new int[n];
        this.rightLabel = new int[n];
        Arrays.fill(leftLabel, -INF);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (table[x][y] > leftLabel[x]) {
                    leftLabel[x] = table[x][y];
                }
            }
        }
        this.leftPartner = new int[n];
        this.rightPartner = new int[n];
        Arrays.fill(leftPartner, -1);
        Arrays.fill(rightPartner, -1);
    }

    public int getLeftPartner(int i) {
        return leftPartner[i];
    }

    public int getRightPartner(int i) {
        return rightPartner[i];
    }

    public int getLeftLabel(int i) {
        return leftLabel[i];
    }

    public int getRightLabel(int i) {
        return rightLabel[i];
    }

    /**
     * 入口，输入权重矩阵
     */
    public int solve() {
        for (int x = 0; x < n; x++) {
            bfs(x);
        }
        int value = 0;
        for (int x = 0; x < n; x++) {
            value += table[x][leftPartner[x]];
        }
        return value;
    }

    /**
     * 为一个x点寻找匹配
     */
    private void bfs(int startX) {
        boolean find = false;
        int endY = -1;
        // 标识搜索路径上y点的前一个点
        int[] yPre = new int[n];
        // S集合，T集合
        boolean[] S = new boolean[n], T = new boolean[n];
        // Y点的松弛变量
        int[] slackY = new int[n];
        Arrays.fill(yPre, -1);
        Arrays.fill(slackY, INF);
        // 队列
        int[] queue = new int[n];
        // 队列开始结束索引
        int qs = 0, qe = 0;
        queue[qe++] = startX;
        // 循环直到找到匹配
        while (!find) {
            // 队列不为空
            while (qs < qe && !find) {
                int x = queue[qs++];
                S[x] = true;
                for (int y = 0; y < n; y++) {
                    if (T[y]) {
                        continue;
                    }
                    int tmp = leftLabel[x] + rightLabel[y] - table[x][y];
                    // 相等子树中的边
                    if (tmp == 0) {
                        T[y] = true;
                        yPre[y] = x;
                        if (rightPartner[y] == -1) {
                            endY = y;
                            find = true;
                            break;
                        } else {
                            queue[qe++] = rightPartner[y];
                        }
                        // 不在相等子树中的边，看是否能够更新松弛变量
                    } else if (slackY[y] > tmp) {
                        slackY[y] = tmp;
                        yPre[y] = x;
                    }
                }
            }
            if (find) {
                break;
            }
            int a = INF;
            // 找到最小的松弛值
            for (int y = 0; y < n; y++) {
                if (!T[y]) {
                    a = Math.min(a, slackY[y]);
                }
            }
            // 根据a修改标号值
            for (int i = 0; i < n; i++) {
                if (S[i]) {
                    leftLabel[i] -= a;
                }
                if (T[i]) {
                    rightLabel[i] += a;
                }
            }
            qs = qe = 0;
            // 重要！！！控制修改标号之后需要检查的x点
            for (int y = 0; y < n; y++) {
                // 查看那些y点新加入到T集合，注意，这些y点的前向x点都记录在了yPre里面，所以这些x点不用再次入队
                if (!T[y] && slackY[y] == a) {
                    T[y] = true;
                    // 新加入的y点没有匹配，那么就找到可扩路了
                    if (rightPartner[y] == -1) {
                        endY = y;
                        find = true;
                        break;
                        // 新加入的y点已经有匹配了，将它匹配的x加到队列
                    } else {
                        queue[qe++] = rightPartner[y];
                    }
                }
                // 所有松弛值减去a。(对于T集合中的松弛值已经没用了，对于不在T集合里面的y点，
                // 它们的松弛值是通过S集合中的x点求出的，S集合中的x点的标号值在上面都减去了a，所以这里松弛值也要减去a)
                slackY[y] -= a;
            }
        }
        // 找到可扩路最后的y点后，回溯并扩充
        while (endY != -1) {
            int preX = yPre[endY], preY = leftPartner[preX];
            leftPartner[preX] = endY;
            rightPartner[endY] = preX;
            endY = preY;
        }
    }
}
