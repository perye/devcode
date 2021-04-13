package com.perye.dp;

/**
 * 53. 最大子序和
 * 数组、分治算法、动态规划
 * 链接：https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author honggd
 */
public class MaxSubArray {

    /**
     * dp
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
