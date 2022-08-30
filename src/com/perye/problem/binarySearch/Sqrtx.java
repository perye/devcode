package com.perye.problem.binarySearch;

/**
 * 69. x 的平方根
 * 二分查找、数学
 * 链接：https://leetcode-cn.com/problems/sqrtx/
 *
 * @author honggd
 */
public class Sqrtx {

    public static int mySqrt(int x) {
        int left = 1;
        int right = x >> 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }




}
