package com.perye.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * 链接：https://leetcode-cn.com/problems/combinations/
 *
 * @author honggd
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(n, k, 1, path, ans);
        return ans;
    }

    private void backtrack(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 从begin开始搜索
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            // 由于每一个元素不可以重复使用，下一轮搜索的起点是i
            backtrack(n, k, i + 1, path, ans);
            // 状态重置
            path.removeLast();
        }
    }

}
