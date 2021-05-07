package com.perye.greedy;

/**
 * 1827. 最少操作使数组递增
 * 贪心算法、数组
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing/
 *
 * @author honggd
 */
public class MinOperations {

    public static int minOperations(int[] nums) {
        int ans = 0;
        if (nums.length == 1) {
            return ans;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans = ans + nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }

}
