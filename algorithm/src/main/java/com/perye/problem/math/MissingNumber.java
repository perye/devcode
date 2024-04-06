package com.perye.problem.math;

/**
 * 268. 丢失的数字
 * 数学、位运算
 * 链接：https://leetcode-cn.com/problems/missing-number/
 *
 * @author honggd
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ i ^ nums[i];
        }
        return ans;
    }
}
