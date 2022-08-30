package com.perye.problem.backtrack;

import java.util.*;

/**
 * 90. 子集 II(包含重复元素)
 * <p>
 * 链接：https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author honggd
 */
public class SubsetsWithDup {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(nums, 0, path, ans);
        return ans;
    }

    private static void backtrack(int[] nums, int begin, Deque<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        // 从begin开始搜索
        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i - 1] == nums[i]) {
                continue;
            }
            path.addLast(nums[i]);
            backtrack(nums, i + 1, path, ans);
            // 状态重置
            path.removeLast();
        }
    }

}
