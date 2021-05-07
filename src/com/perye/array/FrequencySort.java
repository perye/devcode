package com.perye.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 1636. 按照频率将数组升序排序
 * 数组、排序
 * 链接：https://leetcode-cn.com/problems/sort-array-by-increasing-frequency/
 *
 * @author honggd
 */
public class FrequencySort {

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(((o1, o2) -> o1.getValue().equals(o2.getValue()) ? o2.getKey() - o1.getKey() : o1.getValue() - o2.getValue()));
        int[] ans = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (int j = 0; j < entry.getValue(); j++) {
                ans[index++] = entry.getKey();
            }
        }
        return ans;
    }

}
