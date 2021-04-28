package com.perye.dp;

/**
 * 746. 使用最小花费爬楼梯
 * 动态规划
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @author honggd
 */
public class MinCostClimbingStairs {

    /**
     * dp
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[length];
    }

}
