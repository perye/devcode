package com.perye;

import java.util.*;

/**
 * @author perye
 */
public class Solution {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        int[][] dp = new int[m][n];
        int[][] leftToRight = new int[m][n];
        int[][] rightToLeft = new int[m][n];
        for (int i = 0; i < m; i++) {
            int curMax = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    // 初始化第一行的分数
                    dp[i][j] = points[i][j];
                } else {
                    // 获取上一行的数据
                    int maxLeftIdx = leftToRight[i - 1][j];
                    int maxRightIdx = rightToLeft[i - 1][j];
                    dp[i][j] = Math.max(dp[i - 1][maxLeftIdx] - Math.abs(maxLeftIdx - j), dp[i - 1][maxRightIdx] - Math.abs(maxRightIdx - j)) + points[i][j];
                }
                // 当前坐标的左右最大值
                if (dp[i][j] >= curMax) {
                    leftToRight[i][j] = j;
                    curMax = dp[i][j];
                } else {
                    leftToRight[i][j] = leftToRight[i][j - 1];
                }
            }
            curMax = Integer.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] >= curMax) {
                    rightToLeft[i][j] = j;
                    curMax = dp[i][j];
                } else {
                    rightToLeft[i][j] = rightToLeft[i][j + 1];
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[m - 1][j]);
        }
        return ans;
    }

}
