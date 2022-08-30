package com.perye.problem.dp;

/**
 * 64. 最小路径和
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @author perye
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int top = i - 1 >= 0 ? dp[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int left = j - 1 >= 0 ? dp[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(top, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
