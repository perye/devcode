package com.perye.array;

import java.util.Map;

/**
 * 11. 盛最多水的容器
 * 数组、双指针
 * 链接：https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author honggd
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left <= right) {
            maxArea = Math.max((right - left) * Math.min(height[left], height[right]), maxArea);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

}
