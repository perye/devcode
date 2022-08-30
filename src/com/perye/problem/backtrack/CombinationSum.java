package com.perye.problem.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 39. 组合总和（可重复）
 * <p>
 * 链接：https://leetcode-cn.com/problems/combination-sum/
 *
 * @author honggd
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates.length == 0) {
            return ans;
        }
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(candidates, 0, target, path, ans);
        return ans;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param ans        结果集列表
     */
    public void backtrack(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> ans) {
        // target为负数和0的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 从begin开始搜索
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            // 由于每一个元素可以重复使用，下一轮搜索的起点是i
            backtrack(candidates, i, target - candidates[i], path, ans);
            // 状态重置
            path.removeLast();
        }
    }
}
