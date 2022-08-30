package com.perye.problem.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. 会议室
 * <p>
 * 链接：https://leetcode-cn.com/problems/meeting-rooms/
 *
 * @author honggd
 */
public class MeetingRooms {

    /**
     * 是否存在重叠区间
     */
    public boolean canAttendMeetings(int[][] intervals) {
        // 将区间按照会议开始实现升序排序
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        // 遍历会议，如果下一个会议在前一个会议结束之前就开始了，返回false
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

}
