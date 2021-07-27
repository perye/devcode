package com.perye;

import java.util.*;

/**
 * @author perye
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            int c = nums[right];
            right++;
            // 更新窗口
            sum += c;
            // 判断是否需要收缩窗口
            while (sum >= target) {
                ans = Math.min(ans, right - left);
                int d = nums[left];
                left++;
                // 更新窗口
                sum -= d;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }



    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(graph, 0, path, ans);
        return ans;
    }

    private void dfs(int[][] graph, int begin, Deque<Integer> path, List<List<Integer>> ans) {
        if (begin == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[begin].length; i++) {
            path.addLast(begin);
            dfs(graph, graph[begin][i], path, ans);
            path.removeLast();
        }
    }


}