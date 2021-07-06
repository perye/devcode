package com.perye.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author honggd
 */
public class MergeIntervals {

    /**
     * 合并区间
     */
    public int[][] merge(int[][] intervals) {
        // 先按照起始位置排序
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        // 遍历区间
        int[][] ans = new int[intervals.length][2];
        int index = 0;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置>结果数组中最后区间的终止位置
            // 则不合并，直接将当前区间加入结果数组。
            if (index == 0 || interval[0] > ans[index - 1][1]) {
                ans[index++] = interval;
            } else {
                // 反之将当前区间合并至结果数组最后区间
                ans[index - 1][1] = Math.max(ans[index - 1][1], interval[1]);
            }
        }
        return Arrays.copyOf(ans, index);
    }

}
