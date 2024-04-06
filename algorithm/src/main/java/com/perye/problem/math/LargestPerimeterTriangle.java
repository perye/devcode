package com.perye.problem.math;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * 排序、数学、贪心
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle/
 *
 * @author honggd
 */
public class LargestPerimeterTriangle {

    /**
     * 贪心+排序
     * @param nums
     * @return
     */
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }


    /**
     * 暴力(超时)
     * @param nums
     * @return
     */
    public static int largestPerimeter2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isTriangle(nums[i], nums[j], nums[k])) {
                        ans = Math.max(ans, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return ans;
    }



    private static boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

}
