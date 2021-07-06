package com.perye.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 链接：https://leetcode-cn.com/problems/subsets/
 *
 * @author honggd
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(nums, 0, path, ans);
        return ans;
    }

    private void backtrack(int[] nums, int begin, Deque<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        // 从begin开始搜索
        for (int i = begin; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(nums, i + 1, path, ans);
            // 状态重置
            path.removeLast();
        }
    }

}
