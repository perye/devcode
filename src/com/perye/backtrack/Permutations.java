package com.perye.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 链接：https://leetcode-cn.com/problems/permutations/
 *
 * @author honggd
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, path, ans, used);
        return ans;
    }

    private static void dfs(int[] nums, Deque<Integer> path, List<List<Integer>> ans, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, path, ans, used);
                used[i] = false;
                path.removeLast();
            }

        }
    }
}
