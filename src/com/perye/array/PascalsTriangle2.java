package com.perye.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 数组
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii/
 *
 * @author honggd
 */
public class PascalsTriangle2 {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
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
        return ans.get(rowIndex);
    }

    /**
     * 优化-滚动数组
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

}
