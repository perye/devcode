package com.perye.problem.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * 栈、哈希表
 * 链接：https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author honggd
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

}
