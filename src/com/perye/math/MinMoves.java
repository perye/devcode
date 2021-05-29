package com.perye.math;

import java.util.Arrays;

/**
 * 453. 最小操作次数使数组元素相等
 * 数学
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 *
 * @author honggd
 */
public class MinMoves {

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }

}
