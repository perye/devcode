package com.perye.problem.intervals;

import java.util.Arrays;

/**
 * 1288. 删除被覆盖区间
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-covered-intervals/
 *
 * @author honggd
 */
public class RemoveCoveredIntervals {

    /**
     * 删除被覆盖区间
     */
    public int removeCoveredIntervals(int[][] intervals) {
        // 当区间左端点相同时，右端点降序排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        // 需要被删除的区间个数
        int remove = 0;
        int currentRight = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= currentRight) {
                remove++;
            } else {
                currentRight = intervals[i][1];
            }
        }
        return intervals.length - remove;
    }
}

