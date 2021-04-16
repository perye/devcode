package com.perye.array;

/**
 * 1732. 找到最高海拔
 * 数组
 * 链接：https://leetcode-cn.com/problems/find-the-highest-altitude/
 *
 * @author honggd
 */
public class LargestAltitude {

    public static int largestAltitude(int[] gain) {
        int rev = 0;
        int max = Integer.MIN_VALUE;
        for (int num : gain) {
            rev = rev + num;
            max = Math.max(rev, max);
        }
        return Math.max(max, 0);
    }
}
