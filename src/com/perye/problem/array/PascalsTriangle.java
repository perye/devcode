package com.perye.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 数组
 * 链接：https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @author honggd
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    list.add(1);
                } else {
                    list.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}