package com.perye.problem.dp;

/**
 * 70. 爬楼梯
 * 动态规划
 * 链接：https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author honggd
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
