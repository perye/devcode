package com.perye.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 * <p>
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array/
 *
 * @author perye
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        // <数值，出现的次数>
        Map<Integer, Integer> map = new HashMap<>();
        // 记录首次出现该值的索引
        Map<Integer, Integer> firstIndex = new HashMap<>();
        // 记录最后出现该值的索引
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int max = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 统计出现的次数
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            // 找出出现最大的次数
            max = Math.max(map.get(nums[i]), max);
            // 只记录第一次出现的值，即为首次出现
            if (!firstIndex.containsKey(nums[i])) {
                firstIndex.put(nums[i], i);
            }
            // 每次出现重复的值都会更新最新索引，一遍遍历之后可以找出最后一次出现的值
            lastIndex.put(nums[i], i);
        }
        for (int num : nums) {
            // 如果该值出现的值等于最大出现次数，更新ans
            if (map.get(num) == max) {
                ans = Math.min(ans, lastIndex.get(num) - firstIndex.get(num) + 1);
            }
        }
        return ans;
    }

}
