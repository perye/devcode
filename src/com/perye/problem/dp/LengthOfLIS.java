package com.perye.problem.dp;

/**
 * 300. 最长递增子序列
 * 动态规划
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author honggd
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
     }
}
